/**
 * 
 */
package com.aei.product.inventory.api.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4027931367331529298L;

	private long inventoryId;

	private String productName;

	private String productDescription;

	private float priceMin;

	private float priceList;

	private String categoryName;

	private boolean productAvailability;

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
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
