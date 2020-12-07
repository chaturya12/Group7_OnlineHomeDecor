/**
 * 
 */
package com.cg.onlinehomedecor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;



/**
 * @author challa chaturya
 *
 */
@Entity
public class Product {
	
	/**
	 * productId id taken as Primary key
	 */
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@NotBlank(message="Name should not be null.")
	@ApiModelProperty(required=true)
	private String productName;	
	@NotBlank(message="Category should be present.")
	private String productCategory;	
	@NotNull(message="There won't be a product will zero price.")
	@ApiModelProperty(required=true)
	private int productPrice;
	@NotNull(message="There will be always some quantity ")
	private int quantity;
	
	/**
	 * to get the product id
	 * @return product id
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * to set the value for product id
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 *  to get the product name
	 * @return product name
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * to set the product name
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * to get the category of the product
	 * @return category
	 */	
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * to set the category
	 * @param productCategory
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * to get the product price
	 * @return price
	 */
	public int getProductPrice() {
		return productPrice;
	}
	/**
	 * to set the product price
	 * @param productPrice
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice =  productPrice;
	}
	/**
	 * to get quantity of product
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * to set quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
