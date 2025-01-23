package com.hiberus.inditex.infraestructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BRAND")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity {
    @Id
    private Integer id;

    private String label;
}
