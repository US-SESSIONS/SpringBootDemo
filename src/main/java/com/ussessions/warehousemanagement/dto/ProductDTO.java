package com.ussessions.warehousemanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductDTO {
	private Integer pId;
	private Integer quantity;
	private String productName;
	private String category;
	private LocalDate manDate;
	private LocalDate expDate;
	private LocalDateTime addedAt;
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
	public Integer getpId() {
		return pId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public LocalDateTime getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}
	@Override
	public String toString() {
		return "ProductDTO [pId=" + pId + ", quantity=" + quantity + ", productName=" + productName + ", category="
				+ category + ", manDate=" + manDate + ", expDate=" + expDate + ", addedAt=" + addedAt + "]";
	}
	

}
