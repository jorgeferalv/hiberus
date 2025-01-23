package com.hiberus.inditex.domain.port;

import com.hiberus.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price getPrice(LocalDateTime date, Integer productId, Integer brandId);
}
