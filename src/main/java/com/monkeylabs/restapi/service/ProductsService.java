package com.monkeylabs.restapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkeylabs.restapi.model.Product;
import com.monkeylabs.restapi.repository.ProductRepository;

@Service
public class ProductsService {

	private Logger LOG = LoggerFactory.getLogger(ProductsService.class);
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getProducts() {
		LOG.info("Getting all products");
		return productRepository.findAll();
	}
	
	public Optional<Product> getProduct(String id) {
		return productRepository.findById(id);
	}
	
	public Product createProduct(Product newProduct) {
		Product productToSave = new Product();
		try {
			LOG.info("Saving product..." );
			productToSave = productRepository.save(newProduct);
			return productToSave;
		} catch (Exception e) {
			LOG.error("An error occurred during product saving");
		}
		return productToSave;
	}
	
	public Product updateProduct(Product updatedProduct, String id) {
		Product foundProduct = productRepository.findById(id).orElse(null);
		
		if(foundProduct != null) {
			foundProduct.setName(updatedProduct.getName());
			foundProduct.setDescription(updatedProduct.getDescription());
			foundProduct.setType(updatedProduct.getType());
			foundProduct.setCategory(updatedProduct.getCategory());
			return productRepository.save(foundProduct);
		} else {
			return updatedProduct;
		}
	}

	public void deleteProduct(String id) {
		productRepository.deleteById(id);
		
	}
	
	
}
