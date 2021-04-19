package com.dwivedy.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwivedy.product.entity.Product;
import com.dwivedy.product.exceptions.RecordNotFoundException;
import com.dwivedy.product.mockstorage.MockStorage;
import com.dwivedy.product.service.ProductCatalogService;

/**
 * @author Pawan
 *
 *         This class acts as a service layer having RESTful API methods implementation.
 *         
 */

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	private Logger logger = Logger.getLogger(ProductCatalogServiceImpl.class.getName());

	@Autowired
	private MockStorage mockStorage;

	public List<Product> findByType(String productType) {

		logger.info("products-service byType() invoked: " + productType);

		List<Product> product = mockStorage.getProducts().stream()
				.filter(productObj -> productObj.getType().equals(productType)).collect(Collectors.toList());

		logger.info("products-service byType() found: " + product);

		return product;
	}

	public Product createProduct(Product product) {

		logger.info("products-service createProduct() invoked: " + product);
		mockStorage.getProducts().add(product);
		return product;
	}

	public List<Product> findProductByName(String productName) {

		logger.info("products-service findPriceByName() invoked: " + productName);

		List<Product> product = mockStorage.getProducts().stream()
				.filter(productObj -> productObj.getName().contains(productName)).collect(Collectors.toList());
		logger.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productName);
		else {
			return product;
		}
	}

	@Override
	public Product findProductById(Long productId) {
		Optional<Product> product = mockStorage.getProducts().stream()
				.filter(productObj -> productObj.getId() == productId).findFirst();

		return product.isPresent() ? product.get() : null;
	}

	@Override
	public Product deleteProductById(Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);

		Optional<Product> product = mockStorage.getProducts().stream()
				.filter(productObj -> productObj.getId() == productId).findFirst().map(p -> {
					mockStorage.getProducts().remove(p);
					return p;
				});

		return product.isPresent() ? product.get() : null;
	}

	@Override
	public Product updateProductById(Long productId, Product productUpdate) {
		logger.info("products-service updateProductById() invoked: " + productId);
		Optional<Product> product = mockStorage.getProducts().stream()
				.filter(productObj -> productObj.getId() == productId).findFirst().map(p -> {
					productUpdate.setId(p.getId());
					mockStorage.getProducts().add(productUpdate);
					mockStorage.getProducts().remove(p);
					return productUpdate;
				});

		return product.isPresent() ? product.get() : null;
	}

}
