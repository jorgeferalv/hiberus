package com.hiberus.inditex.infraestructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private Integer priceList;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brand;

    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "product_id")
    private Integer productId;
    private Integer priority;
    private Double price;
    @Column(name = "curr")
    private String currency;
}
