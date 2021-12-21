package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    Integer id;
    
    @NotNull
    @Length(min=3, max=50)
    String name;

    @NotNull
    @Min(value = 0l)
    double price;

    @ManyToOne
    @JoinColumn(name="product_type")
    ProductType productType;
}
