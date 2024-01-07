package com.example.backend.repo;

import com.example.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findByQuotation_QuoteId(Long quoteId);
}
