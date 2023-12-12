package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuotationDto {

    private Long quoteId;
    private String product_name;
    private String product_model;
    private String company_name;
}
