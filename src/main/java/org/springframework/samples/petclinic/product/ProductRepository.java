package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    
    List<Product> findAll();

    @Query("SELECT ptype FROM ProductType ptype")
    List<ProductType> findAllProductTypes() throws DataAccessException;
    
    Optional<Product> findById(int id);

    Product findByName(String name);

    @Query("SELECT prodtype FROM ProductType prodtype WHERE prodtype.name = :name")
    ProductType findProductTypeByName(@Param("name") String name) throws DataAccessException;

    Product save(Product p);

    @Query("SELECT p FROM Product p WHERE p.price <= :price")
    List<Product> findByPriceLessThan(@Param("price") Double price) throws DataAccessException;
}
