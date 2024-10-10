package com.ussessions.warehousemanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.service.ProductService;

@SpringBootApplication
public class WarehousemangementApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(WarehousemangementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//addProduct();
		
		viewProduct();
	}

	private void viewProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product id");
		int prodId=sc.nextInt();
		//auto boxing
		//primitive value->Wrapper class type
		try {
		ProductDetail product=	productService.findProduct(prodId);
		System.out.println("product with product id : "+prodId+"is "+product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	private void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product Name");
		String pname = sc.next();
		System.out.println("enter manufacturing date in format d-MM-YYYY");
		String manDate = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate mdt = LocalDate.parse(manDate, dtf);

		System.out.println("enter expiry date in format DD-MM-YYYY");
		String expDate = sc.next();
		LocalDate edt = LocalDate.parse(expDate, dtf);
		System.out.println("enter category");
		String category = sc.next();

		ProductDTO product = new ProductDTO();
		product.setCategory(category);
		product.setExpDate(edt);
		product.setManDate(mdt);
		product.setProductName(pname);

		productService.addProduct(product);
	}
}
