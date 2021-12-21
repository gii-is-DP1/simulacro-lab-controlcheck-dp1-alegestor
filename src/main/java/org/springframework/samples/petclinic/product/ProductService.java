package org.springframework.samples.petclinic.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.getProductsCheaperThan(price);
    }

    public ProductType getProductType(String typeName) {
        return this.productRepository.getProductType(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}
