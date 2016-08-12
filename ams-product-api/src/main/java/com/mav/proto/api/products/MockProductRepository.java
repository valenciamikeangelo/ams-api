package com.mav.proto.api.products;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mav.proto.api.exceptions.DependencyNotFoundException;
import com.mav.proto.api.exceptions.EmptyResultException;
import com.mav.proto.api.exceptions.NoMatchingRecordFoundException;
import com.mav.proto.core.products.Product;
import com.mav.proto.core.products.ProductRepository;

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
	
	

	/**
	 * 
	 * @param productRepo
	 * @throws DependencyNotFoundException
	 * 
	 * Constructor for Non Spring Containers
	 */
	public MockProductRepository(Map<String, Product> productRepo) throws DependencyNotFoundException {
		if (productRepo == null)
			throw new DependencyNotFoundException(Map.class);
		this.productRepo = productRepo;
	}

	/**
	 * 
	 * Description: Return a Product Resource based on a given product code
	 * Return Type: Product.class Parameters : String productCode
	 */
	public Product getProductByCode(String productCode) throws Exception {
		Product result = productRepo.get(productCode);
		if (result == null)
			throw new NoMatchingRecordFoundException("No Product with Code " + productCode + " Exist in our database.");
		return result;
	}

	/**
	 * 
	 * Description: Return a list of Products available in the database Return
	 * Type: List<Product> Parameters : None
	 */
	public List<Product> getAllProducts() throws Exception {
		Collection<Product> values=productRepo.values();
		if(values==null ||values.isEmpty())throw new EmptyResultException("No Products are registered at the moment");
		return Collections.unmodifiableList(new ArrayList<Product>(values));
	}

	
}
