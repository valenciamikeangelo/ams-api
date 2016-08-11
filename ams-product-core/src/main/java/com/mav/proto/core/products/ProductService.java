package com.mav.proto.core.products;

import java.util.List;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * 
 * Core Service to manage Product events
 * based Hexagonal Architecture design
 */
public interface ProductService {
	
	/**
	 * 
	 * Description: Return a Product Resource based on a given product code
	 * Return Type: Product.class
	 * Parameters : String productCode
	 */
	Product getProductByCode(String productCode ) throws Exception;
	
	/**
	 * 
	 * Description: Return a list of Products available in the database
	 * Return Type: List<Product>
	 * Parameters : None
	 */
	List<Product> getAllProducts() throws Exception;
}
