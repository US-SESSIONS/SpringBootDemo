package com.ussessions.warehousemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ussessions.warehousemanagement.entity.ProductDetail;

//entity class name,data type of primary key
public interface ProductRepository extends JpaRepository<ProductDetail, Integer> {
	
List<ProductDetail>	findByProductName(String productName);

List<ProductDetail> findByCategory(String category);

List<ProductDetail> findByCategoryAndProductName(String category,String name);

List<ProductDetail> findByCategoryOrProductName(String category,String name);

List<ProductDetail> findByExpiryDateBetween(LocalDate start,LocalDate end);

List<ProductDetail> findByQuantityIsNull();

List<ProductDetail>	findByProductNameIgnoreCase(String productName);

List<ProductDetail> findByQuantityLessThan(Integer quantity);


List<ProductDetail> findByProductNameLikeOrCategoryLike(String keyword,String keyword2);
}
