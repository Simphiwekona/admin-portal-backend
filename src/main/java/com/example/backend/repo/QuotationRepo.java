package com.example.backend.repo;

import com.example.backend.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuotationRepo extends JpaRepository<Quotation, Long> {

    List<Quotation> findAll();

    Optional<Quotation> findByQuoteId(Long quoteId);
}
