package com.ussessions.warehousemanagement.service;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;

public interface ProductService {
public void addProduct(ProductDTO product);

public ProductDetail findProduct(Integer productId) throws Exception;
}
