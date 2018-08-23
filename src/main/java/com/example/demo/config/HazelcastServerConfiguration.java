package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config; // This Bean on The Class Path Defines Hazel Cast.
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("server")
public class HazelcastServerConfiguration {
	// com.hazelcast.config.Config
	@Bean
	public Config hazelCastConfig() {
		return new Config().setInstanceName("hazelcast-instance")
				.addMapConfig(new MapConfig().setName("ticketsCache")
						.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(20))
				.setProperty("hazelcast.logging.type", "slf4j")
				.setProperty("hazelcast.initial.min.cluster.size","3")
				;
	}
	
	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
		return hazelcastInstance(hazelCastConfig);
	}
}
