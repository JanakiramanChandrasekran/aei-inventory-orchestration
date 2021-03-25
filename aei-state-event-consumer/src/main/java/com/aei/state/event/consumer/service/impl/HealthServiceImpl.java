/**
 * 
 */
package com.aei.state.event.consumer.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.aei.state.event.consumer.model.HealthEvent;
import com.aei.state.event.consumer.repository.EquipmentRepository;
import com.aei.state.event.consumer.repository.StoreRepository;
import com.aei.state.event.consumer.service.HealthService;

@Named
public class HealthServiceImpl implements HealthService {

	@Inject
	private StoreRepository storeRepository;
	
	@Inject
	private EquipmentRepository equipmentRepository;

	/**
	 * Update the store availability in DB - Just a prototyping, enterprise
	 * applications should have a cache to turbo charge
	 * 
	 * @param id
	 * @param event
	 */
	public void updateStoreState(final long id, final HealthEvent event) {
		storeRepository.updateStoreState(event.isAvailable(), id);
	}
	
	/**
	 * Update the equipment availability in DB - Just a prototyping, enterprise
	 * applications should have a cache to turbo charge
	 * 
	 * @param id
	 * @param event
	 */
	public void updateEquipmentState(final String mac, final HealthEvent event) {
		equipmentRepository.updateEquipmentState(event.isAvailable(), mac);
	}

}
