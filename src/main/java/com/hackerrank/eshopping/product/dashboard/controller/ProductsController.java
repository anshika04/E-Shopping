package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.exception.RecordNotFoundException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    ProductsService service;

    @GetMapping(value = "")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = service.getAllProducts();

        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long product_id)
            throws RecordNotFoundException {
        Product entity = service.getProductById(product_id);

        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
    }

}
