package com.example.backend.controller;

import com.example.backend.entity.Item;
import com.example.backend.repo.ItemRepo;
import com.example.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin("http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@PathVariable Long quoteId ,@RequestBody  Item item){
        Item newItem = itemService.addItem(quoteId, item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/{quoteId}")
    public ResponseEntity<List<Item>> getItemsByQuoteId(@PathVariable Long quoteId){
        List<Item> items = itemService.getItemsByQuoteId(quoteId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
