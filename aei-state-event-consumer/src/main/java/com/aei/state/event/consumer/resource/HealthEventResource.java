package com.aei.state.event.consumer.resource;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aei.state.event.consumer.model.HealthEvent;
import com.aei.state.event.consumer.service.HealthService;

/**
 * Prototyping : Service that mimic's the event messaging with the health of
 * store and equipment in the form of REST API
 *
 */

@Named
@Path("/event/state")
@Singleton
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthEventResource {

	private static final Logger logger = LoggerFactory.getLogger(HealthEventResource.class);

	@Inject
	private HealthService service;

	/**
	 * Prototyping : service to receive & update state of store
	 * 
	 * @param id
	 * @param messageId
	 * @param traceId
	 * @param event
	 * @return
	 */
	@PUT
	@Path("/store/{storeId}")
	public Response storeEvent(@PathParam("storeId") final long id, @PathParam("x-message-id") final String messageId,
			@PathParam("x-trace-id") final String traceId, final HealthEvent event) {
		try {
			service.updateStoreState(id, event);
			logger.info("StoreStateEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("StoreId", id),
					kv("health", event.isAvailable() ? "healthy" : "unhealthy"), kv("success", "true"));
			return Response.noContent().build();
		} catch (final Exception e) {
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error("StoreStateEventError-Troubleshoot", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("StoreId", id), kv("CustomStackTrace", sw.toString()));
			logger.info("StoreStateEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("StoreId", id),
					kv("health", event.isAvailable() ? "healthy" : "unhealthy"), kv("success", "false"));
			return Response.serverError().build();
		}
	}

	/**
	 * Prototyping : service to receive & update state of equipment
	 * 
	 * @param id
	 * @param messageId
	 * @param traceId
	 * @param event
	 * @return
	 */
	@PUT
	@Path("/equipment/{mac}")
	public Response equipmentEvent(@PathParam("mac") final String mac, @PathParam("x-message-id") final String messageId,
			@PathParam("x-trace-id") final String traceId, final HealthEvent event) {
		try {
			service.updateEquipmentState(mac, event);
			logger.info("EquipmentStateEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("Mac", mac),
					kv("health", event.isAvailable() ? "healthy" : "unhealthy"), kv("success", "true"));
			return Response.noContent().build();
		} catch (final Exception e) {
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error("EquipmentStateEvent-Troubleshoot", kv("MessageId", messageId), kv("TraceId", traceId),
					kv("Mac", mac), kv("CustomStackTrace", sw.toString()));
			logger.info("EquipmentStateEvent", kv("MessageId", messageId), kv("TraceId", traceId), kv("Mac", mac),
					kv("health", event.isAvailable() ? "healthy" : "unhealthy"), kv("success", "false"));
			return Response.serverError().build();
		}
	}

}
