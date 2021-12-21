package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    
    List<Product> findAll();
    
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    
    Product findByName(String name);
    
    Product save(Product p);
    
    @Query("SELECT ptype FROM product_types ptype WHERE ptype.name == name")
    ProductType getProductType(String name);

    @Query("SELECT ptype FROM product_types ptype WHERE ptype.price <price>")
    List<Product> getProductsCheaperThan(Double price);
}
