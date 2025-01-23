package com.hiberus.inditex.infraestructure.mapper;

import com.hiberus.inditex.domain.model.Price;
import com.hiberus.inditex.infraestructure.repository.entity.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceMapper {

    @Mapping(source = "brand.id", target = "brandId")
    Price toDomain(PriceEntity entity);

    @InheritInverseConfiguration
    PriceEntity toEntity(Price price);
}
