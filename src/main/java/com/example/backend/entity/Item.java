package com.example.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemDecription")
    private String itemDecription;

    @Column(name = "itemPrice")
    private double itemPrice;

    @ManyToOne
    @JoinColumn(name = "quoteId")
    private Quotation quotation;
}
