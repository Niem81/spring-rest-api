package com.monkeylabs.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monkeylabs.restapi.model.Product;
import com.monkeylabs.restapi.service.ProductsService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductsController {

	private ProductsService productService;

	@Autowired
	private void productService(ProductsService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable(name = "id") String id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product newProduct) {
		return productService.createProduct(newProduct);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody Product updatedProduct, @PathVariable(name = "id") String id) {
		return productService.updateProduct(updatedProduct, id);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable(name = "id") String id) {
		productService.deleteProduct(id);
	}
	
}
