package com.example.backend.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quotation")
@Getter
@Setter
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;

    @NotNull
    @Column(name = "product_name")
    private String product_name;

    @NotNull
    @Column(name = "product_model")
    private String product_model;

    @NotNull
    @Column(name = "company_name")
    private String company_name;

    @Column(name = "quotation_number", unique = true)
    private String quotationNumber;

    public String Quotation(){
        return quotationNumber;
    }
    public String getQuotationNumber(){
        return quotationNumber;
    }

    private String generateQuotationNumber(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0,10);
    }

}
