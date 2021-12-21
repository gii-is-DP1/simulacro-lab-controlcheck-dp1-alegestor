package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductTypeFormatter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        Collection<Product> productTypes = this.productService.getAllProducts();
        for(Product p:productTypes) {
            if(p.productType.toString().equals(text)) return p.getProductType();
        }
        throw new ParseException("Type not found" + text, 0);
    }
    
}
