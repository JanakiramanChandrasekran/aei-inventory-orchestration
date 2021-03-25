package com.aei.product.inventory.api.resource;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aei.product.inventory.api.model.Store;
import com.aei.product.inventory.api.service.InventoryService;

/**
 * Prototyping : Service that pulls the inventory by store with basic exception
 * handling & native sql query - With JPA, relationship can be simplified but i
 * used native sql query
 * 
 */
@Named
@Path("/sell/inventory/api/v1")
@Singleton
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {

	private static final Logger logger = LoggerFactory.getLogger(InventoryResource.class);

	@Inject
	private InventoryService service;

	/**
	 * Prototyping : service to receive inventory by store
	 * 
	 * @param id
	 * @param messageId
	 * @param traceId
	 * @param event
	 * @return
	 */
	@GET
	@Path("/store/{storeId}")
	public Store inventoryByStore(@PathParam("storeId") final long id,
			@PathParam("x-message-id") final String messageId, @PathParam("x-trace-id") final String traceId) {
		try {
			final Store store = service.getInventoryByStore(id);
			if (store != null) {
				logger.info("GetInventoryByStoreEvent", kv("MessageId", messageId), kv("TraceId", traceId),
						kv("StoreId", id), kv("response", store), kv("success", "true"));
				return store;
			}
		} catch (final Exception e) {
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.info("GetInventoryByStoreEvent", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("StoreId", id), kv("success", "false"));
			logger.error("GetInventoryByStoreEvent-Troubleshoot", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("StoreId", id), kv("CustomStackTrace", sw.toString()));
			throw new InternalServerErrorException(e);
		}
		logger.info("GetInventoryByStoreEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("StoreId", id),
				kv("success", "notfound"));
		throw new NotFoundException(Response.status(404)
				.entity(new com.aei.product.inventory.api.model.Error("Store Doesn't exist")).build());
	}

	/**
	 * Prototyping : service to receive state of store
	 * 
	 * @param id
	 * @param messageId
	 * @param traceId
	 * @param event
	 * @return
	 */
	@GET
	@Path("/{inventoryId}")
	public Store getByInventory(@PathParam("inventoryId") final long id,
			@PathParam("x-message-id") final String messageId, @PathParam("x-trace-id") final String traceId) {
		try {
			final Store store = service.getByInventory(id);
			if (store != null) {
				logger.info("GetByInventoryEvent", kv("MessageId", messageId), kv("TraceId", traceId),
						kv("StoreId", id), kv("response", store), kv("success", "true"));
				return store;
			}
		} catch (final Exception e) {
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.info("GetByInventoryEvent", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("StoreId", id), kv("success", "false"));
			logger.error("GetByInventoryEvent-Troubleshoot", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("StoreId", id), kv("CustomStackTrace", sw.toString()));
			throw new InternalServerErrorException(e);
		}
		logger.info("GetByInventoryEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("StoreId", id),
				kv("success", "notfound"));
		throw new NotFoundException(Response.status(404)
				.entity(new com.aei.product.inventory.api.model.Error("Inventory Doesn't exist")).build());
	}

}
