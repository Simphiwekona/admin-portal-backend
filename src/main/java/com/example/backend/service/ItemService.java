package com.example.backend.service;

import com.example.backend.entity.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Long quoteId, Item item);
    List<Item> getItemsByQuoteId(Long quoteId);
    void deleteItem(Long itemId);
}

