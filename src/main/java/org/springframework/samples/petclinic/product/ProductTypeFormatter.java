package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import aj.org.objectweb.asm.Type;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    @Autowired
    private ProductService productService;

    @Override
    public String print(ProductType object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        Collection<ProductType> findProductTypes = this.productService.getAllProductTypes();
        for(ProductType pType:findProductTypes){
            if(pType.getName().equals(text)) return pType;
        }
        throw new ParseException("type not found " + text, 0);
    }
    
}
