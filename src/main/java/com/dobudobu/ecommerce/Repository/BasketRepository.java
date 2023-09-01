package com.dobudobu.ecommerce.Repository;

import com.dobudobu.ecommerce.Entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
