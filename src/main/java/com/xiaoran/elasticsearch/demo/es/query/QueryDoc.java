package com.xiaoran.elasticsearch.demo.es.query;

import com.xiaoran.elasticsearch.demo.util.ConnectElasticsearch;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;

public class QueryDoc {

  public static void main(String[] args) {
    ConnectElasticsearch.connect(client -> {
      SearchRequest request = new SearchRequest();
      request.indices("user");
      // 1.查询所有数据
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
      // 2.条件查询
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30));
      // 3. 分页查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//      // (当前页码 - 1) * 每页显示数据条数
//      searchSourceBuilder.from(2);
//      searchSourceBuilder.size(2);
      // 4. 查询排序
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//      searchSourceBuilder.sort("age", SortOrder.DESC);
      // 5. 过滤字段
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//      String[] excludes = {"age"};
//      String[] includes = {};
//      searchSourceBuilder.fetchSource(includes, excludes);
      // 6.组合查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//      boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
//      boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//      boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//      boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//      searchSourceBuilder.query(boolQueryBuilder);
      // 7. 范围查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//      rangeQuery.gte(30);
//      rangeQuery.lte(40);
      // 8.模糊查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      searchSourceBuilder.query(QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.TWO));
      // 9. 高亮查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");
//
//      HighlightBuilder highlightBuilder = new HighlightBuilder();
//      highlightBuilder.preTags("<font color='red'>");
//      highlightBuilder.postTags("</font>");
//      highlightBuilder.field("name");
//      searchSourceBuilder.highlighter(highlightBuilder);
//      searchSourceBuilder.query(termQueryBuilder);

      // 10. 聚合查询
//      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//      MaxAggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//      searchSourceBuilder.aggregation(aggregationBuilder);
      // 11. 分组查询
      SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
      TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
      searchSourceBuilder.aggregation(termsAggregationBuilder);

      request.source(searchSourceBuilder);
      SearchResponse response = client.search(request, RequestOptions.DEFAULT);
      SearchHits hits = response.getHits();
      System.out.println("count:" + hits.getTotalHits());
      System.out.println("took:" + response.getTook());
      for (SearchHit hit : hits) {
        System.out.println(hit.getSourceAsString());
      }
    });
  }

}
