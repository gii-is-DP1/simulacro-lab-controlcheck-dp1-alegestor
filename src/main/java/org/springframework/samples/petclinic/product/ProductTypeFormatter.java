package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    @Override
    public String print(ProductType object, Locale locale) {
        return null;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        return null;
    }
    
}
