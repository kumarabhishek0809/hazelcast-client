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
	// com.hazelcast.config.Config
	/*
	 * Hazelcast allows clients to be configured within the client code
	 * (programmatically), by XML, or by properties files. Configuration uses
	 * properties files (handled by the class com.hazelcast.client.config.
	 * ClientConfigBuilder) a
	 */

	/*
	 * Declarative 
	@Bean
	public ClientConfig clientConfig() throws Exception {
		//Declarative.
		return new XmlClientConfigBuilder().build();
	}
	*/
	//programmatic
	@Bean
	public ClientConfig clientConfig() {
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
		networkConfig.addAddress("172.17.0.4:5701", "172.17.0.6:5701")
		             .setSmartRouting(true)
		             .addOutboundPortDefinition("34700-34710")
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
