package com.dobudobu.ecommerce.Service;

import com.dobudobu.ecommerce.Entity.User;
import com.dobudobu.ecommerce.Exception.BadRequestException;
import com.dobudobu.ecommerce.Exception.ResourceNotFoundException;
import com.dobudobu.ecommerce.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public User findById(String id){
        return UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User With id :"+id+"Not Found"));
    }

    public List<User> findAll(){
        return UserRepository.findAll();
    }

    public User create(User User){
        Boolean user = UserRepository.findByEmail(User.getEmail()).isPresent();
        if (user){
            throw new BadRequestException(String.format("Email Sudah di gunakan"));
        }
        return UserRepository.save(User);
    }

    public User edit(User User){
        User ctg = UserRepository.findById(User.getId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        ctg.setName(User.getName());
        return UserRepository.save(ctg);
    }

    public void deletedById(String id){
        boolean ctg = UserRepository.findById(id).isPresent();
        if (ctg){
            UserRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("User Not Found");
        }
    }
}
