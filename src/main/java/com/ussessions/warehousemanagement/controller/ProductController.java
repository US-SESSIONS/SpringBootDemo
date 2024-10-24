package com.ussessions.warehousemanagement.controller;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ussessions.warehousemanagement.dto.ProductDTO;
import com.ussessions.warehousemanagement.entity.ProductDetail;
import com.ussessions.warehousemanagement.service.ProductService;
import com.ussessions.warehousemanagement.service.exception.SellerNotFoundException;

import jakarta.validation.Valid;

//@Controller
//@ResponseBody

@RestController
@RequestMapping(value="product")
@Validated

//http://ip:port/product/
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "product")
	public void demoCheckUrl() {
		for (int i = 0; i < 5; i++) {
			System.out.println("url check");
		}
	}

	@RequestMapping(value = "hello123", method = RequestMethod.GET)
	//@ResponseBody
	public ProductDetail check() {
		return new ProductDetail();
	}

	// pathVariable demo
	// @RequestMapping(value = "sarch/{keyword}", method = RequestMethod.GET)
	@GetMapping(value = "search/{keyword1}")
	//@ResponseBody
	// public List<ProductDTO> searchProducts(@PathVariable(name = "keyword") String
	// keyword) {

	public List<ProductDTO> searchProducts(@PathVariable(name = "keyword1", required = true) String keyword) {
		System.out.println("keyword in the request " + keyword);
		List<ProductDTO> searchResults = productService.searchProducts(keyword);
		return searchResults;
	}

	// @RequestParam approach
	@GetMapping(value = "/productId")
	//@ResponseBody
	public ProductDetail findProduct(@RequestParam(name = "productId", required = true) Integer productId)
			throws Exception {
		System.out.println("product in the request " + productId);
		ProductDetail searchResults = productService.findProduct(productId);
		return searchResults;
	}

	@PostMapping(value = "/add-product")
	//@ResponseBody
	// public String addProduct(@RequestBody @Valid ProductDTO productDTO,
	//@RequestParam(name = "sellerId") Integer sellerId)
	public String addProduct(@ModelAttribute @Valid ProductDTO productDTO, @RequestParam(name = "sellerId") Integer sellerId)
			throws SellerNotFoundException, IOException {
		System.out.println("product dto from request " + productDTO);
		System.out.println("seller id from request " + sellerId);
		Integer id = productService.addProduct(productDTO, sellerId);
		return "Product added sucessfully with productId :" + id;
	}

	@DeleteMapping(value = "/delete")
	//@ResponseBody
	public String deleteProduct(@RequestParam(name = "pId") Integer productId) throws Exception {
		productService.deleteProduct(productId);
		return "product deleted successfully with produtId " + productId;
	}

	@PutMapping(value = "/update/{productId}")
	//@ResponseBody
	public ResponseEntity<String> updateProductQuantity(@PathVariable Integer productId,
			@RequestParam(name = "qty") Integer quantity) throws Exception {
		Integer updatedValue = productService.updateProduct(productId, quantity);
		return new ResponseEntity<String>(
				"product quantity updated successfully with quantity " + quantity + " productId" + productId,
				HttpStatus.CREATED);
	}

	@PostMapping(value = "upload-file")
	//@ResponseBody
	public ResponseEntity<Byte[]> uploadFile(@RequestParam(name = "file") MultipartFile file) throws IOException {
		System.out.println("uploaded file name " + file.getOriginalFilename());

		Byte[] fileIntoBinary = new Byte[file.getBytes().length];
		int i = 0;
		for (byte b : file.getBytes()) {
			fileIntoBinary[i] = b;
			i++;
		}
		return new ResponseEntity<Byte[]>(fileIntoBinary, HttpStatus.ACCEPTED);

	}

}
