package com.ptit.service;

import com.ptit.exception.ResourceNotFoundException;
import com.ptit.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public Item createItem(Item item) {
        item.setId(1L);
        return item;
    }

    public Item getItemById(Long id) {
        if (id < 0) {
            throw new ResourceNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }
        return new Item(id, "Sản phẩm mock");
    }
}
