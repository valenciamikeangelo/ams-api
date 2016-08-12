package com.mav.proto.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.proto.core.products.Product;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * 
 * Spring Boot application Launcher for this REST application
 * Uses WAR packaging deployment support for AWS deployment
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.mav.proto" })
public class RestApplication extends SpringBootServletInitializer {
	
	@Autowired
	private ResourceLoader resourceLoader;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestApplication.class, args);
    }

    
    @Bean
    Map<String, Product> productRepo() throws Exception{
    	Map<String, Product> productRepo = new HashMap<String, Product>();

		Resource resource = resourceLoader.getResource("classpath:/data/products.json");
		ObjectMapper mapper = new ObjectMapper();
		List<Product> result = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {
		});
		if (result != null && !result.isEmpty()) {
			for (Product product : result) {
				productRepo.put(product.getCode(), product);
			}
		}
   
		return  productRepo;
		
    }
    
    
}