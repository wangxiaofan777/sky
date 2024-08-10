package com.wxf.sky.elasticsearch.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Wxf
 * @since 2024-08-10 15:22:35
 **/
@Configuration
public class ElasticsearchConfig {

//    @Bean
//    public ElasticsearchClient elasticsearchClient( ) {
//        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http"))
//                .setCompressionEnabled(true)
//                .setHttpClientConfigCallback(callback -> {
//                    BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//                    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "elastic"));
//                    return callback.setDefaultCredentialsProvider(
//                            credentialsProvider
//                    );
//                })
//                .build();

//        RestClientTransport restClientTransport = new RestClientTransport(restClient, new JacksonJsonpMapper());
//        return new ElasticsearchClient(restClientTransport);
//    }
}
