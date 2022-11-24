package com.example.invoice.controllers;

import com.example.invoice.models.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class InvoicesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createInvoice() throws Exception {
        Invoice invoice = new Invoice();
        invoice.setDate("2020-01-01 12:33:30");
        invoice.setAmount(new BigDecimal("234.56"));
        invoice.setIndividId(41L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/invoices/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(invoice)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateInvoice()throws Exception {
        Invoice invoice = new Invoice();
        invoice.setDate("2020-01-01 12:33:30");
        invoice.setAmount(new BigDecimal("234.56"));
        invoice.setIndividId(41L);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/invoices/126")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(invoice)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteInvoice() throws Exception {
        mockMvc.perform(delete("/api/v1/invoices/126"))
                .andExpect(status().isAccepted());
    }

    @Test
    void getInvoiceById() throws Exception {
        mockMvc.perform(get("/api/v1/invoices/126"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getAllInvoices() throws Exception {
        mockMvc.perform(get("/api/v1/invoices/all"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}