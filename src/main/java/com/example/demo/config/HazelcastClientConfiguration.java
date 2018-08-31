package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("client")
public class HazelcastClientConfiguration {
	@Bean
	public ClientConfig clientConfig() {
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
		networkConfig.addAddress("172.17.0.1","172.17.0.2")
		             .setSmartRouting(true)
		             .addOutboundPortDefinition("5701-5710")
		             .setRedoOperation(true)
		             .setConnectionTimeout(5000)
		             .setConnectionAttemptLimit(5);
		
		return clientConfig;

	}

	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
		return HazelcastClient.newHazelcastClient(clientConfig);
	}

}
