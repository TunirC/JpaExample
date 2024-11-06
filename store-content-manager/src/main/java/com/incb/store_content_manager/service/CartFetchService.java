package com.incb.store_content_manager.service;

import com.incb.store_content_manager.model.Cart;

import java.util.List;

public interface CartFetchService {
    List<Cart> fetchCartPerUser(Integer id);
}
