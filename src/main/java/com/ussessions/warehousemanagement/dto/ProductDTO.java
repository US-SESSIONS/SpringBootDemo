package com.ussessions.warehousemanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
@Valid
public class ProductDTO {
	
	private Integer pId;
	
	@NotNull(message="quantity cannot be null")
	private Integer quantity;
	
	@NotNull(message="product name is mandatory")
	
	private String productName;
	private String category;
	private LocalDate manDate;
	private LocalDate expDate;
	private LocalDateTime addedAt;
	
	private MultipartFile image;
	
	
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
