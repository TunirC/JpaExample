package com.incb.store_content_manager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incb.store_content_manager.client.StoreProductRequestClient;
import com.incb.store_content_manager.exception.ProductNotAvailableException;
import com.incb.store_content_manager.model.Product;
import com.incb.store_content_manager.model.ProductEntity;
import com.incb.store_content_manager.model.mysql.ProductTableEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductFetchService, ProductUpdateService {

    private ObjectMapper objectMapper;
    private StoreProductRequestClient productRequestClient;
    private MongoService mongoService;
    private MySqlService mySqlService;

    @Autowired
    public ProductServiceImpl(StoreProductRequestClient productRequestClient, ObjectMapper objectMapper, MongoService mongoService, MySqlService mySqlService) {
        this.productRequestClient = productRequestClient;
        this.objectMapper = objectMapper;
        this.mongoService = mongoService;
        this.mySqlService = mySqlService;
    }

    @Override
    public List<Product<?>> fetchAllProducts() {
        log.info("Fetching all the products details available in storefront currently");
        try {
            return productRequestClient.getAllProducts();
        } catch (RuntimeException e) {
            log.info("failed to retrieve product details from database");
            log.error("err: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product<?> fetchProduct(Integer productId) {
        log.info("fetching cart details for user id: {}", productId);
        //return Optional.ofNullable(productRequestClient.getProductById(productId)).orElseThrow(() -> new ProductNotAvailableException("product not available for id: " + productId));
        ProductEntity<?> product = Optional.ofNullable(mongoService.getProduct(productId))
                .orElseThrow(() -> new ProductNotAvailableException("product not available for id: " + productId));
        return objectMapper.convertValue(product, Product.class);
    }

    @Override
    public void saveProduct(Product<?> product) {
        try {
            //ProductEntity<?> productEntity = objectMapper.convertValue(product, ProductEntity.class);
            //mongoService.saveProducts(Collections.singletonList(productEntity));

            ProductTableEntity productTableEntity = objectMapper.convertValue(product, ProductTableEntity.class);
            mySqlService.saveProduct(productTableEntity);
        } catch (RuntimeException e) {
            log.info("failed to save following product details in database: {}", product);
            log.error("err: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveListOfProducts(List<Product> productList) {
        try {
            List<ProductEntity<?>> productEntityList = objectMapper.convertValue(productList, new TypeReference<>() {});
            mongoService.saveProducts(productEntityList);
        } catch (RuntimeException e) {
            log.info("failed to save following productList details in database: {}", productList);
            log.error("err: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
