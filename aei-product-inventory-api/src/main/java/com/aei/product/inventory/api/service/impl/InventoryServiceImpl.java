/**
 * 
 */
package com.aei.product.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.aei.product.inventory.api.model.Inventory;
import com.aei.product.inventory.api.model.Store;
import com.aei.product.inventory.api.repository.InventoryRepository;
import com.aei.product.inventory.api.repository.StoreInventoryModel;
import com.aei.product.inventory.api.service.InventoryService;

@Named
public class InventoryServiceImpl implements InventoryService {

	@Inject
	private InventoryRepository storeInventoryRepository;

	/**
	 * Get the inventory list by Store - Just a prototyping, Model class is not
	 * created with relationships
	 * 
	 * @param id
	 */
	public Store getInventoryByStore(final long id) {
		final List<StoreInventoryModel> list = storeInventoryRepository.getInventoryByStore(id);
		if (CollectionUtils.isNotEmpty(list)) {
			final Store store = new Store();
			store.setStoreId(list.get(0).getStoreid());
			store.setStoreName(StringUtils.trimToNull(list.get(0).getStoreName()));
			store.setStoreAvailability(list.get(0).isStoreAvailability());
			store.setInventoryList(list.stream().map(storeInventoryModel -> {
				final Inventory inventory = new Inventory();
				inventory.setCategoryName(StringUtils.trimToNull(storeInventoryModel.getProductCategory()));
				inventory.setInventoryId(storeInventoryModel.getInventoryId());
				inventory.setPriceList(storeInventoryModel.getPriceList());
				inventory.setPriceMin(storeInventoryModel.getPriceMin());
				inventory.setProductAvailability(
						store.isStoreAvailability() ? storeInventoryModel.isProductAvailability() : Boolean.FALSE);
				inventory.setProductDescription(StringUtils.trimToNull(storeInventoryModel.getProductDesc()));
				inventory.setProductName(StringUtils.trimToNull(storeInventoryModel.getProductName()));
				return inventory;
			}).collect(Collectors.toList()));
			return store;
		}
		return null;
	}

	/**
	 * Get detail by inventory id
	 * 
	 * @param id
	 */
	public Store getByInventory(final long id) {
		final StoreInventoryModel inventoryModel = storeInventoryRepository.getByInventory(id);
		if (inventoryModel != null) {
			final Store store = new Store();
			store.setStoreId(inventoryModel.getStoreid());
			store.setStoreName(StringUtils.trimToNull(inventoryModel.getStoreName()));
			store.setStoreAvailability(inventoryModel.isStoreAvailability());
			store.setInventoryList(new ArrayList<>(1));
			final Inventory inventory = new Inventory();
			inventory.setCategoryName(StringUtils.trimToNull(inventoryModel.getProductCategory()));
			inventory.setInventoryId(inventoryModel.getInventoryId());
			inventory.setPriceList(inventoryModel.getPriceList());
			inventory.setPriceMin(inventoryModel.getPriceMin());
			inventory.setProductAvailability(
					store.isStoreAvailability() ? inventoryModel.isProductAvailability() : Boolean.FALSE);
			inventory.setProductDescription(StringUtils.trimToNull(inventoryModel.getProductDesc()));
			inventory.setProductName(StringUtils.trimToNull(inventoryModel.getProductName()));
			store.getInventoryList().add(inventory);
			return store;
		}
		return null;
	}

}
