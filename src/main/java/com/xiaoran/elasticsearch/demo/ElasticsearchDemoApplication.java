package com.xiaoran.elasticsearch.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@MapperScan("com.xiaoran.elasticsearch.demo.mapper")
@SpringBootApplication
public class ElasticsearchDemoApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(ElasticsearchDemoApplication.class, args);

  }

}
