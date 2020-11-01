package com.example.unittesting.business;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    //Commented autowired to solve a bug in ItemBusinessServiceTest
    //@Autowired
    private ItemRepository repository;

    public ItemBusinessService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item retrieveHardcodedItem() {
        return new Item(2, "Backpack", 200, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();

        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }
}
