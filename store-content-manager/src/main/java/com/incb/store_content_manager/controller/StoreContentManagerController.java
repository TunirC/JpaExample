package com.incb.store_content_manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incb.store_content_manager.model.Product;
import com.incb.store_content_manager.service.ProductFetchService;
import com.incb.store_content_manager.service.ProductUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class StoreContentManagerController {

    private ObjectMapper objectMapper;
    private ProductFetchService productFetchService;
    private ProductUpdateService productUpdateService;

    @Autowired
    public StoreContentManagerController(ObjectMapper objectMapper, ProductFetchService productFetchService, ProductUpdateService productUpdateService) {
        this.objectMapper = objectMapper;
        this.productFetchService = productFetchService;
        this.productUpdateService = productUpdateService;
    }

    @GetMapping("/test")
    public void test() {
        log.info("store-content-manager-service");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product<?>>> findAllProducts() {
        return new ResponseEntity<>(productFetchService.fetchAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product<?>> findProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productFetchService.fetchProduct(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        productUpdateService.saveListOfProducts(products);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

}
