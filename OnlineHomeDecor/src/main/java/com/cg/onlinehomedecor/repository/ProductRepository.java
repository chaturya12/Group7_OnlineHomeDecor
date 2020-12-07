/**
 * 
 */
package com.cg.onlinehomedecor.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.onlinehomedecor.domain.Product;


/**
 * ProductRepository is created which extends CrudRepository
 * @author Chaturya
 *
 */
public interface ProductRepository extends CrudRepository<Product,Integer>{

		Product findByProductId(int productId);
			
	}

