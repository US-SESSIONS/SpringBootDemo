package com.ussessions.warehousemanagement.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(ProductDTO product) {

		ProductDetail newProduct = new ProductDetail();

		newProduct.setCategory(product.getCategory());
		newProduct.setExpiryDate(product.getExpDate());
		newProduct.setManufacturingDate(product.getManDate());
		newProduct.setProductName(product.getProductName());
		newProduct.setAddedAt(LocalDateTime.now());

		productRepository.save(newProduct);

	}

	@Override
	public ProductDetail findProduct(Integer productId) throws Exception {

		Optional<ProductDetail> optProduct = productRepository.findById(productId);

		ProductDetail product = optProduct.orElseThrow(() -> new Exception("ProductNot found with id :" + productId));
		return product;
	}

}
