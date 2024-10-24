package com.ussessions.warehousemanagement.service;

import java.io.IOException;
import java.util.List;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.service.exception.SellerNotFoundException;

public interface ProductService {
	public Integer addProduct(ProductDTO product,Integer sellerId) throws SellerNotFoundException, IOException;

	public ProductDetail findProduct(Integer productId) throws Exception;

	public Integer updateProduct(Integer productId, Integer newQuantity) throws Exception;

	public void deleteProduct(Integer product) throws Exception;

	List<ProductDTO> viewProductsWithProductName(String name);
	
	List<ProductDTO> searchProducts(String keyword);
	
	public void deleteProductWithQuery(Integer product) throws Exception;
	
	
	public List<ProductDetail> findBySellerId(Integer sellerId);
}
