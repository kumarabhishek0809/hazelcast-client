package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.listener.ClusterMembershipListener;
import com.example.demo.listener.MapEntryListener;
import com.example.demo.listener.SampleDistributedObjectListener;
import com.hazelcast.config.Config; // This Bean on The Class Path Defines Hazel Cast.
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ListenerConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.TcpIpConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("server")
public class HazelcastServerConfiguration {
	// com.hazelcast.config.Config
	@Bean
	public Config config() {
		MapConfig mapconfig = new MapConfig().setName("ticketsCache")
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
				.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(20);

		Config config = new Config();
		config.setInstanceName("hazelcast-instance").addMapConfig(mapconfig)
				.setProperty("hazelcast.logging.type", "slf4j")
				.setProperty("hazelcast.initial.min.cluster.size", "3")
				.setProperty("hazelcast.socket.client.bind.any", "false"); // Hazelcast binds to all local network interfaces to accept incoming traffic

		// setting network topology.
		NetworkConfig networkConfig = config.getNetworkConfig();

		// Join toplogy In production never use Multicast at it connects to all the
		// sever on the same network.
		JoinConfig join = networkConfig.getJoin();
		TcpIpConfig tcpIpConfig = join.getTcpIpConfig();
		join.getAwsConfig().setEnabled(false);
		join.getMulticastConfig().setEnabled(false);
		join.getTcpIpConfig().setEnabled(true);

		tcpIpConfig.addMember("172.17.0.1:5701");
		tcpIpConfig.addMember("172.17.0.4:5701");
		tcpIpConfig.addMember("172.17.0.3:5701");
		
		tcpIpConfig.setRequiredMember("172.17.0.3:5701"); // It will not start if this IP address is not found
		tcpIpConfig.setConnectionTimeoutSeconds(30);
		
		config.getGroupConfig().setName("dev");// 
		
		config.addListenerConfig(new ListenerConfig("com.example.demo.listener.ClusterMembershipListener"));
		config.addListenerConfig(new ListenerConfig("com.example.demo.listener.SampleDistributedObjectListener"));
		config.addListenerConfig(new ListenerConfig("com.example.demo.listener.ClusterMigrationListener"));
		//config.addListenerConfig(new ListenerConfig("com.example.demo.listener.MapEntryListener"));
		
		//networkConfig.setPortAutoIncrement(false); //Port [5701] is already in use and auto-increment is disabled. Hazelcast cannot start.
		return config;
	}

	@Bean
	public HazelcastInstance hazelcastInstance(Config config) {
		 HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
		 hazelcastInstance.getCluster().addMembershipListener( new ClusterMembershipListener() );
		 hazelcastInstance.addDistributedObjectListener( new SampleDistributedObjectListener() );

		 hazelcastInstance.getMap("ticketsCache").addEntryListener(new MapEntryListener(),true);
		 
		 return hazelcastInstance;
	}
}
