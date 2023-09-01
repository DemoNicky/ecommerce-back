package com.dobudobu.ecommerce.Security.Service;

import com.dobudobu.ecommerce.Entity.User;
import com.dobudobu.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()
        -> new UsernameNotFoundException("Email" + email + "Tidak di temukan"));
        return UserDetailImpl.build(user);
    }
}
