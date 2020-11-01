package com.example.unittesting.business;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemBusinessServiceTest {

    //Removed @Mock and @InjectMocks due to a NullPointerException when calling findAll in test
    private ItemRepository repository;
    private ItemBusinessService business;

    @Test
    public void retrieveAllItems_basic() {
        repository = mock(ItemRepository.class);
        business = new ItemBusinessService(repository);
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(3, "Item2", 10, 10),
                        new Item(4, "Item4", 20, 20)
                ));

        List<Item> items = business.retrieveAllItems();

        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}