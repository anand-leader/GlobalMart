package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.ProductServicesInterface;

@SpringBootTest
public class ProductTest {

	@Autowired
	private ProductServicesInterface productService;

//	Product product = new Product();
	Category category = new Category (1, "categoryName", "categoryDescription");
//	Category category = new Category (1, "categoryName", "categoryDescription"));
	
	@Test
	void addProductByIdTest() throws GlobalMartException {
	Product product = new Product(50, "MyProduct", "MyDescription", 2500.00, 25, category);
		Product productnew = productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.getProductById(50));
	}

	@Test
	void getAllProducts() throws GlobalMartException {
//	Product product = new Product(50, "MyProduct", "MyDescription", 2500.00, 25, category);
//		Product productnew = productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.getAllProducts());
	}
	
	
	@Test
	void deleteProductByIdTest() throws GlobalMartException {
		Product product = productService.getProductById(6).get();
		assumeTrue(productService != null);
		productService.deleteProductById(6);
//		assertNull(productService.getProductById(3).get());
//		assertNotNull(productService.getProductById(3).get());
		assertThrows(GlobalMartException.class, ()-> productService.getProductById(6));
		productService.addProduct(product);
	}
	@Test
	void deleteProductByIdTest2() throws GlobalMartException {
		Product product = productService.getProductById(6).get();
		assumeTrue(productService != null);
//		productService.deleteProductById(6);
//		assertNull(productService.getProductById(3).get());
//		assertNotNull(productService.getProductById(3).get());
		assertThrows(GlobalMartException.class, ()-> productService.deleteProductById(7));
		productService.addProduct(product);
	}
	
	@Test
	void updateProductTest() throws GlobalMartException {
		Product myproduct = new Product(50, "MyProduct", "MyDescription", 2500.00, 25, category);
		Product product = new Product(50, "oldProduct", "MyDescription", 2500.00, 25, category);
		productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.updateProduct(myproduct));
	}
	
	@Test
	void deleteProduct() throws GlobalMartException{
		Product myproduct = new Product(50, "MyProduct", "MyDescription", 2500.00, 25, category);
		productService.addProduct(myproduct);
		assumeTrue(productService != null);
		productService.deleteProduct(myproduct);
		assertThrows(GlobalMartException.class, ()-> productService.getProductById(50));
	}
	

}
