package com.example.invoice.controllers;

import com.example.invoice.models.Individual;
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
class IndividualControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createIndividual() throws Exception {
        Individual individual= new Individual();
        individual.setCompanyId(3L);
        individual.setType("legal");
        individual.setName("Ivan Ivanov");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/individuals/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(individual)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateIndividual() throws Exception {
        Individual individual= new Individual();
        individual.setCompanyId(3L);
        individual.setType("legal");
        individual.setName("Ivan Ivanov");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/individuals/41")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(individual)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteIndividual() throws Exception {
        mockMvc.perform(delete("/api/v1/individuals/41"))
                .andExpect(status().isAccepted());
    }

    @Test
    void getIndividualById() throws Exception {
        mockMvc.perform(get("/api/v1/individuals/41"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void getAllIndividuals() throws Exception {
        mockMvc.perform(get("/api/v1/individuals/all"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}