package com.poc.buddy;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;


import java.io.IOException;
@Service

public class ElasticSearch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearch.class);
    String serverUrl = "https://10.3.176.245:9200";
    String apiKey = "MmAYoZ1yQJSms-iw8n4lHg";
    public Product get() throws IOException {
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        Product product = new Product("bk-1", "City bike", (double) 123.0);

        IndexResponse response = esClient.index(i -> i
                .index("products")
                .id(product.getSku())
                .document(product)
        );


        GetResponse<Product> response1 = esClient.get(g -> g
                        .index("products")
                        .id("bk-1"),
                Product.class
        );
    return response1.source();

    }
}
