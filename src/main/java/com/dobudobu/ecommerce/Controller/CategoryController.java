package com.dobudobu.ecommerce.Controller;

import com.dobudobu.ecommerce.Entity.Category;
import com.dobudobu.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category findById(@PathVariable("id")String id){
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("/category")
    public Category edit(@RequestBody Category category){
        return categoryService.edit(category);
    }

    @DeleteMapping("/category/{id}")
    public void deletedById(@PathVariable("id")String id){
        categoryService.deletedById(id);
    }
}
