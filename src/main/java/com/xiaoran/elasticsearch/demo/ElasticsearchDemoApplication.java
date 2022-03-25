package com.xiaoran.elasticsearch.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ElasticsearchDemoApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(ElasticsearchDemoApplication.class, args);

  }

}
