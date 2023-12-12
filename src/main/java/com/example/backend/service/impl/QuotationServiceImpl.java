package com.example.backend.service.impl;

import com.example.backend.dto.QuotationDto;
import com.example.backend.entity.Quotation;
import com.example.backend.repo.QuotationRepo;
import com.example.backend.service.QuotationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationRepo quotationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuotationDto createQuotation(QuotationDto quotationDTO) {
        Quotation quotation = modelMapper.map(quotationDTO, Quotation.class);
        quotation.setQuotationNumber(generateQuotationNumber());
        quotation = quotationRepo.save(quotation);
        return modelMapper.map(quotation, QuotationDto.class);
    }

    @Override
    public List<QuotationDto> getAllQuotations() {
        List<Quotation> quotations = quotationRepo.findAll();
        return quotations.stream()
                .map(quotation -> modelMapper.map(quotation, QuotationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuotation(Long quoteId) {
        quotationRepo.deleteById(quoteId);
    }

    private String generateQuotationNumber() {
        // Generate a UUID and transform it into a 10-digit number
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 10);
    }
}
