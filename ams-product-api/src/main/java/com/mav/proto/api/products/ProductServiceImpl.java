package com.mav.proto.api.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mav.proto.api.exceptions.DependencyNotFoundException;
import com.mav.proto.api.exceptions.EmptyResultException;
import com.mav.proto.core.products.Product;
import com.mav.proto.core.products.ProductRepository;
import com.mav.proto.core.products.ProductService;

/**
 * 
 * @author Michael Angelo Valencia
 *
 *         Aug 11, 2016 Concrete Implementation for ProductService
 *         {@link ProductService}
 */
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 
	 * @param productRepository
	 * @throws DependencyNotFoundException
	 * 
	 *  Constructor for Non Spring Containers
	 */

	public ProductServiceImpl(ProductRepository productRepository) throws DependencyNotFoundException {
		if (productRepository == null)
			throw new DependencyNotFoundException(ProductRepository.class);
		this.productRepository = productRepository;
	}

	/**
	 * 
	 * Description: Return a Product Resource based on a given product code
	 * Return Type: Product.class Parameters : String productCode
	 */
	public Product getProductByCode(String productCode) throws Exception {
		return productRepository.getProductByCode(productCode);
	}

	/**
	 * 
	 * Description: Return a list of Products available in the database Return
	 * Type: List<Product> Parameters : None
	 */
	public List<Product> getAllProducts() throws Exception {
		List<Product> products = productRepository.getAllProducts();
		if (products == null || products.isEmpty())
			throw new EmptyResultException();
		return products;
	}

}
