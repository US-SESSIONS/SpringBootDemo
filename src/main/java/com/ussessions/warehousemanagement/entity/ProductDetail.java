package com.ussessions.warehousemanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetail {
	@Override
	public String toString() {
		return "ProductDetail [productId=" + productId + ", productName=" + productName + ", manufacturingDate="
				+ manufacturingDate + ", expiryDate=" + expiryDate + ", category=" + category + ", addedAt=" + addedAt
				+ "]";
	}

	@Column(name = "p_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "p_name")
	private String productName;
	@Column(name = "man_date")
	private LocalDate manufacturingDate;

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getCategory() {
		return category;
	}

	public LocalDateTime getAddedAt() {
		return addedAt;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}

	@Column(name = "exp_date")
	private LocalDate expiryDate;

	private String category;

	private LocalDateTime addedAt;

}
//primary key generation startagies
// identity
// auto
// sequence
// table