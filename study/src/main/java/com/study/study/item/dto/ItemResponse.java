package com.study.study.item.dto;

import com.study.study.item.domain.Item;
import lombok.Getter;

@Getter
public class ItemResponse {

    private final String itemName;
    private final int price;
    private final int quantity;

    public ItemResponse(Item item) {
        this.itemName = item.getItemName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
    }
}
