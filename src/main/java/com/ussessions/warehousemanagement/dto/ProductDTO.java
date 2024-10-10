package com.ussessions.warehousemanagement.dto;

import java.time.LocalDate;

public class ProductDTO {
	private String productName;
	private String category;
	private LocalDate manDate;
	private LocalDate expDate;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getManDate() {
		return manDate;
	}
	public void setManDate(LocalDate manDate) {
		this.manDate = manDate;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

}
