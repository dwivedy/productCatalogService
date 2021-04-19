package com.dwivedy.productCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dwivedy")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ProductCatalogServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
	}

}
