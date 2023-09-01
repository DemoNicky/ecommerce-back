package com.dobudobu.ecommerce.Entity;

import com.dobudobu.ecommerce.Model.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "tbl_user")
@Data
public class User implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "telp_num", length = 20, unique = true)
    private String telpNum;

    @Enumerated(EnumType.STRING)
    private Role roles;

    private Boolean active = Boolean.TRUE;
}
