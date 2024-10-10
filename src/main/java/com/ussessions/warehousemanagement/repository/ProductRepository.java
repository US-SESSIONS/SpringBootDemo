package com.ussessions.warehousemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ussessions.warehousemanagement.entity.ProductDetail;

//entity class name,data type of primary key
public interface ProductRepository extends JpaRepository<ProductDetail, Integer> {

}
