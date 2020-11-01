package com.example.unittesting.business;

import com.example.unittesting.model.Item;

public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
