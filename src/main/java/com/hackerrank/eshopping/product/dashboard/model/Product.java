package com.hackerrank.eshopping.product.dashboard.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Product")
@Table(name = "TBL_PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "retail_price", nullable = false)
    private BigDecimal retailPrice;

    @Column(name = "discounted_price", nullable = false)
    private BigDecimal discountedPrice;

    @Column(name = "availability", nullable = false)
    private Boolean availability;

    // calculates the discount percentage for each product
    @Formula("((retail_price - discounted_price) / retail_price) * 100")
    @JsonIgnore
    private int discountPercentage;

    public Product() {
    }

    @JsonCreator
    public Product(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("category") String category,
            @JsonProperty("retail_price") BigDecimal retailPrice,
            @JsonProperty("discounted_price") BigDecimal discountedPrice,
            @JsonProperty("availability") Boolean availability) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", retailPrice=" + retailPrice +
                ", discountedPrice=" + discountedPrice +
                ", availability=" + availability +
                '}';
    }
}
