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
	public Integer addProduct(ProductDTO product) {

		ProductDetail newProduct = new ProductDetail();

		newProduct.setCategory(product.getCategory());
		newProduct.setExpiryDate(product.getExpDate());
		newProduct.setManufacturingDate(product.getManDate());
		newProduct.setProductName(product.getProductName());
		newProduct.setAddedAt(LocalDateTime.now());

		ProductDetail addededProduct = productRepository.save(newProduct);
		return addededProduct.getProductId();

	}

	@Override
	public ProductDetail findProduct(Integer productId) throws Exception {
		// select * from produt table where pid=?
		Optional<ProductDetail> optProduct = productRepository.findById(productId);

		ProductDetail product = optProduct.orElseThrow(() -> new Exception("ProductNot found with id :" + productId));
		return product;
	}

	@Override
	public Integer updateProduct(Integer productId, Integer newQuantity) throws Exception {
		// ProductDetail product= findProduct(productId);

		Optional<ProductDetail> optProduct = productRepository.findById(productId);

		if (optProduct.isPresent()) {
			ProductDetail product = optProduct.get();

			System.out.println("existing quantity " + product.getQuantity());

			product.setQuantity(newQuantity);

			// product.setProductId(null);

			ProductDetail updatedProduct = productRepository.save(product);
			return updatedProduct.getQuantity();

		} else {
			throw new Exception("ProductNot found with id :" + productId);
		}

	}

	@Override
	public void deleteProduct(Integer productId) throws Exception {

		Optional<ProductDetail> optProduct = productRepository.findById(productId);
		ProductDetail productDetail = optProduct
				.orElseThrow(() -> new Exception("ProductNot found with id :" + productId));

		// based on PK ->deletebyId


		//productRepository.deleteById(productDetail.getProductId());
		// based on entity object delete
		productRepository.delete(productDetail);

	}

}
