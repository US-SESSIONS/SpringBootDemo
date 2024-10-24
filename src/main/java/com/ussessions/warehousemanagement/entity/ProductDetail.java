package com.ussessions.warehousemanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_details")
//@NamedQuery(name = "ProductDetail.findByProdName",query="SELECT p FROM ProductDetail p where p.productName=:name")
@NamedQuery(name = "ProductDetail.findByProdName", query = "SELECT p FROM ProductDetail p where p.productName=?1")
@Data
public class ProductDetail {

	@Column(name = "p_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "p_name")
	private String productName;

	@Column(name = "man_date")
	private LocalDate manufacturingDate;

	@Column(name = "exp_date")
	private LocalDate expiryDate;

	private String category;

	private LocalDateTime addedAt;

	private Integer quantity;
	@ManyToOne
	@JoinColumn(name="seller_id")
	private SellerDetail seller;
	@Lob
	private byte[] imageContent;
	
	private String filename;

}
//primary key generation startagies
// identity
// auto
// sequence
// table