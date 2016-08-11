package com.mav.proto.api;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mav.proto.api.products.ProductsApi;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * 
 * Configuration class to bootstrap Jersey Framework together with Swagger UI support
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	@Value("${spring.jersey.application-path}")
	private String apiPath;
	
    public JerseyConfig() {
        registerEndpoints();
    }
    
    /**
     * Configuration for Swagger UI 
     */
    @PostConstruct
    private void configureSwagger() {
    	    // Available at localhost:port/swagger.json
    	     this.register(ApiListingResource.class);
    	     this.register(SwaggerSerializers.class);
    	 
    	     BeanConfig config = new BeanConfig();
    	     config.setConfigId("ams-exam");
    	     config.setTitle("AMS Problem 2");
    	     config.setVersion("v1");
    	     config.setContact("Michael Angelo Valencia");
    	     config.setSchemes(new String[] { "http", "https" });
    	     config.setBasePath(this.apiPath);
    	     config.setResourcePackage("com.mav.proto");
    	     config.setPrettyPrint(true);
    	     config.setScan(true);
    	   }

     /**
      * Endpoints registration for Jersey REST services
      */
    private void registerEndpoints() {
        register(WadlResource.class);
        register(ProductsApi.class);

    }
}

