package com.incb.store_content_manager.service;

import com.incb.store_content_manager.model.Product;

import java.util.List;

public interface ProductUpdateService {
    void saveProduct(Product<?> product);
    void saveListOfProducts(List<Product> product);
}
