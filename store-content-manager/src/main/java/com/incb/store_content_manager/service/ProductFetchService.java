package com.incb.store_content_manager.service;

import com.incb.store_content_manager.model.Product;

import java.util.List;

public interface ProductFetchService {
    List<Product<?>> fetchAllProducts();
    Product<?> fetchProduct(Integer productId);
}
