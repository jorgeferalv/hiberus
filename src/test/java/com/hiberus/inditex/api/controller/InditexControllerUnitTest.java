package com.hiberus.inditex.api.controller;

import com.hiberus.inditex.api.dto.PriceResponseDTO;
import com.hiberus.inditex.application.service.PriceAppService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@WebMvcTest(InditexController.class)
class InditexControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PriceAppService priceAppService;

    @Test
    void testWithMockito() throws Exception {
        PriceResponseDTO mockedResponse =
                new PriceResponseDTO(
                        35455,
                        1,
                        1,
                        LocalDateTime.parse("2025-01-22T00:00:00"),
                        LocalDateTime.parse("2025-01-22T23:59:59"),
                        50.5);

        Mockito.when(priceAppService.findPrice(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(mockedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/price")
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorProducto").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificadorCadena").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tarifaAplicar").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechaInicio").value("2025-01-22T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fechafin").value("2025-01-22T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").value(50.5));
    }
}

