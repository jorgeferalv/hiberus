package com.hiberus.inditex.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class InditexControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void integrationTest1GetPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(35.5));
    }

    @Test
    void integrationTest2GetPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2020-06-14T15:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2020-06-14T18:30:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(25.45));
    }

    @Test
    void integrationTest3GetPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(35.5));
    }

    @Test
    void integrationTest4GetPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2020-06-15T11:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(30.5));
    }

    @Test
    void integrationTest5GetPrice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2020-06-15T16:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(38.95));
    }
}
