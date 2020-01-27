package com.hackerrank.eshopping.product.dashboard.controller;

import com.hackerrank.eshopping.product.dashboard.exception.RecordBadRequestException;
import com.hackerrank.eshopping.product.dashboard.exception.RecordNotFoundException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(headers = {"content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
            throws RecordBadRequestException {
        Product newProduct = service.createProduct(product);
        return new ResponseEntity<Product>(newProduct, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{product_id}", headers = {"content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("product_id") Long product_id)
            throws RecordBadRequestException {
        Product updatedProduct = service.updateProduct(product_id, product);
        return new ResponseEntity<Product>(updatedProduct, new HttpHeaders(), HttpStatus.OK);
    }

}
