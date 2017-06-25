package com.aditya.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

@SpringBootApplication
public class ShopkarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopkarApplication.class, args);
	}
	
	@Bean
    public PersistenceAnnotationBeanPostProcessor persistenceBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }
	
	
	
}
