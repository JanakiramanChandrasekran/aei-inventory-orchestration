/**
 * 
 */
package com.aei.product.inventory.api.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class StoreInventoryModel {

	@Id
	@Column( name = "inventoryid")
	private long inventoryId;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "productdesc")
	private String productDesc;
	
	@Column(name = "price_min")
	private float priceMin;
	
	@Column(name = "price_list")
	private float priceList;
	
	@Column(name = "productcategory")
	private String productCategory;
	
	@Column(name = "productavailability")
	private boolean productAvailability; 
	
	@Column(name = "storeid")
	private long storeid;
	
	@Column(name = "storename")
	private String storeName;
	
	@Column(name = "storeavailability")
	private boolean storeAvailability;

	/**
	 * @return the inventoryId
	 */
	public long getInventoryId() {
		return inventoryId;
	}

	/**
	 * @param inventoryId the inventoryId to set
	 */
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return the priceMin
	 */
	public float getPriceMin() {
		return priceMin;
	}

	/**
	 * @param priceMin the priceMin to set
	 */
	public void setPriceMin(float priceMin) {
		this.priceMin = priceMin;
	}

	/**
	 * @return the priceList
	 */
	public float getPriceList() {
		return priceList;
	}

	/**
	 * @param priceList the priceList to set
	 */
	public void setPriceList(float priceList) {
		this.priceList = priceList;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productAvailability
	 */
	public boolean isProductAvailability() {
		return productAvailability;
	}

	/**
	 * @param productAvailability the productAvailability to set
	 */
	public void setProductAvailability(boolean productAvailability) {
		this.productAvailability = productAvailability;
	}

	/**
	 * @return the storeid
	 */
	public long getStoreid() {
		return storeid;
	}

	/**
	 * @param storeid the storeid to set
	 */
	public void setStoreid(long storeid) {
		this.storeid = storeid;
	}

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
