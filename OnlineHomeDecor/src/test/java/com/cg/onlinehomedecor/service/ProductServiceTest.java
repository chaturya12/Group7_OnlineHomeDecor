package com.cg.onlinehomedecor.service;

import static org.junit.Assert.assertEquals;



import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinehomedecor.domain.Product;
import com.cg.onlinehomedecor.exception.ProductIdNotFoundException;
import com.cg.onlinehomedecor.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * 
 * @author Chaturya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
 class ProductServiceTest {

	@Autowired
	private ProductService productService;
	@MockBean
	private ProductRepository productRepository;
	@Test
	void addProduct() {
		Product product=new Product();
		product.setProductId(1);
		product.setProductName("chairs");
		product.setProductCategory("furniture");
		product.setProductPrice(2000);
		product.setQuantity(300);
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
        assertThat(productService.addProducts(product)).isEqualTo(product);
		
		}
	@Test
	void deleteProductTest() throws ProductIdNotFoundException {
		Product product=new Product();
		product.setProductId(4);
		product.setProductName("sofa");
		product.setProductCategory("furniture");
		product.setProductPrice(12000);
		product.setQuantity(34);
		int productId=product.getProductId();
		Mockito.when(productRepository.findByProductId(productId)).thenReturn(product);
			assertThat(productService.deleteProduct(productId)).isEqualTo(product);      
        
			 
	}	
	@Test
	void viewProductById() throws ProductIdNotFoundException {
		Product product=new Product();
		product.setProductId(6);
		product.setProductName("diwan");
		product.setProductCategory("furniture");
		product.setProductPrice(12000);
		product.setQuantity(34);
		int productId=product.getProductId();
		Mockito.when(productRepository.findByProductId(productId)).thenReturn(product);
		assertThat(productService.viewProductByProductId(productId)).isEqualTo(product);
		
	}
	
	  @Test
	  void viewAllProducts() { 
		  Product product1=new Product();
	  product1.setProductId(2);
	  product1.setProductName("wall clock");
	  product1.setProductCategory("decor");
	  product1.setProductPrice(399);
	  product1.setQuantity(23);
	  
	  Product product2=new Product(); 
	  product2.setProductId(5);
	  product2.setProductName("matrices");
	  product2.setProductCategory("furniture");
	  product2.setProductPrice(8000);
	  product2.setQuantity(300);
	  
	  List<Product> productList=new ArrayList<Product>();
	  productList.add(product1);
	  productList.add(product2);
	  Mockito.when(productRepository.findAll()).thenReturn(productList);
	  assertEquals(productService.viewAllProducts(),productList);
	   }
		

	  @Test void updateProductTest() throws ProductIdNotFoundException {
		  Product product=new Product();
		  product.setProductId(2);
		  product.setProductName("wall clock");
		  product.setProductCategory("decor");
		  product.setProductPrice(399);
		  product.setQuantity(23);
		 Mockito.when(productRepository.findByProductId(2)).thenReturn(product);
		  product.setProductPrice(200);
		  product.setQuantity(56);
		  Mockito.when(productRepository.save(product)).thenReturn(product);
		  assertThat(productService.updateProduct(product,2)).isEqualTo(product);
		

	  }
		 
	 
}

