package com.monkeylabs.restapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.monkeylabs.restapi.model.Product;
import com.monkeylabs.restapi.repository.ProductRepository;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class RestApiDemoProjectApplication implements CommandLineRunner {

	private ProductRepository productRepository;
	private Logger LOG = LoggerFactory.getLogger(RestApiDemoProjectApplication.class);

	@Autowired
	private void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product product1 = new Product();
		product1.setName("Ponyo Toy");
		product1.setDescription("Handmade Toy made of cottom");
		product1.setCategory("Toy");
		product1.setType("Handmade");
		
		productRepository.save(product1);
		
		Product product2 = new Product();
		product2.setName("Sosuke Toy");
		product2.setDescription("Handmade Toy made of cottom");
		product2.setCategory("Toy");
		product2.setType("Custom");
		
		productRepository.save(product2);
		
		List<Product> products = productRepository.findAll();
		
		for(Product product : products) {
			LOG.info("Products found: " + product.toString());
		}
		
	}
	
	
	

	
}
