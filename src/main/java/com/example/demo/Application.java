package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.example.demo.config.CacheRibbonServiceConfiguration;


@SpringBootApplication
@RibbonClient(name = "cache-service-2",configuration = CacheRibbonServiceConfiguration.class)
public class Application {

        public static void main(String[] args) {
        	 new SpringApplicationBuilder()
             .sources(Application.class)
             //.profiles("client") spring.profiles.active
             //.profiles("server")
             .run(args);
        	
        }

}