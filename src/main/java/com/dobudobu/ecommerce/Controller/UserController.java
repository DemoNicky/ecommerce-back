package com.dobudobu.ecommerce.Controller;

import com.dobudobu.ecommerce.Entity.User;
import com.dobudobu.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService UserService;

    @GetMapping("/user")
    public List<User> findAll(){
        return UserService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id")String id){
        return UserService.findById(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User User){
        return UserService.create(User);
    }

    @PutMapping("/user")
    public User edit(@RequestBody User User){
        return UserService.edit(User);
    }

    @DeleteMapping("/user/{id}")
    public void deletedById(@PathVariable("id")String id){
        UserService.deletedById(id);
    }
}
