package com.dobudobu.ecommerce.Controller;

import com.dobudobu.ecommerce.Entity.User;
import com.dobudobu.ecommerce.Model.JwtResponse;
import com.dobudobu.ecommerce.Model.LoginRequest;
import com.dobudobu.ecommerce.Model.Role;
import com.dobudobu.ecommerce.Model.SignUpRequest;
import com.dobudobu.ecommerce.Security.Jwt.JwtUtils;
import com.dobudobu.ecommerce.Security.Service.UserDetailImpl;
import com.dobudobu.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticatedUser(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        UserDetailImpl principal = (UserDetailImpl) authentication.getPrincipal();
        return ResponseEntity.ok().body(new JwtResponse(token, principal.getEmail()));
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setRoles(Role.USER);
        User created = userService.create(user);
        return created;
    }

}
