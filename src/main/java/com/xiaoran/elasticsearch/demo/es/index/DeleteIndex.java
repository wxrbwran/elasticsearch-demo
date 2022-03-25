package com.xiaoran.elasticsearch.demo.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class DeleteIndex {
  public static void main(String[] args) throws IOException {
    // 创建客户端对象
    RestHighLevelClient client = new RestHighLevelClient(
        RestClient.builder(new HttpHost("121.37.67.93", 9200, "http")));

    // 删除索引 - 请求对象
    DeleteIndexRequest request = new DeleteIndexRequest("user2");
    // 发送请求，获取响应
    AcknowledgedResponse response = client.indices().delete(request,RequestOptions.DEFAULT);
    // 操作结果
    System.out.println("操作结果 ： " + response.isAcknowledged());
    client.close();

    client.close();
  }
}
