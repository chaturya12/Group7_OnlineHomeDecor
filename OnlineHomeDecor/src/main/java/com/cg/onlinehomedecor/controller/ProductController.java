package com.cg.onlinehomedecor.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinehomedecor.domain.Product;
import com.cg.onlinehomedecor.exception.ProductIdNotFoundException;
import com.cg.onlinehomedecor.service.MapValidationErrorService;
import com.cg.onlinehomedecor.service.ProductService;


/**
 *Description:Controller for product is given 
 * @author Chaturya
 *
 */

@RestController
@RequestMapping("/api/v2")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * add product is implemented in controller
	 * @param product
	 * @param result
	 * @return either errorMap or new product
	 */
	@PostMapping("/Products")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Product newProduct=productService.addProducts(product);
		logger.info(" Product is added successfully...!");
		return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		
	}
	/**
	 * delete product is implemented
	 * @param productId
	 * @return string saying product is deleted
	 */
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId){
		productService.deleteProduct(productId);
		logger.info(" Product is deleted successfully...!");
		return new ResponseEntity<>("Product with Id : "+productId+" id deleted.....", HttpStatus.OK);
		
	}
	/**
	 * to display product by product id 
	 * @param productId
	 * @return the product we want 
	 * @throws ProductIdNotFoundException
	 */
	@GetMapping("/{productId}")
	public ResponseEntity<Product> viewProductByProductId(@PathVariable int productId) throws ProductIdNotFoundException{		
		logger.info(" Retrieved product by id successfully...!");
		return new ResponseEntity<>(productService.viewProductByProductId(productId),HttpStatus.OK);
		
	}
	/**
	 * displays all the products
	 * @return all products present in database
	 */
	@GetMapping("/all")
	public Iterable<Product> viewAllProducts(){
		logger.info(" All the products are retrieved successfully...!");
		return productService.viewAllProducts();
		
	}
	/**
	 * method to update the product
	 * @param product
	 * @param productId
	 * @return updated product
	 * @throws ProductIdNotFoundException
	 */
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product ,@PathVariable int productId) throws ProductIdNotFoundException{
		Product updatedProduct=productService.updateProduct(product, productId);
		logger.info(" Product is updated successfully...!");
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		
	}

}

