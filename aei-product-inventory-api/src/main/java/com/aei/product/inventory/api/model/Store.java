/**
 * 
 */
package com.aei.product.inventory.api.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4027931367331529298L;

	private String storeName;

	private long storeId;

	private boolean storeAvailability;

	private List<Inventory> inventoryList;

	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return the storeId
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the storeAvailability
	 */
	public boolean isStoreAvailability() {
		return storeAvailability;
	}

	/**
	 * @param storeAvailability the storeAvailability to set
	 */
	public void setStoreAvailability(boolean storeAvailability) {
		this.storeAvailability = storeAvailability;
	}

	/**
	 * @return the inventoryList
	 */
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	/**
	 * @param inventoryList the inventoryList to set
	 */
	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
