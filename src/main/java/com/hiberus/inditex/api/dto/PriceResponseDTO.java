package com.hiberus.inditex.api.dto;

import java.time.LocalDateTime;

public record PriceResponseDTO(
        Integer identificadorProducto,
        Integer identificadorCadena,
        Integer tarifaAplicar,
        LocalDateTime fechaInicio,
        LocalDateTime fechafin,
        Double precioFinal) {}
