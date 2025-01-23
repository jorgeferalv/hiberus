package com.hiberus.inditex.api.controller;

import com.hiberus.inditex.api.dto.PriceResponseDTO;
import com.hiberus.inditex.application.service.PriceAppService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class InditexController {

    private final PriceAppService priceAppService;

    public InditexController(PriceAppService priceAppService) {
        this.priceAppService = priceAppService;
    }

    @GetMapping("/price")
    @Operation(
            summary = "Precio final y tarifa a aplicar",
            description = "Refleja el precio final y la tarifa que aplica a un producto de una cadena para una fecha exacta",
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            description = "Precio y tarifa aplicada",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = """
                    {
                      "identificadorProducto": 184844,
                      "identificadorCadena": 54,
                      "tarifaAplicar": 5425,
                      "fechaInicio": "2020-06-14T15:00:00",
                      "fechafin": "2020-06-14T18:30:00",
                      "precioFinal": 5.50
                    }
                    """
                                    )
                            )
                    )
            }
    )
    public ResponseEntity<PriceResponseDTO> getPrice(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) {

        if (date == null || productId == null || brandId == null) {
            return ResponseEntity.badRequest().build();
        }

        PriceResponseDTO result = priceAppService.findPrice(date, productId, brandId);

        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.noContent().build();
    }
}
