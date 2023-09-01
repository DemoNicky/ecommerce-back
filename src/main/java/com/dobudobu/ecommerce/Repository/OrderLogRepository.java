package com.dobudobu.ecommerce.Repository;

import com.dobudobu.ecommerce.Entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {
}
