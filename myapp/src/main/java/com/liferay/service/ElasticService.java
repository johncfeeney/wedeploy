package com.liferay.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {
	
	@Value("${com.liferay.tagger.elasticservice.host}")
	private String elastichost;
	@Value("${com.liferay.tagger.elasticservice.port}")
	private Integer elasticport;
	@Value("${com.liferay.tagger.elasticservice.clustername}")
	private String clustername;
	

	private static Client esClient = null;
	
	public String testESConnection() {
		//return getESClient().prepareSearch(index).setSize(0).execute().actionGet().toString();
		return "test completed";
	}

	private Client getESClient() {
		if (esClient == null) {
			try {
				Settings settings = Settings
										.settingsBuilder()
										//.put("client.transport.ignore_cluster_name", true)
										.put("client.transport.sniff", true)
										.put("cluster.name",clustername)
										.build();
						
				esClient = TransportClient
							.builder()
							.settings(settings)
							.build()
							.addTransportAddress(
									new InetSocketTransportAddress(
											InetAddress.getByName(elastichost),elasticport));
			} catch (UnknownHostException ex) {
				esClient = null;
			}
		}
		return esClient;
	}
}