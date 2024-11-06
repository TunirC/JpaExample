package com.incb.store_content_manager.client;

import com.incb.store_content_manager.model.Cart;
import com.incb.store_content_manager.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "storeProductRequestClient", url = "${fake-store.uri}")
public interface StoreProductRequestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product<?>> getAllProducts();

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    Product<?> getProductById(@PathVariable("id") Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{id}")
    Cart getCartById(@PathVariable("id") Integer id);
}
