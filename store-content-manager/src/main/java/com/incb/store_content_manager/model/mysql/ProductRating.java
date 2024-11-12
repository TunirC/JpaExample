package com.incb.store_content_manager.model.mysql;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double rate;
    private Integer count;

    @OneToOne
    @JoinColumn
    private ProductTableEntity productTableEntity;
}
