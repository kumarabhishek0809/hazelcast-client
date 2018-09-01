package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@EnableCaching
public class CachingConfig {

	/*
	 * If we comment spring will provide Cachemanger by default which is available.
	 * 
	 * @Bean public CacheManager cacheManager() { return new
	 * ConcurrentMapCacheManager("ticketsCache"); }
	 */

	@Autowired
	private HazelcastInstance hazelcastInstance;

	@Bean
	public CacheManager cacheManager() {
		return new HazelcastCacheManager(hazelcastInstance);
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

}
