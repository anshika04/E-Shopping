package com.hackerrank.eshopping.product.dashboard.service;

import com.hackerrank.eshopping.product.dashboard.exception.RecordNotFoundException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    // return list of all Products
    public List<Product> getAllProducts() {
        List<Product> productList = productsRepository.findAll(Sort.by("id").ascending());

        if (productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }

    // returns Product with specified Product Id
    public Product getProductById(Long id) throws RecordNotFoundException {
        Optional<Product> product = productsRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No product record exist for given id");
        }
    }
}
