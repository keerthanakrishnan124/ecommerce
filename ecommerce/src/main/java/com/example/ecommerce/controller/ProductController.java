package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/home")
	public String home() {
		return "Wlcome to new project";
	}
	
	@GetMapping("/products")
	public List<Product> getALLProucts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id){
		return service.getProductsById(id);
	}
	
	@PostMapping("admin/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			Product product1=service.addProduct(product);
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch (Exception e) {
		  return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("admin/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody Product product)
	{
		Product product1=service.getProductsById(id);
		if(product1 != null) {
			service.updateProduct(id,product);
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no product available",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/product/{name}")
	public ResponseEntity<?> searchProduct(@PathVariable String name){
		List<Product> product=service.searchProduct(name);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products = service.searchProducts(keyword);
        System.out.println("searching with " + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	
	@DeleteMapping("admin/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}
}



