package com.dwivedy.product.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dwivedy.product.entity.Product;
import com.dwivedy.product.exceptions.RecordNotFoundException;
import com.dwivedy.product.service.impl.ProductCatalogServiceImpl;

/**
 * @author Pawan
 *
 *         This class is the entry point for Product catalog service and acts as
 *         the controller.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductCatalogController {

	private Long id = 1L;

	protected Logger logger = Logger.getLogger(ProductCatalogController.class.getName());

	@Autowired
	private ProductCatalogServiceImpl productCatalogServiceImpl;

	@RequestMapping("/products/type/{productType}")
	public List<Product> findByType(@PathVariable("productType") String productType) {

		logger.info("products-service byType() invoked: " + productType);

		List<Product> product = productCatalogServiceImpl.findByType(productType);
		logger.info("products-service byType() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productType);
		else {
			return product;
		}
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) {
		logger.info("products-service createProduct() invoked: " + product);
		product.setId(id);
		id++;

		Product productSaved = productCatalogServiceImpl.createProduct(product);

		return productSaved;

	}

	// search products by name
	@RequestMapping("/products/name/{productName}")
	public List<Product> findProductByName(@PathVariable("productName") String productName) {

		logger.info("products-service findPriceByName() invoked: " + productName);

		List<Product> product = productCatalogServiceImpl.findProductByName(productName);
		logger.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productName);
		else {
			return product;
		}
	}

	@DeleteMapping(value = "/products/{productId}")
	public Product deleteProduct(@PathVariable("productId") Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);

		Product product = productCatalogServiceImpl.deleteProductById(productId);
		if (product == null)
			throw new RecordNotFoundException(productId);
		else {
			return product;
		}

	}

	@GetMapping(value = "/products/{productId}")
	public Product findProductById(@PathVariable("productId") Long productId) {
		logger.info("products-service findProductById() invoked: " + productId);

		Product product = productCatalogServiceImpl.findProductById(productId);
		if (product == null)
			throw new RecordNotFoundException(productId);
		else {
			return product;
		}

	}

	@PutMapping(value = "/products/{productId}")
	public Product updateProductById(@Valid @RequestBody Product product, @PathVariable("productId") Long productId) {
		logger.info("products-service updateProductById() invoked: " + productId);

		Product updatedProduct = productCatalogServiceImpl.updateProductById(productId, product);
		if (updatedProduct == null)
			throw new RecordNotFoundException(productId);
		else {
			return updatedProduct;
		}

	}

}
