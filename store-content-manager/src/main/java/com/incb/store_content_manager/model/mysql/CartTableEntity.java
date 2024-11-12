package com.incb.store_content_manager.model.mysql;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CartTableEntity {
    @Id
    private Integer id;
    private Integer userId;
    private String date;

    @ElementCollection
    private List<CartProductDetails> products;
}
