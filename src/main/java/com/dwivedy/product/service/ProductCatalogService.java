package com.dwivedy.product.service;

import java.util.List;

import com.dwivedy.product.entity.Product;

public interface ProductCatalogService {

	/**
	 * Performs complete find of object matched by type
	 * 
	 * @param productType
	 * @throws RecordNotFoundException returns list
	 */
	List<Product> findByType(String productType);

	/**
	 * Performs create product
	 * 
	 * @param product
	 * 
	 * 
	 */
	Product createProduct(Product product);

	/**
	 * Performs complete find of object matched by name
	 * 
	 * @param productName
	 * @throws RecordNotFoundException returns list
	 */
	List<Product> findProductByName(String productName);

	/**
	 * Performs complete find of object matched by id
	 * 
	 * @param productId
	 * @throws RecordNotFoundException returns product
	 */
	Product findProductById(Long productId);

	/**
	 * Performs complete delete of object matched by id
	 * 
	 * @param productId
	 * @throws RecordNotFoundException returns product
	 */
	Product deleteProductById(Long productId);

	/**
	 * Performs complete replacement of the object matched by Id
	 * 
	 * @param productId,product
	 * @throws RecordNotFoundException
	 * 
	 */
	Product updateProductById(Long productId, Product product);

}
