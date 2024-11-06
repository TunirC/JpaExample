package com.incb.store_content_manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "product")
public class ProductEntity <T extends Number> {
    @Id
    private Integer id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
    private Map<String, T> rating;
}
