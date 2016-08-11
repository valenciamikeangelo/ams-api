package com.mav.proto.core.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * Concrete Implementation for ProductService
 * {@link ProductService}
 */
@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * 
	 * Description: Return a Product Resource based on a given product code
	 * Return Type: Product.class
	 * Parameters : String productCode
	 */
	public Product getProductByCode(String productCode) throws Exception {
		return productRepository.getProductByCode(productCode);
	}

	/**
	 * 
	 * Description: Return a list of Products available in the database
	 * Return Type: List<Product>
	 * Parameters : None
	 */
	public List<Product> getAllProducts() throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
	}

}
