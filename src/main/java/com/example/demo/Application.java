package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.example.demo.config.CacheRibbonServiceConfiguration;


@SpringBootApplication
@RibbonClient(name = "cache-service-2",configuration = CacheRibbonServiceConfiguration.class)
public class Application {

        public static void main(String[] args) {
                SpringApplication.run(Application.class, args);
        }

}