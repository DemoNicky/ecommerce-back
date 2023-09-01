package com.dobudobu.ecommerce.Repository;

import com.dobudobu.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
