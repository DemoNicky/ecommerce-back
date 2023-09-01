package com.dobudobu.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_basket")
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Product product;

    @JoinColumn
    @ManyToOne
    private User user;

    private String amount;

    private BigDecimal price;

    private BigDecimal total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
}
