package com.dobudobu.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_product")
@Data
public class Product implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "product_name", length = 50)
    private String productName;

    @Column(name = "product_desc")
    private String deskripsi;

    private String image;

    @JoinColumn
    @ManyToOne
    private Category category;

    @Column(name = "product_price")
    private BigDecimal price;

    private Double stock;
}
