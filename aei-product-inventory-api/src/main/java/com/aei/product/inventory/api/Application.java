package com.aei.product.inventory.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aei.product.inventory.api.resource.InventoryResource;
import com.aei.product.inventory.api.resource.PingResource;

@SpringBootApplication
public class Application extends ResourceConfig {

	/**
	 * Registering the resource classes
	 */
	public Application() {
		register(InventoryResource.class);
		register(PingResource.class);
	}

	/**
	 * Booting the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
