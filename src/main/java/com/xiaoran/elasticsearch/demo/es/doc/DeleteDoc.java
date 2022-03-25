package com.xiaoran.elasticsearch.demo.es.doc;

import com.xiaoran.elasticsearch.demo.util.ConnectElasticsearch;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;

public class DeleteDoc {

  public static void main(String[] args) {
    ConnectElasticsearch.connect(client -> {
      // 删除文档 - 请求对象
      DeleteRequest request = new DeleteRequest();
      // 配置删除参数
      request.index("user").id("1001");
      // 客户端发送请求，获取响应对象
      DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
      System.out.println("_index:" + response.toString());
      System.out.println("_id:" + response.getId());
    });
  }

}
