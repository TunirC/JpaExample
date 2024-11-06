package com.incb.store_content_manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "cart")
public class CartEntity {
    @Id
    private Integer id;
    private Integer userId;
    private String date;
    private List<CartProduct> products;
}
