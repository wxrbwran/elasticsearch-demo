package com.xiaoran.elasticsearch.demo.es.doc;

import com.xiaoran.elasticsearch.demo.util.ConnectElasticsearch;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

public class GetDoc {

  public static void main(String[] args) {
    ConnectElasticsearch.connect(client -> {
      // 修改文档 - 请求对象
      GetRequest request = new GetRequest();
      // 配置修改参数
      request.index("user").id("1001");
      // 设置请求体，对数据进行修改
      // 客户端发送请求，获取响应对象
      GetResponse response = client.get(request, RequestOptions.DEFAULT);
      System.out.println("_index:" + response.getIndex());
      System.out.println("_id:" + response.getId());
      System.out.println("_sourceAsString:" + response.getSourceAsString());
    });
  }

}
