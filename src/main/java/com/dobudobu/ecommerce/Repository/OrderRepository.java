package com.dobudobu.ecommerce.Repository;

import com.dobudobu.ecommerce.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
