package com.xiaoran.elasticsearch.demo;

import com.xiaoran.elasticsearch.demo.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long>{

}
