package com.example.invoice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void personsByComp() throws Exception {
        mockMvc.perform(get("/api/v1/applications/3"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void personsByCompThrows() throws Exception {
        mockMvc.perform(get("/api/v1/applications/-3"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void searchByPerson() throws Exception {
        mockMvc.perform(get("/api/v1/applications/person/41"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void searchByPersonThrows() throws Exception {
        mockMvc.perform(get("/api/v1/applications/person/-41"))
                .andExpect(status().is4xxClientError());
    }


    @Test
    void orderBy() throws Exception {
        mockMvc.perform(get("/api/v1/applications/3/sort/?param=amount"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void orderByDate() throws Exception {
        mockMvc.perform(get("/api/v1/applications/3/sort/?param=dates"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void orderByRef() throws Exception {
        mockMvc.perform(get("/api/v1/applications/3/sort/?param=ref"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void searchBy() throws Exception {
        mockMvc.perform(get("/api/v1/applications/3/search/?param=ref&value=3051"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}