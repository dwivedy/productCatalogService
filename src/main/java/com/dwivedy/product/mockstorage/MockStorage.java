package com.dwivedy.product.mockstorage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dwivedy.product.entity.Product;

/**
 * @author Pawan
 *
 *         This class acts as a MockStorage and mock the idea of DB.
 *         
 */

@Component
public class MockStorage {

	private List<Product> products;

	@Override
	public String toString() {
		return "MockStorage [products=" + products + "]";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public MockStorage(List<Product> products) {
		super();
		this.products = new ArrayList<Product>();
	}

}
