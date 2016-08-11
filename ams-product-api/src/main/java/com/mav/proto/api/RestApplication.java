package com.mav.proto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

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

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestApplication.class, args);
    }

    
    
}