package com.example.ecommerce.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.ProductRepo;



@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;

	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}

	public Product getProductsById(int id) {
		
		return productRepo.findById(id).get();
	}

	public Product addProduct(Product product) {
//		product.setImageName(imageFile.getOriginalFilename());
//		product.setImageType(imageFile.getContentType());
//		product.setImageData(imageFile.getBytes());
		return productRepo.save(product);
	}

	public Product updateProduct(int id, Product product) {
		return productRepo.save(product);
	}

	public List<Product> searchProduct(String name) {
		
		return productRepo.findByname(name);
		
	}
	

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

    public List<Product> searchProducts(String keyword) {
      
			return productRepo.searchProducts(keyword);
		
    }
	

}
