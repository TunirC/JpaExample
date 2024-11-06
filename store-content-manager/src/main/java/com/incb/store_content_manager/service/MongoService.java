package com.incb.store_content_manager.service;

import com.incb.store_content_manager.exception.DBProcessException;
import com.incb.store_content_manager.model.CartEntity;
import com.incb.store_content_manager.model.Product;
import com.incb.store_content_manager.model.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MongoService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveProducts(List<ProductEntity<?>> productList) {
        try {
            productList.forEach(mongoTemplate::save);
            log.info("products saved successfully");
        } catch (Exception e) {
            throw new DBProcessException("Failed to save products in mongodb collection", e);
        }
    }

    public void saveCartDetails(List<CartEntity> cartList) {
        try {
            cartList.forEach(mongoTemplate::save);
            log.info("cart details saved successfully");
        } catch (Exception e) {
            throw new DBProcessException("Failed to save cart details in mongodb collection", e);
        }
    }

    public boolean isProductPresent(Product<?> product) {
        try {
            Query isPresentQuery = Query.query(Criteria.where("id").is(product.getId()));
            return mongoTemplate.exists(isPresentQuery, Product.class);
        } catch (Exception e) {
            throw new DBProcessException("product not present in DB");
        }
    }

    public boolean isCartPresent(Product<?> product) {
        try {
            Query isPresentQuery = Query.query(Criteria.where("id").is(product.getId()));
            return mongoTemplate.exists(isPresentQuery, Product.class);
        } catch (Exception e) {
            throw new DBProcessException("cart not present in DB");
        }
    }



}
