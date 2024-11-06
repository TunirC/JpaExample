package com.incb.store_content_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product <T extends Number> {
    private Integer id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
    private Map<String, T> rating;
}
