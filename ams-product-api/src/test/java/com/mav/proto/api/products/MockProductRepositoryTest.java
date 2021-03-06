package com.mav.proto.api.products;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mav.proto.api.exceptions.DependencyNotFoundException;
import com.mav.proto.api.exceptions.EmptyResultException;
import com.mav.proto.api.exceptions.NoMatchingRecordFoundException;
import com.mav.proto.core.products.Product;
import com.mav.proto.core.products.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class MockProductRepositoryTest {

	@Mock
	Map<String, Product> productRepo;

	@Test(expected=DependencyNotFoundException.class)
	public void testNoDataStoreAvailable() throws Exception{
		MockProductRepository SUT = new MockProductRepository(null);
	}
	
	@Test(expected=EmptyResultException.class)
	public void testNoProductAvailable()throws Exception{
		MockProductRepository SUT = new MockProductRepository(productRepo);
		when(productRepo.values()).thenReturn(new ArrayList<Product>());
		SUT.getAllProducts();
	}
	
	@Test(expected=EmptyResultException.class)
	public void testNullProducts()throws Exception{
		MockProductRepository SUT = new MockProductRepository(productRepo);
		when(productRepo.values()).thenReturn(null);
		SUT.getAllProducts();
	}

	@Test
	public void testAllProductsRetrived()throws Exception{
		MockProductRepository SUT = new MockProductRepository(productRepo);
		when(productRepo.values()).thenReturn(setupProduct());
		List<Product> products=SUT.getAllProducts();
		assertNotNull(products);
		assertFalse(products.isEmpty());
		assertEquals(4, products.size());
		assertEquals("1", products.get(0).getCode());
		assertEquals("2", products.get(1).getCode());
		assertEquals("3", products.get(2).getCode());
		assertEquals("4", products.get(3).getCode());
	}
	
	
	@Test(expected=NoMatchingRecordFoundException.class)
	public void testNoMatchProductCode()throws Exception{
		MockProductRepository SUT = new MockProductRepository(productRepo);
		when(productRepo.get("")).thenThrow(NoMatchingRecordFoundException.class);
		SUT.getProductByCode("");
	}
	
	@Test
	public void testCorrectProductsRetrivedByCode()throws Exception{
		MockProductRepository SUT = new MockProductRepository(productRepo);
		when(productRepo.get("1")).thenReturn(new Product("1","ult_small","Unlimited 1GB", 24.90,30,true,true,1024,true,true,"",""));
		when(productRepo.get("2")).thenReturn(new Product("2","ult_medium","Unlimited 2GB", 29.90,30,true,true,1024,true,true,"",""));
		when(productRepo.get("3")).thenReturn(new Product("3","ult_large","Unlimited 5GB", 44.90,30,true,true,1024,true,true,"",""));
		when(productRepo.get("4")).thenReturn(new Product("4","ult_xlarge","Unlimited 8GB", 49.90,30,true,true,1024,true,true,"",""));
		
		Product p1=SUT.getProductByCode("1");
		assertEquals("1", p1.getCode());
		assertEquals("ult_small", p1.getName());
		assertEquals("Unlimited 1GB", p1.getDescription());

		Product p2=SUT.getProductByCode("2");
		assertEquals("2", p2.getCode());
		assertEquals("ult_medium", p2.getName());
		assertEquals("Unlimited 2GB", p2.getDescription());

		Product p3=SUT.getProductByCode("3");
		assertEquals("3", p3.getCode());
		assertEquals("ult_large", p3.getName());
		assertEquals("Unlimited 5GB", p3.getDescription());
		
		Product p4=SUT.getProductByCode("4");
		assertEquals("4", p4.getCode());
		assertEquals("ult_xlarge", p4.getName());
		assertEquals("Unlimited 8GB", p4.getDescription());
		
	}
	    
		
	private List<Product> setupProduct(){
		List<Product> products= new ArrayList<Product>();
		products.add(new Product("1","ult_small","Unlimited 1GB", 24.90,30,true,true,1024,true,true,"",""));
		products.add(new Product("2","ult_medium","Unlimited 2GB", 29.90,30,true,true,1024,true,true,"",""));
		products.add(new Product("3","ult_large","Unlimited 5GB", 44.90,30,true,true,1024,true,true,"",""));
		products.add(new Product("4","ult_xlarge","Unlimited 8GB", 49.90,30,true,true,1024,true,true,"",""));
		return products;
	}
}
