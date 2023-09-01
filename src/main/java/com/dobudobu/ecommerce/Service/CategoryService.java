package com.dobudobu.ecommerce.Service;

import com.dobudobu.ecommerce.Entity.Category;
import com.dobudobu.ecommerce.Exception.ResourceNotFoundException;
import com.dobudobu.ecommerce.Repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(String id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category With id :"+id+"Not Found"));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public Category edit(Category category){
        Category ctg = categoryRepository.findById(category.getId()).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        ctg.setName(category.getName());
        return categoryRepository.save(ctg);
    }

    public void deletedById(String id){
        boolean ctg = categoryRepository.findById(id).isPresent();
        if (ctg){
            categoryRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Category Not Found");
        }
    }
}
