package com.hiberus.inditex.infraestructure.repository.jpa;

import com.hiberus.inditex.infraestructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findByProductId(Integer productId);


    @Query("SELECT p FROM PriceEntity p WHERE :date " +
            "BETWEEN p.startDate and p.endDate and p.productId = :productId and p.brand.id = :brandId " +
            "AND p.priority = (SELECT MAX(p2.priority) FROM PriceEntity p2 " +
            "WHERE :date BETWEEN p2.startDate and p2.endDate " +
            "AND p2.productId = :productId AND p2.brand.id = :brandId)")
    Optional<PriceEntity> findApplicablePrice(
            @Param("date") LocalDateTime date,
            @Param("productId")Integer productId,
            @Param("brandId") Integer brandId);
}
