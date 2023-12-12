package com.example.backend.controller;

import com.example.backend.dto.QuotationDto;
import com.example.backend.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("/create")
    public ResponseEntity<QuotationDto> createQuotation(@RequestBody QuotationDto quotationDTO) {
        QuotationDto createdQuotation = quotationService.createQuotation(quotationDTO);
        return ResponseEntity.ok(createdQuotation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuotationDto>> getAllQuotations() {
        List<QuotationDto> quotations = quotationService.getAllQuotations();
        return ResponseEntity.ok(quotations);
    }

    @DeleteMapping("/{quoteId}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long quoteId) {
        quotationService.deleteQuotation(quoteId);
        return ResponseEntity.noContent().build();
    }
}