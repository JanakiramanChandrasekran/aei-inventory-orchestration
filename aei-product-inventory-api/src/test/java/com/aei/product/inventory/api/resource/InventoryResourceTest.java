/**
 * 
 */
package com.aei.product.inventory.api.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aei.product.inventory.api.model.Store;
import com.aei.product.inventory.api.service.InventoryService;

/**
 * Tests for {@link InventoryResource}
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class InventoryResourceTest {
	
	@InjectMocks
	private InventoryResource resource;
	
	@Mock
	private InventoryService service;
	
	/**
	 * {@link InventoryResource#inventoryByStore(long, String, String)}
	 */
	@Test
	public void inventoryByStoreTestValid() {
		final Store store = new Store();
		store.setStoreName("1");
		when(service.getInventoryByStore(1)).thenReturn(store);
		assertEquals("1", resource.inventoryByStore(1, "X", "Y").getStoreName());
	}
	
	/**
	 * {@link InventoryResource#inventoryByStore(long, String, String)}
	 */
	@Test
	public void inventoryByStoreTestException() {
		doThrow(InternalServerErrorException.class).when(service).getInventoryByStore(1);
		final Exception e = assertThrows(InternalServerErrorException.class, () -> {
			resource.inventoryByStore(1, "X", "Y");
		});
		assertNotNull(e);
	}
	
	/**
	 * {@link InventoryResource#inventoryByStore(long, String, String)}
	 */
	@Test
	public void inventoryByStoreTestNotFound() {
		when(service.getInventoryByStore(1)).thenReturn(null);
		final Exception e = assertThrows(NotFoundException.class, () -> {
			resource.inventoryByStore(1, "X", "Y");
		});
		assertNotNull(e);
	}
	
	/**
	 * {@link InventoryResource#getByInventory(long, String, String)}
	 */
	@Test
	public void getByInventoryTestValid() {
		final Store store = new Store();
		store.setStoreName("1");
		when(service.getByInventory(1)).thenReturn(store);
		assertEquals("1", resource.getByInventory(1, "X", "Y").getStoreName());
	}
	
	/**
	 * {@link InventoryResource#getByInventory(long, String, String)}
	 */
	@Test
	public void getByInventoryTestException() {
		doThrow(InternalServerErrorException.class).when(service).getByInventory(1);
		final Exception e = assertThrows(InternalServerErrorException.class, () -> {
			resource.getByInventory(1, "X", "Y");
		});
		assertNotNull(e);
	}
	
	/**
	 * {@link InventoryResource#inventoryByStore(long, String, String)}
	 */
	@Test
	public void getByInventoryTestNotFound() {
		when(service.getByInventory(1)).thenReturn(null);
		final Exception e = assertThrows(NotFoundException.class, () -> {
			resource.getByInventory(1, "X", "Y");
		});
		assertNotNull(e);
	}
	
	

}
