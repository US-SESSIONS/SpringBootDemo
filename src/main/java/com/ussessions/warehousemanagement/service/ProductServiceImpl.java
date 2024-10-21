package com.ussessions.warehousemanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.entity.SellerDetail;
import com.ussessions.warehousemanagement.repository.ProductRepository;
import com.ussessions.warehousemanagement.repository.SellerDetailRepository;
import com.ussessions.warehousemanagement.service.exception.SellerNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellerDetailRepository sellerDetailRepository;

	@Override
	@Transactional(rollbackOn = { SellerNotFoundException.class })
	public Integer addProduct(ProductDTO product, Integer sellerId) throws SellerNotFoundException {
//query db for the seller Info
		Optional<SellerDetail> optSeller = sellerDetailRepository.findById(sellerId);
		if (optSeller.isEmpty()) {
			throw new SellerNotFoundException("Seller with seller id :" + sellerId + " not found");
		}
		SellerDetail sellerDetail = optSeller.get();
		ProductDetail newProduct = new ProductDetail();

		newProduct.setCategory(product.getCategory());
		newProduct.setExpiryDate(product.getExpDate());
		newProduct.setManufacturingDate(product.getManDate());
		newProduct.setProductName(product.getProductName());
		newProduct.setAddedAt(LocalDateTime.now());
		newProduct.setSeller(sellerDetail);
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

		// productRepository.deleteById(productDetail.getProductId());
		// based on entity object delete
		productRepository.delete(productDetail);

	}

	@Override
	public List<ProductDTO> viewProductsWithProductName(String name) {
		// below method is used to do transaction based on method name apporach
		// List<ProductDetail> products = productRepository.findByProductName(name);

		// below method is for doing transaction based on product name using the named
		// query approach
		List<ProductDetail> products = productRepository.findByProdName(name);
		// create List<ProductDTO>
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (ProductDetail product : products) {

			ProductDTO productDTO = new ProductDTO();
			productDTO.setpId(product.getProductId());
			productDTO.setAddedAt(product.getAddedAt());
			productDTO.setCategory(product.getCategory());
			productDTO.setProductName(product.getProductName());
			productDTO.setExpDate(product.getExpiryDate());
			productDTO.setManDate(product.getManufacturingDate());
			productDTO.setQuantity(product.getQuantity());
			productDTOs.add(productDTO);

		}

		return productDTOs;
	}

	@Override
	public List<ProductDTO> searchProducts(String keyword) {
		List<ProductDetail> repoProducts = productRepository.findByProductNameLikeOrCategoryLikePositionalParam(keyword,
				keyword);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (ProductDetail product : repoProducts) {

			ProductDTO productDTO = new ProductDTO();
			productDTO.setpId(product.getProductId());
			productDTO.setAddedAt(product.getAddedAt());
			productDTO.setCategory(product.getCategory());
			productDTO.setProductName(product.getProductName());
			productDTO.setExpDate(product.getExpiryDate());
			productDTO.setManDate(product.getManufacturingDate());
			productDTO.setQuantity(product.getQuantity());
			productDTOs.add(productDTO);

		}

		return productDTOs;
	}

	@Override
	@Transactional(rollbackOn = { Exception.class })
	public void deleteProductWithQuery(Integer product) throws Exception {
		productRepository.deleteProductBasedOnPK(product);
		// throw new RuntimeException("created exception to check the transcational
		// behavior");
		throw new Exception("created exception to check the transcational behavior");
	//	System.out.println("just check");
	}

	@Override
	public List<ProductDetail> findBySellerId(Integer sellerId) {

		return productRepository.findBySellerSellerId(sellerId);
	}

}
