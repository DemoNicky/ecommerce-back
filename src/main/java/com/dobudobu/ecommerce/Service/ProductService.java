package com.dobudobu.ecommerce.Service;

import com.dobudobu.ecommerce.Entity.Category;
import com.dobudobu.ecommerce.Entity.Product;
import com.dobudobu.ecommerce.Exception.ResourceNotFoundException;
import com.dobudobu.ecommerce.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(String  id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category With id :"+id+"Not Found"));
    }

    public Product create(Product product){
        Category category = categoryService.findById(product.getCategory().getId());
        if (category.equals(null)){
            throw new ResourceNotFoundException(String.format("category not found"));
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product edit(Product product){
        Product prd = productRepository.findById(product.getId()).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        prd.setProductName(product.getProductName());
        prd.setDeskripsi(product.getDeskripsi());
        prd.setImage(product.getImage());
        prd.setCategory(product.getCategory());
        prd.setPrice(product.getPrice());
        prd.setStock(product.getStock());
        return productRepository.save(prd);
    }

    public Product changeImage(String id, String image){
        Product product = findById(id);
        product.setImage(image);
        return productRepository.save(product);
    }

    public void deletedById(String id){
        productRepository.deleteById(id);
    }
}
