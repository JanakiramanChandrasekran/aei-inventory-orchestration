/**
 * 
 */
package com.aei.state.event.consumer.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import javax.ws.rs.InternalServerErrorException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aei.state.event.consumer.model.HealthEvent;
import com.aei.state.event.consumer.resource.HealthEventResource;
import com.aei.state.event.consumer.service.HealthService;

/**
 * Tests for {@link HealthEventResource}
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class HealthEventResourceTest {

	@InjectMocks
	private HealthEventResource resource;

	@Mock
	private HealthService service;

	/**
	 * {@link HealthEventResource#storeEvent(long, String, String, HealthEvent)}
	 */
	@Test
	public void healthEventStoreTestValid() {
		final HealthEvent healthEvent = new HealthEvent();
		healthEvent.setAvailable(Boolean.FALSE);
		doNothing().when(service).updateStoreState(100, healthEvent);
		assertEquals(204, resource.storeEvent(100, "Test", "Trace", healthEvent).getStatus());
	}

	/**
	 * {@link HealthEventResource#storeEvent(long, String, String, HealthEvent)}
	 */
	@Test
	public void healthEventStoreTestException() {
		final HealthEvent healthEvent = new HealthEvent();
		healthEvent.setAvailable(Boolean.FALSE);
		doThrow(InternalServerErrorException.class).when(service).updateStoreState(100, healthEvent);
		assertEquals(500, resource.storeEvent(100, "Test", "Trace", healthEvent).getStatus());
	}

	/**
	 * {@link HealthEventResource#equipmentEvent(String, String, String, HealthEvent)}
	 */
	@Test
	public void healthEventEquipmentTestValid() {
		final HealthEvent healthEvent = new HealthEvent();
		healthEvent.setAvailable(Boolean.FALSE);
		doNothing().when(service).updateEquipmentState("100", healthEvent);
		assertEquals(204, resource.equipmentEvent("100", "Test", "Trace", healthEvent).getStatus());
	}

	/**
	 * {@link HealthEventResource#equipmentEvent(String, String, String, HealthEvent)}
	 */
	@Test
	public void healthEventEquipmentTestException() {
		final HealthEvent healthEvent = new HealthEvent();
		healthEvent.setAvailable(Boolean.FALSE);
		doThrow(InternalServerErrorException.class).when(service).updateEquipmentState("100", healthEvent);
		assertEquals(500, resource.equipmentEvent("100", "Test", "Trace", healthEvent).getStatus());
	}

}
