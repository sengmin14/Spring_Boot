package com.study.study.dto;

import com.study.study.domain.Item;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddItemRequest {

    private String itemName;
    private int price;
    private int quantity;

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .quantity(quantity).build();
    }
}
