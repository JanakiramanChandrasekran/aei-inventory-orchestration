/**
 * 
 */
package com.aei.product.inventory.api.service;

import com.aei.product.inventory.api.model.Store;

public interface InventoryService {
	
	Store getInventoryByStore(final long id);
	
	Store getByInventory(final long id);

}
