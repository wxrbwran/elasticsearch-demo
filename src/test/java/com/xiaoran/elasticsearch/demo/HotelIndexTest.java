package com.xiaoran.elasticsearch.demo;

import com.xiaoran.elasticsearch.demo.constants.HotelConstants;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

public class HotelIndexTest {

//  @Value("${elasticsearch.host}")
//  private String host ;
//
//  @Value("${elasticsearch.port}")
//  private Integer port ;

  private RestHighLevelClient client;

  @BeforeEach
  void setUp() {
    this.client = new RestHighLevelClient(RestClient.builder(
       HttpHost.create("http://103.105.200.216:9200")
    ));
  }

  @Test
  public void testInit() {
    System.out.println(client);
  }

  @Test
  public void createHotelIndex() throws IOException {
    //指定索引库名
    CreateIndexRequest hotel = new CreateIndexRequest("hotel");
    //写入JSON数据，这里是Mapping映射
    hotel.source(HotelConstants.MAPPING_TEMPLATE, XContentType.JSON);
    //创建索引库
    client.indices().create(hotel, RequestOptions.DEFAULT);
  }

  @Test
  void deleteHotelIndex() throws IOException {
    DeleteIndexRequest hotel = new DeleteIndexRequest("hotel");
    client.indices().delete(hotel, RequestOptions.DEFAULT);
  }

  @Test
  void existHotelIndex() throws IOException {
    GetIndexRequest hotel = new GetIndexRequest("hotel");
    boolean exists = client.indices().exists(hotel, RequestOptions.DEFAULT);
    System.out.println(exists);
  }

  @AfterEach
  void tearDown() throws IOException {
    this.client.close();
  }
}
