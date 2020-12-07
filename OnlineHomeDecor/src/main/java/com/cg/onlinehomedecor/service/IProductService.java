package com.cg.onlinehomedecor.service;

import com.cg.onlinehomedecor.domain.Product;
import com.cg.onlinehomedecor.exception.ProductIdNotFoundException;

/**
 * 
 * @author challa chaturya
 *Description : interface of product service is provided
 * to perform the crud operations on the product
 */
public interface IProductService {

	/**
	 * this method will add the product
	 * @param product
	 * @return product
	 */
	public Product addProducts(Product product);
	/**
	 * this method will delete the product
	 * @param productId
	 * @return product
	 */
	public Product deleteProduct(int productId);
	/**
	 * this method will update the product details
	 * @param product
	 * @param productId
	 * @return product
	 * @throws ProductNotFoundException
	 * @throws ProductIdNotFoundException 
	 */
	public Product updateProduct(Product product,int productId) throws ProductIdNotFoundException;
	/**
	 * this method will display all the products
	 * @return list of products
	 */
	public Iterable<Product> viewAllProducts();
	/**
	 * this method will display view productDetails based on id
	 * @param productId
	 * @return product
	 * @throws ProductIdNotFoundException
	 */
	public Product viewProductByProductId(int productId) throws ProductIdNotFoundException;
}

