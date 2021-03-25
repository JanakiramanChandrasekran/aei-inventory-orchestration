/**
 * 
 */
package com.aei.product.inventory.api.resource;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

/**
 * Ping Resource
 * 
 *
 */
@Named
@Path("/sell/inventory/api/v1")
@Singleton
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PingResource {

	/**
	 * Health of the Service
	 * 
	 * @return
	 */
	@GET
	@Path("/health")
	public boolean health() {
		return Boolean.TRUE;
	}

}
