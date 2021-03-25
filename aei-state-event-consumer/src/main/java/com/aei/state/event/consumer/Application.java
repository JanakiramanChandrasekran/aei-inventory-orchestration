package com.aei.state.event.consumer;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aei.state.event.consumer.resource.HealthEventResource;
import com.aei.state.event.consumer.resource.PingResource;

@SpringBootApplication
public class Application extends ResourceConfig {

	/**
	 * Registering the resource classes
	 */
	public Application() {
		register(HealthEventResource.class);
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
