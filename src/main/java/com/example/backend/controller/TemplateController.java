package com.example.backend.controller;

import com.example.backend.entity.Quotation;
import com.example.backend.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TemplateController {

    @Autowired
    private QuotationService quotationService;

    @GetMapping("/template/{quoteId}")
    public String generateUserHtml(@PathVariable Long quoteId, Model model) {
        Quotation quote = quotationService.getQuoteById(quoteId);
        model.addAttribute("quote", quote);
        return "quote-template";
    }
}
