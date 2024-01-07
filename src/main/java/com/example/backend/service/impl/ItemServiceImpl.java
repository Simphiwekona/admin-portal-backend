package com.example.backend.service.impl;

import com.example.backend.entity.Item;
import com.example.backend.entity.Quotation;
import com.example.backend.repo.ItemRepo;
import com.example.backend.repo.QuotationRepo;
import com.example.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private QuotationRepo quotationRepo;

    @Override
    public Item addItem(Long quoteId, Item item) {
        Quotation quotation = quotationRepo.findByQuoteId(quoteId)
                .orElseThrow(() -> new RuntimeException("Quotation not found with id: " + quoteId));

        item.setQuotation(quotation);
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getItemsByQuoteId(Long quoteId) {
        return itemRepo.findByQuotation_QuoteId(quoteId);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepo.deleteById(itemId);
    }
}

