package com.example.backend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
public class QuotationDto {


    private Long quoteId;

    private String customer_name;

    private String contact_number;

    private String email;

    private String description;

    private String quotationNumber;

    private LocalDate quote_date;
}
