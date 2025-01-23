package com.hiberus.inditex.infraestructure.repository.adapter;


import com.hiberus.inditex.domain.model.Price;
import com.hiberus.inditex.domain.port.PriceRepository;
import com.hiberus.inditex.infraestructure.repository.jpa.SpringDataPriceRepository;
import com.hiberus.inditex.infraestructure.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PriceJpaRepository implements PriceRepository {

    private final SpringDataPriceRepository repository;
    private final PriceMapper mapper;

    public PriceJpaRepository(SpringDataPriceRepository repository, PriceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Price findApplicablePrice(LocalDateTime date, Integer productId, Integer brandId) {
        return repository.findApplicablePrice(date, productId, brandId)
                .map(mapper::toDomain)
                .orElse(null);
    }

}
