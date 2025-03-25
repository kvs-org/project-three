package com.kvs.multiplication.controller;

import com.kvs.multiplication.service.MultiplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MultiplicationController.class)
class MultiplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MultiplicationService multiplicationService;

    @Test
    void testMultiplicationEndpoint() throws Exception {
        // Mock the service behavior
        when(multiplicationService.multiply(4, 5)).thenReturn(20);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/multiply")
                .param("a", "4")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("20"));
    }

    @Test
    void testMultiplicationWithZero() throws Exception {
        // Mock the service behavior
        when(multiplicationService.multiply(4, 0)).thenReturn(0);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/multiply")
                .param("a", "4")
                .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testMultiplicationWithNegativeNumbers() throws Exception {
        // Mock the service behavior
        when(multiplicationService.multiply(-4, 5)).thenReturn(-20);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/multiply")
                .param("a", "-4")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("-20"));
    }
}