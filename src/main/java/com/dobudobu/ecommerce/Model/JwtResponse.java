package com.dobudobu.ecommerce.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private String token;
    private String type = "Bearer";
    private String email;

    public JwtResponse(
            String AccessToken,
            String email){
        this.token = AccessToken;
        this.email = email;
    }

}
