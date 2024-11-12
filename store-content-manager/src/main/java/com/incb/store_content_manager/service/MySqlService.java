package com.incb.store_content_manager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incb.store_content_manager.model.Product;
import com.incb.store_content_manager.model.mysql.ProductTableEntity;
import com.incb.store_content_manager.repository.mongo.ProductRepository;
import com.incb.store_content_manager.repository.mysql.SqlProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MySqlService {

    private SqlProductRepository productRepository;

    @Autowired
    public MySqlService(@Qualifier("mySqlProductRepository") SqlProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductTableEntity productTableEntity) {
        try {
            productRepository.save(productTableEntity);
            log.info("product saved in mysql db");
        } catch (Exception e) {
            log.error("error while saving data to mysql db.", e);
        }
    }

    public void saveListOfProducts(List<Product> product) {}
}
