package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }    

    public List<Product> getAllProducts(){
        return  this.productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findProductsCheaperThan(price);
    }

    public ProductType getProductType(String typeName) {
        return this.productRepository.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    public List<ProductType> getAllProductTypes(){
        return  this.productRepository.findAllProductTypes();
    }

}
