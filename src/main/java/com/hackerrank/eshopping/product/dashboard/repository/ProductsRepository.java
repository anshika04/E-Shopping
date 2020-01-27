package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.category = ?1", nativeQuery = false)
    List<Product> findByCategory(@Param("category") String category, Sort sort);

    @Query(value = "SELECT p FROM Product p WHERE p.category = ?1 and p.availability = ?2", nativeQuery = false)
    List<Product> findByCategoryAndAvailability(@Param("category") String category, @Param("availability") Boolean availability, Sort sort);

}
