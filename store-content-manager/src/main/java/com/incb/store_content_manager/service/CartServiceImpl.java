package com.incb.store_content_manager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incb.store_content_manager.client.StoreProductRequestClient;
import com.incb.store_content_manager.exception.EmptyCartException;
import com.incb.store_content_manager.model.Cart;
import com.incb.store_content_manager.model.CartEntity;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartFetchService, CartUpdateService {

    private StoreProductRequestClient storeProductRequestClient;
    private ObjectMapper objectMapper;
    private MongoService mongoService;

    @Autowired
    public CartServiceImpl(StoreProductRequestClient storeProductRequestClient, ObjectMapper objectMapper, MongoService mongoService) {
        this.storeProductRequestClient = storeProductRequestClient;
        this.objectMapper = objectMapper;
        this.mongoService = mongoService;
    }

    @Override
    public List<Cart> fetchCartPerUser(Integer id) {
        log.info("Fetching cart details for user id: {}", id);
        List<Cart> cartDetail = Optional.ofNullable(storeProductRequestClient.getCartById(id))
                .map(Arrays::asList)
                .orElseThrow(() -> new EmptyCartException("Cart is empty for user: "+id));

        return cartDetail;
    }

    @Override
    public void saveCart(Cart cart) {
        try {
            CartEntity cartEntity = objectMapper.convertValue(cart, CartEntity.class);
            mongoService.saveCartDetails(Collections.singletonList(cartEntity));
        } catch (RuntimeException e) {
            log.info("failed to save following cart details in database: {}", cart);
            log.error("err: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveListOfCarts(List<Cart> cartList) {
        try {
            List<CartEntity> cartEntityList = objectMapper.convertValue(cartList, new TypeReference<List<CartEntity>>() {});
            mongoService.saveCartDetails(cartEntityList);
        } catch (RuntimeException e) {
            log.info("failed to save following list of carts in database: {}", cartList);
            log.error("err: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
