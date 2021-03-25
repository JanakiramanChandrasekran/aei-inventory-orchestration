/**
 * 
 */
package com.aei.product.inventory.api.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.aei.product.inventory.api.model.Store;
import com.aei.product.inventory.api.repository.InventoryRepository;
import com.aei.product.inventory.api.repository.StoreInventoryModel;

/**
 * Tests for {@link InventoryServiceImpl}
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class InventoryServiceImplTest {
	
	@InjectMocks
	private InventoryServiceImpl impl;
	
	@Mock
	private InventoryRepository storeInventoryRepository;
	
	/**
	 * {@link InventoryServiceImpl#getInventoryByStore(long)}
	 */
	@Test
	public void getInventoryByStoreTestValidStoreAvailable() {
		final List<StoreInventoryModel> list = new ArrayList<>(1);
		list.add(new StoreInventoryModel());
		list.get(0).setInventoryId(1);
		list.get(0).setPriceList(new Float("11.1"));
		list.get(0).setPriceMin(new Float("11.1"));
		list.get(0).setProductAvailability(true);
		list.get(0).setProductCategory("Icecream");
		list.get(0).setProductDesc("test");
		list.get(0).setProductName("A");
		list.get(0).setStoreAvailability(true);
		list.get(0).setStoreid(1);
		list.get(0).setStoreName("XYZ");
		when(storeInventoryRepository.getInventoryByStore(1)).thenReturn(list);
		final Store store = impl.getInventoryByStore(1);
		assertEquals(true, store.getInventoryList().get(0).isProductAvailability());
	}
	
	/**
	 * {@link InventoryServiceImpl#getInventoryByStore(long)}
	 */
	@Test
	public void getInventoryByStoreTestValidStoreUnAvailable() {
		final List<StoreInventoryModel> list = new ArrayList<>(1);
		list.add(new StoreInventoryModel());
		list.get(0).setInventoryId(1);
		list.get(0).setPriceList(new Float("11.1"));
		list.get(0).setPriceMin(new Float("11.1"));
		list.get(0).setProductAvailability(true);
		list.get(0).setProductCategory("Icecream");
		list.get(0).setProductDesc("test");
		list.get(0).setProductName("A");
		list.get(0).setStoreAvailability(false);
		list.get(0).setStoreid(1);
		list.get(0).setStoreName("XYZ");
		when(storeInventoryRepository.getInventoryByStore(1)).thenReturn(list);
		final Store store = impl.getInventoryByStore(1);
		assertEquals(false, store.getInventoryList().get(0).isProductAvailability());
	}
	
	/**
	 * {@link InventoryServiceImpl#getInventoryByStore(long)}
	 */
	@Test
	public void getInventoryByStoreTestNoProduct() {
		when(storeInventoryRepository.getInventoryByStore(1)).thenReturn(null);
		final Store store = impl.getInventoryByStore(1);
		assertNull(store);
	}
	
	/**
	 * {@link InventoryServiceImpl#getByInventory(long)}
	 */
	@Test
	public void getByInventoryTestValidStoreAvailable() {
		StoreInventoryModel model = new StoreInventoryModel();
		model.setInventoryId(1);
		model.setPriceList(new Float("11.1"));
		model.setPriceMin(new Float("11.1"));
		model.setProductAvailability(true);
		model.setProductCategory("Icecream");
		model.setProductDesc("test");
		model.setProductName("A");
		model.setStoreAvailability(true);
		model.setStoreid(1);
		model.setStoreName("XYZ");
		when(storeInventoryRepository.getByInventory(1)).thenReturn(model);
		final Store store = impl.getByInventory(1);
		assertEquals(true, store.getInventoryList().get(0).isProductAvailability());
	}
	
	/**
	 * {@link InventoryServiceImpl#getByInventory(long)}
	 */
	@Test
	public void getByInventoryTestValidStoreUnAvailable() {
		StoreInventoryModel model = new StoreInventoryModel();
		model.setInventoryId(1);
		model.setPriceList(new Float("11.1"));
		model.setPriceMin(new Float("11.1"));
		model.setProductAvailability(true);
		model.setProductCategory("Icecream");
		model.setProductDesc("test");
		model.setProductName("A");
		model.setStoreAvailability(false);
		model.setStoreid(1);
		model.setStoreName("XYZ");
		when(storeInventoryRepository.getByInventory(1)).thenReturn(model);
		final Store store = impl.getByInventory(1);
		assertEquals(false, store.getInventoryList().get(0).isProductAvailability());
	}
	
	/**
	 * {@link InventoryServiceImpl#getByInventory(long)}
	 */
	@Test
	public void getByInventoryTestNoProduct() {
		when(storeInventoryRepository.getByInventory(1)).thenReturn(null);
		final Store store = impl.getByInventory(1);
		assertNull(store);
	}

}
