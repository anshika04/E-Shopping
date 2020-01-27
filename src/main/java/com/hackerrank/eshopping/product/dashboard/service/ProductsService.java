package com.hackerrank.eshopping.product.dashboard.service;

import com.hackerrank.eshopping.product.dashboard.exception.RecordBadRequestException;
import com.hackerrank.eshopping.product.dashboard.exception.RecordNotFoundException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    // creates new product if already not present.
    public Product createProduct(Product entity) throws RecordBadRequestException {

        boolean exists = entity.getId() == null ? false : (productsRepository.existsById(entity.getId()));

        if (exists) {

            throw new RecordBadRequestException("Product Already Exists for given id.");
        } else {

            entity = productsRepository.save(entity);
            return entity;
        }

    }

    // updates the property details of the product record if present
    public Product updateProduct(Long product_id, Product entity) throws RecordBadRequestException {

        boolean exists = productsRepository.existsById(product_id);

        if (exists) {

            Optional<Product> product = productsRepository.findById(product_id);

            Product newEntity = product.get();

            String name = entity.getName() == null ? newEntity.getName() : entity.getName();
            String cat = entity.getCategory() == null ? newEntity.getCategory() : entity.getCategory();
            BigDecimal rp = entity.getRetailPrice() == null ? newEntity.getRetailPrice() : entity.getRetailPrice();
            BigDecimal dp = entity.getDiscountedPrice() == null ? newEntity.getDiscountedPrice() : entity.getDiscountedPrice();
            Boolean a = entity.getRetailPrice() == null ? newEntity.getAvailability() : entity.getAvailability();

            newEntity.setName(name);
            newEntity.setCategory(cat);
            newEntity.setRetailPrice(rp);
            newEntity.setDiscountedPrice(dp);
            newEntity.setAvailability(a);

            newEntity = productsRepository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordBadRequestException("Cannot Update : No product record exist for given id");
        }

    }

    // returns list of products of same category in defined sorted order
    public List<Product> getProductByCategory(String category) throws RecordNotFoundException {

        Sort sort = Sort.by("availability").descending()
                .and(Sort.by("discountedPrice").ascending())
                .and(Sort.by("id").ascending());


        List<Product> productList = productsRepository.findByCategory(category, sort);

        if (productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }

    // returns list of products of same category and specified availability in defined sorted order
    public List<Product> getProductByCategoryAndAvailability(String category, Boolean availability) throws RecordNotFoundException {

        Sort sort = Sort.by("discountPercentage").descending()
                .and(Sort.by("discountedPrice").ascending())
                .and(Sort.by("id").ascending());

        List<Product> productList = productsRepository.findByCategoryAndAvailability(category, availability, sort);

        if (productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }
}
