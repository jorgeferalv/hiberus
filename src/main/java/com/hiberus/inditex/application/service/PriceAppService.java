package com.hiberus.inditex.application.service;

import com.hiberus.inditex.api.dto.PriceResponseDTO;
import com.hiberus.inditex.domain.model.Price;
import com.hiberus.inditex.domain.port.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceAppService {

    private final PriceService priceService;

    public PriceAppService(PriceService priceService) {
        this.priceService = priceService;
    }

    public PriceResponseDTO findPrice(LocalDateTime date, Integer productId, Integer brandId) {
        Price price = priceService.getPrice(date, productId, brandId);

        return new PriceResponseDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }

}
