package com.mav.proto.api.products;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mav.proto.core.common.ErrorEntityHolder;
import com.mav.proto.core.products.Product;
import com.mav.proto.core.products.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/products")
@Produces({ MediaType.APPLICATION_JSON })
@Component
@Api(value = "Products API", produces = "application/json")
public class ProductsApi {
	
	@Autowired
	private ProductService productsService;

	@GET
	@Path("/{code}")
	@ApiOperation(value = "Gets a Product Resource by Product Code. Version 1 - (version in URL)", response = Product.class)
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Product resource found"),
	@ApiResponse(code = 404, message = "Given admin user not found")})
	public Response getProductByCode(@PathParam("code") String productCode ){
		try {
			Product result= productsService.getProductByCode(productCode);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			return buildErrorResponse(e);
		}
    }
	
	
	@GET
	@ApiOperation(value = "Gets all Product Resource in the database. Version 1 - (version in URL)", response = List.class)
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Product resource found"),
	@ApiResponse(code = 404, message = "No Products are registered at the moment")})
	public Response getAllProducts(){
		try {
		List<Product> result= productsService.getAllProducts();
		return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			return buildErrorResponse(e);
		}
    }
	
	/**
	 * 
	 * Description: 
	 * Return Type: Response
	 * Parameters : Exception
	 */
	 //todo Handle Custom Response based on Exception Types (NotFoundException, EmptyResultException)
	private Response buildErrorResponse(Exception e){
		return Response.status(Status.NOT_FOUND).entity(new ErrorEntityHolder("404",e.getMessage())).build();
	}
}
