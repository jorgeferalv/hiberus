package com.hiberus.inditex.domain.port;

import com.hiberus.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceRepository {
    Price findApplicablePrice(LocalDateTime date, Integer productId, Integer brandId);

}
