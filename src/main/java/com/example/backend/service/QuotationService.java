package com.example.backend.service;

import com.example.backend.dto.QuotationDto;

import java.util.List;

public interface QuotationService {
    QuotationDto createQuotation(QuotationDto quotationDTO);

    List<QuotationDto> getAllQuotations();

    void deleteQuotation(Long quoteId);
}
