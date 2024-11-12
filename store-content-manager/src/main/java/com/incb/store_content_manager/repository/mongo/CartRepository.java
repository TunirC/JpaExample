package com.incb.store_content_manager.repository.mongo;

import com.incb.store_content_manager.model.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoCartRepository")
public interface CartRepository extends MongoRepository<CartEntity, Integer> {
}
