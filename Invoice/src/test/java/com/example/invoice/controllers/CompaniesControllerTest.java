package com.example.invoice.controllers;

import com.example.invoice.models.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CompaniesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void createCompany() throws Exception {
        Company company= new Company();
        company.setName("Coca-Cola");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/companies/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(company)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCompany() throws Exception {
        Company company= new Company();
        company.setName("Coca-Cola");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/companies/3")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(company)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCompany() throws Exception {
        mockMvc.perform(delete("/api/v1/companies/3"))
                .andExpect(status().isAccepted());
    }

    @Test
    void getCompanyById() throws Exception {
        mockMvc.perform(get("/api/v1/companies/3"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getAllCompanies() throws Exception {
        mockMvc.perform(get("/api/v1/companies/all"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}