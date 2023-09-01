package com.dobudobu.ecommerce.Controller;


import com.dobudobu.ecommerce.Entity.Product;
import com.dobudobu.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping("/product")
    public List<Product> findAll(){
        return ProductService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable("id")String id){
        return ProductService.findById(id);
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product Product){
        return ProductService.create(Product);
    }

    @PutMapping("/product")
    public Product edit(@RequestBody Product Product){
        return ProductService.edit(Product);
    }

    @DeleteMapping("/product/{id}")
    public void deletedById(@PathVariable("id")String id){
        ProductService.deletedById(id);
    }
}
