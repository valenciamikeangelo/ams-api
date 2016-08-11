package com.mav.proto.core.products;

import java.util.List;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * Interface to retrieve Product data from target data store ( File , DB )
 */
public interface ProductRepository {

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
