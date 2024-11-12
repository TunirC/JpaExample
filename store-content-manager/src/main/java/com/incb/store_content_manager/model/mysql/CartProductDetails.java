package com.incb.store_content_manager.model.mysql;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CartProductDetails {
    private Integer productId;
    private Integer quantity;
}
