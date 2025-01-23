package com.hiberus.inditex.domain.service;

import com.hiberus.inditex.domain.model.Price;
import com.hiberus.inditex.domain.port.PriceRepository;
import com.hiberus.inditex.domain.port.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceDomainService implements PriceService {
    private final PriceRepository priceRepository;

    public PriceDomainService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPrice(LocalDateTime date, Integer productId, Integer brandId) {
        return priceRepository.findApplicablePrice(date, productId, brandId);
    }

}
