package com.mav.proto.api.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.proto.core.products.Product;
import com.mav.proto.core.products.ProductRepository;
import com.mav.proto.core.products.ProductService;

/**
 * 
 * @author Michael Angelo Valencia
 *
 *         Aug 11, 2016
 * 
 *         Mock Data Provider for Products Repository Data is retrieved from
 *         products.json file
 *         
 *         {@link ProductRepository}
 */
@Component("productRepository")
public class MockProductRepository implements ProductRepository {

	static Logger log = Logger.getLogger(MockProductRepository.class.getName());

	private Map<String, Product> productRepo;
	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * 
	 * Description: Return a Product Resource based on a given product code
	 * Return Type: Product.class
	 * Parameters : String productCode
	 */
	public Product getProductByCode(String productCode) throws Exception {
		Product result = productRepo.get(productCode);
		if (result == null)
			throw new Exception("No Product with Code " + productCode + " Exist in our database.");
		return result;
	}
	
	
	/**
	 * 
	 * Description: Return a list of Products available in the database
	 * Return Type: List<Product>
	 * Parameters : None
	 */
	public List<Product> getAllProducts() throws Exception {
		List<Product> result = Collections.unmodifiableList(new ArrayList<Product>(productRepo.values()));
		if (result == null)
			throw new Exception("No Products are registered at the moment");
		return result;
	}

	/**
	 * 
	 * Description: Populate in memory product store during Spring Post Construct lifecycle
	 * Return Type: void
	 * Parameters :
	 */
	@PostConstruct
	public void init() throws Exception {
		this.productRepo = new HashMap<String, Product>();

		Resource resource = resourceLoader.getResource("classpath:/data/products.json");
		ObjectMapper mapper = new ObjectMapper();
		List<Product> result = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {
		});
		if (result != null && !result.isEmpty()) {
			for (Product product : result) {
				this.productRepo.put(product.getCode(), product);
			}
		}

		log.info("Init method after properties are set : products = " + result);
		log.info("Init method after properties are set : productRepo = " + this.productRepo);
	}

}
