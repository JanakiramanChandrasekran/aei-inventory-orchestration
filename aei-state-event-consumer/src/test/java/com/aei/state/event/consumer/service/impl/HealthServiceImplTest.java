/**
 * 
 */
package com.aei.state.event.consumer.service.impl;

import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aei.state.event.consumer.model.HealthEvent;
import com.aei.state.event.consumer.repository.EquipmentRepository;
import com.aei.state.event.consumer.repository.StoreRepository;

/**
 * Tests for {@link HealthServiceImpl}
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class HealthServiceImplTest {

	@InjectMocks
	private HealthServiceImpl service;

	@Mock
	private StoreRepository storeRepository;

	@Mock
	private EquipmentRepository equipmentRepository;

	/**
	 * {@link HealthServiceImpl#updateStoreState(long, aei.health.event.consumer.model.HealthEvent)}
	 */
	@Test
	public void updateStoreStateTest() {
		doNothing().when(storeRepository).updateStoreState(false, 100);
		service.updateStoreState(100, new HealthEvent());
	}

	/**
	 * {@link HealthServiceImpl#updateEquipmentState(String, HealthEvent)}
	 */
	@Test
	public void updateEquipmentStateTest() {
		doNothing().when(equipmentRepository).updateEquipmentState(false, "100");
		service.updateEquipmentState("100", new HealthEvent());
	}

}
