package com.xiaoran.elasticsearch.demo.util;

import org.elasticsearch.client.RestHighLevelClient;

public interface ElasticsearchTask {
  void doSomething(RestHighLevelClient client) throws Exception;
}
