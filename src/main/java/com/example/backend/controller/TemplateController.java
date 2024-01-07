package com.example.backend.controller;

import com.example.backend.entity.Quotation;
import com.example.backend.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Controller
@CrossOrigin("http://localhost:3000")
public class TemplateController {

    @Autowired
    private QuotationService quotationService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/template/{quoteId}")
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long quoteId, Model model) throws Exception {
        Quotation quote = quotationService.getQuoteById(quoteId);

        String customerName = quote.getCustomer_name();
        String quotationNumber = quote.getQuotationNumber();

        // Create Thymeleaf context and set model attributes
        Context thymeleafContext = new Context();
        thymeleafContext.setVariable("quote", quote);

        // Render HTML template to a String
        String htmlContent = templateEngine.process("quote-template", thymeleafContext);

        // Generate PDF from HTML
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(pdfOutputStream);

        // Set response headers
        String filename = String.format("%s_%s.pdf", customerName, quotationNumber);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", filename);

        return new ResponseEntity<>(pdfOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}
