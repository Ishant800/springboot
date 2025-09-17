package com.example.demo.Entities;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

   private String productName;
   private String productDesc;
   private Integer productPrice;
   private String productImage;
   private Integer stock;


   @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;


    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductDesc() { return productDesc; }
    public void setProductDesc(String productDesc) { this.productDesc = productDesc; }

    public Integer getProductPrice() { return productPrice; }
    public void setProductPrice(Integer productPrice) { this.productPrice = productPrice; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getProductImage() {
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getStock(){return stock;}
    public void setStock(Integer stock){this.stock = stock;}


}
