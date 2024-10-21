package com.ussessions.warehousemanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.service.KYCDocumentService;
import com.ussessions.warehousemanagement.service.KycDocumentServiceImpl;
import com.ussessions.warehousemanagement.service.ProductService;
import com.ussessions.warehousemanagement.service.exception.SellerNotFoundException;

@SpringBootApplication
public class WarehousemangementApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WarehousemangementApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//addProduct();

		// viewProduct();
		// updateProduct();
		// deleteProduct();
		// searchProducts();
		// searchByKeyword();
		 findBySellerId();
	}

	private void findBySellerId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter seller id");
		int sellerId = sc.nextInt();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			// productService.deleteProduct(prodId);
			List<ProductDetail> products = productService.findBySellerId(sellerId);
			if (products != null) {
				for (ProductDetail product : products) {
					System.out.println(product);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// throw e;
		}

	}

	private void searchByKeyword() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter keyword");
		String keyword = sc.next();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			List<ProductDTO> products = productService.searchProducts(keyword);
			System.out.println(products.size() + " products found for search keyword");
			for (ProductDTO dto : products) {
				System.out.println(dto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private void searchProducts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product Name");
		String prodName = sc.next();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			List<ProductDTO> products = productService.viewProductsWithProductName(prodName);
			System.out.println(products.size() + " products found for search keyword");
			for (ProductDTO dto : products) {
				System.out.println(dto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private void deleteProduct() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product id");
		int prodId = sc.nextInt();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			// productService.deleteProduct(prodId);
			productService.deleteProductWithQuery(prodId);
			System.out.println("product with product id : " + prodId + "is deleted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// throw e;
		}

	}

	private void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product id");
		int prodId = sc.nextInt();
		System.out.println("enter quantity");
		int quantity = sc.nextInt();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			Integer newQuantity = productService.updateProduct(prodId, quantity);
			System.out.println("product with product id : " + prodId + "is updated with new quantity " + newQuantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private void viewProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter product id");
		int prodId = sc.nextInt();
		// auto boxing
		// primitive value->Wrapper class type
		try {
			ProductDetail product = productService.findProduct(prodId);
			System.out.println("product with product id : " + prodId + "is " + product);
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
		System.out.println("enter sellerId");
		int sellerID= sc.nextInt();
		try {
			productService.addProduct(product,sellerID);
		} catch (SellerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
