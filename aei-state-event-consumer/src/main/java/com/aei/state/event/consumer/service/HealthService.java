/**
 * 
 */
package com.aei.state.event.consumer.service;

import com.aei.state.event.consumer.model.HealthEvent;

public interface HealthService {
	
	void updateStoreState(final long id, final HealthEvent event);
	
	void updateEquipmentState(final String mac, final HealthEvent event);

}
