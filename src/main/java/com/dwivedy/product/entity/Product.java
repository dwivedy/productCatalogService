package com.dwivedy.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Pawan This class is representing the product entity and its necessary
 *         properties .
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters")
	@NotNull(message = "Name cannot be null")
	private String name;

	@Size(min = 10, max = 400, message = "Description Me must be between 10 and 400 characters")
	private String description;

	@NotNull(message = "Type cannot be null")
	private String type;

	@NotNull(message = "Price cannot be null")
	@Positive
	private BigDecimal price;

	private String camera;

	private String speakers;

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getSpeakers() {
		return speakers;
	}

	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	public Product() {

	}

	public Product(String name, String type) {
		id = getNextId();
		this.name = name;
		this.type = type;
	}

	public Product(String name, String type, BigDecimal price) {
		id = getNextId();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", price="
				+ price + "]";
	}

}
