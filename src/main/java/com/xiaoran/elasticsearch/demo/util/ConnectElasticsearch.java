package com.xiaoran.elasticsearch.demo.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ConnectElasticsearch {
  public static void connect(ElasticsearchTask task){
    // 创建客户端对象
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("121.37.67.93", 9200, "http")));
    try {
      task.doSomething(client);
      // 关闭客户端连接
      client.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
