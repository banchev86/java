package com.example.invoice.controllers;

import com.example.invoice.dto.ReferenceRequestUpdate;
import com.example.invoice.models.Reference;
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
class ReferencesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createReference() throws Exception {
        Reference reference = new Reference();
        reference.setIndividId(41L);
        reference.setRef(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void createReferenceThrow() throws Exception {
        Reference reference = new Reference();
        reference.setIndividId(-41L);
        reference.setRef(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    void createReferenceThrowRefId() throws Exception {
        Reference reference = new Reference();
        reference.setIndividId(-41L);
        reference.setRef(-1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    void updateReference() throws Exception {
        ReferenceRequestUpdate reference=new ReferenceRequestUpdate();
        reference.setIndividId("41");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/3051")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void updateReferenceThrows() throws Exception {
        ReferenceRequestUpdate reference=new ReferenceRequestUpdate();
        reference.setIndividId("4-1");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/3051")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    void updateReferenceThrowsId() throws Exception {
        ReferenceRequestUpdate reference=new ReferenceRequestUpdate();
        reference.setIndividId("41");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/referencies/32-34")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(reference)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void deleteReference() throws Exception {

        mockMvc.perform(delete("/api/v1/referencies/3051"))
                .andExpect(status().isAccepted());
    }

    @Test
    void referenceById() throws Exception {

        mockMvc.perform(get("/api/v1/referencies/3051"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    @Test
    void referenceByIdThrowsId() throws Exception {

        mockMvc.perform(get("/api/v1/referencies/32-34"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getAllCompanies() throws Exception {
        mockMvc.perform(get("/api/v1/referencies/all"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}