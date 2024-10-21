package com.ussessions.warehousemanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "seller")
@Data
public class SellerDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sellerId;
	private String firstName;
	private String lastName;
	private String address;
	private LocalDate createdAt;

}
