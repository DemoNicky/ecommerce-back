package com.dobudobu.ecommerce.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignUpRequest implements Serializable {

    private String email;

    private String password;

    private String name;
}
