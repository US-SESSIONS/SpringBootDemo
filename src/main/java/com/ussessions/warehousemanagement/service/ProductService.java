package com.ussessions.warehousemanagement.service;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;

public interface ProductService {
	public Integer addProduct(ProductDTO product);

	public ProductDetail findProduct(Integer productId) throws Exception;

	public Integer updateProduct(Integer productId, Integer newQuantity) throws Exception;

	public void deleteProduct(Integer product) throws Exception;
}
