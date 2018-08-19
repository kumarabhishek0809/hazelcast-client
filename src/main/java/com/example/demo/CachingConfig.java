package com.example.demo;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
	
	/*
	 * If we comment spring will provide Cachemanger by default which is available. 

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("ticketsCache");
	}
	*/

}
