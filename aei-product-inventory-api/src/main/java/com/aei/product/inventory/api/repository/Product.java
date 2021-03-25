/**
 * 
 */
package com.aei.product.inventory.api.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column(name = "description")
	private String desc;

	@Column(name = "price_min")
	private float priceMinimum;

	@Column(name = "price_list")
	private float priceToList;

	@Column(name = "image_link")
	private float imageLink;

	@Column
	private long category;
	
	@Column(name = "price_currency")
	private String currency;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the priceMinimum
	 */
	public float getPriceMinimum() {
		return priceMinimum;
	}

	/**
	 * @param priceMinimum the priceMinimum to set
	 */
	public void setPriceMinimum(float priceMinimum) {
		this.priceMinimum = priceMinimum;
	}

	/**
	 * @return the priceToList
	 */
	public float getPriceToList() {
		return priceToList;
	}

	/**
	 * @param priceToList the priceToList to set
	 */
	public void setPriceToList(float priceToList) {
		this.priceToList = priceToList;
	}

	/**
	 * @return the imageLink
	 */
	public float getImageLink() {
		return imageLink;
	}

	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(float imageLink) {
		this.imageLink = imageLink;
	}

	/**
	 * @return the category
	 */
	public long getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(long category) {
		this.category = category;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
