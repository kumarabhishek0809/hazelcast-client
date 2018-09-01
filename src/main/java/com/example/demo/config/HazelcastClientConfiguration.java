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
		clientConfig.getNetworkConfig().addAddress("127.0.0.1");
		// .setSmartRouting(true)
//				.addOutboundPortDefinition("34700-34710").setRedoOperation(true).setConnectionTimeout(5000)
//				.setConnectionAttemptLimit(5);
		clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
		clientConfig.setInstanceName("hazelcast-instance");

		return clientConfig;

	}

	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
		return HazelcastClient.newHazelcastClient(clientConfig);
	}

}
