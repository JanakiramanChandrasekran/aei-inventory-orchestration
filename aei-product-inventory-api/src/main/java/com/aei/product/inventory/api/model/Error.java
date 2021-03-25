/**
 * 
 */
package com.aei.product.inventory.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Error {

	public final String message;

	/**
	 * @param message
	 */
	public Error(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
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
