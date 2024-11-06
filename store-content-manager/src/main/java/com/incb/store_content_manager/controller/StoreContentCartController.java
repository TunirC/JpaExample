package com.incb.store_content_manager.controller;

import com.incb.store_content_manager.model.Cart;
import com.incb.store_content_manager.service.CartFetchService;
import com.incb.store_content_manager.service.CartUpdateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart")
public class StoreContentCartController {

    private CartFetchService cartFetchService;
    private CartUpdateService cartUpdateService;

    @Autowired
    public StoreContentCartController(CartFetchService cartFetchService, CartUpdateService cartUpdateService) {
        this.cartFetchService = cartFetchService;
        this.cartUpdateService = cartUpdateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Cart>> findUserCartDetails(@PathVariable Integer id) {
        return new ResponseEntity<>(cartFetchService.fetchCartPerUser(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Cart>> addCartDetails(@RequestBody List<Cart> carts) {
        cartUpdateService.saveListOfCarts(carts);
        return new ResponseEntity<>(carts, HttpStatus.CREATED);
    }

}
