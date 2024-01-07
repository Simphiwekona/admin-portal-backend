package com.example.backend.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
    @Column(name = "customer_name")
    private String customer_name;

    @NotNull
    @Column(name = "contact_number")
    private String contact_number;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "quotation_number", unique = true)
    private String quotationNumber;

    @Column(name = "quote_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate quote_date;

    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL)
    private List<Item> items;

    public  Quotation(){
        this.quotationNumber = generateQuotationNumber();
        this.quote_date = LocalDate.now();
    }
    public String getQuotationNumber(){
        return quotationNumber;
    }

    public LocalDate getQuoteDate(){
        return quote_date;
    }

    private String generateQuotationNumber(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0,10);
    }

}
