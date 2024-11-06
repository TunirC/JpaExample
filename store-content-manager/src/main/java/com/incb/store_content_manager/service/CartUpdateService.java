package com.incb.store_content_manager.service;

import com.incb.store_content_manager.model.Cart;
import com.incb.store_content_manager.model.Product;

import java.util.List;

public interface CartUpdateService {
    void saveCart(Cart cart);
    void saveListOfCarts(List<Cart> cartList);
}
