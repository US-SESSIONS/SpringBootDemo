package com.ussessions.warehousemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ussessions.warehousemanagement.entity.ProductDetail;

import jakarta.transaction.Transactional;

//entity class name,data type of primary key
public interface ProductRepository extends JpaRepository<ProductDetail, Integer> {

	List<ProductDetail> findByProductName(String productName);

	List<ProductDetail> findByCategory(String category);

	List<ProductDetail> findByCategoryAndProductName(String category, String name);

	List<ProductDetail> findByCategoryOrProductName(String category, String name);

	List<ProductDetail> findByExpiryDateBetween(LocalDate start, LocalDate end);

	List<ProductDetail> findByQuantityIsNull();

	List<ProductDetail> findByProductNameIgnoreCase(String productName);

	List<ProductDetail> findByQuantityLessThan(Integer quantity);

	List<ProductDetail> findByProductNameLikeOrCategoryLike(String keyword, String keyword2);

//native query with postional param
	@Query(value = "select * from product_details where p_name like %?2% or category like %?1%", nativeQuery = true)
	List<ProductDetail> findByProductNameLikeOrCategoryLikePositionalParam(String pName, String category);

//jpql query with positonal param
	@Query(value = "select p from ProductDetail p where p.productName like %?2% or p.category like %?1%", nativeQuery = false)
	List<ProductDetail> findByProductNameLikeOrCategoryLikePositionalParamjpql(String pName, String category);

//jpql query with named param
	@Query(value = "select p from ProductDetail p where p.expiryDate < :expdate")
	public List<ProductDetail> fetchBasedOnExpDateNamedParamJPQL(@Param(value = "expdate") LocalDate date);

//fetch based the date by using >
//native query and named paramter

	@Query(value = "select * from product_details where exp_date < :expdate", nativeQuery = true)
	public List<ProductDetail> fetchBasedOnExpDateNamedParam(@Param(value = "expdate") LocalDate date);

//native query and positional paramter

	@Query(value = "select * from product_details where exp_date < ?1", nativeQuery = true)
	public List<ProductDetail> fetchBasedOnExpDatePositionalParam(LocalDate date);

	@Query(value = "delete from product_details where p_id=?1", nativeQuery = true)
	@Modifying
	// @Transactional
	// begin transaction commit transaction close transacton
	public void deleteProductBasedOnPK(Integer pk);

	//List<ProductDetail> findByProdName(@Param("name") String name);
	
	//above method is for the named query named paramterer approach
	//this is for the named query positioanal parameter approach
	List<ProductDetail> findByProdName( String name);
}
