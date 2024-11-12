package com.incb.store_content_manager.model.mysql;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductTableEntity {
    @Id
    private Integer id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;

    @OneToOne(mappedBy = "productTableEntity", cascade = CascadeType.ALL)
    private ProductRating rating;
}
