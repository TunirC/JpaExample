package com.incb.store_content_manager.repository.mongo;

import com.incb.store_content_manager.model.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoProductRepository")
public interface ProductRepository extends MongoRepository<ProductEntity<?>, Integer> {
}
