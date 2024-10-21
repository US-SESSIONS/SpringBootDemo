package com.ussessions.warehousemanagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class KYCDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kycId;
	private String kycDocument;
	private String documentNumber;
	private String fullName;
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="sellerId",unique = true,updatable = false)
	@JoinColumn(name="sellerId")
	private SellerDetail seller;
}
