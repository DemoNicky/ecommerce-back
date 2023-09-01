package com.dobudobu.ecommerce.Entity;

import com.dobudobu.ecommerce.Model.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_order")
@Data
public class Order {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "telp_num", length = 20, unique = true)
    private String telpNum;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column(name = "delivery_address", length = 200)
    private String deliveryAddress;

    @Column(name = "jumlah")
    private BigDecimal amount;

    @Column(name = "ongkos_kirim")
    private BigDecimal shippingCost;

    @Column(name = "total")
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
}
