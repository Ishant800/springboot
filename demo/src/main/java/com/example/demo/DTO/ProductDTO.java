package com.example.demo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
    private Integer productId;
   @NotBlank(message ="Product name cannot be empty")
    private String productName;
   @NotBlank(message = "product descriopton cannot be empty")
    private String productDesc;
   @Min(value = 1,message = "price must be at least 1")
    private Integer productPrice;
    private Integer categoryId;
    private String productImage;
    private Integer stock;


    public ProductDTO(){}
    public ProductDTO(Integer productId,Integer stock,String productImage,String productName,String productDesc,Integer productPrice,Integer categoryId){
        this.productId = productId;
        this.productDesc = productDesc;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
        this.productImage = productImage;
        this.stock = stock;

    }
    public Integer getProductId(){return productId;}
    public String getProductName() { return productName; }
    public String getProductDesc() { return productDesc; }
    public Integer getProductPrice() { return productPrice; }
    public Integer getCategoryId() { return categoryId; }
   public String getProductImage(){return productImage;}
    public Integer getStock(){return stock;}
    // Setters

    public void setProductId(Integer productId) {this.productId=productId;}
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductDesc(String productDesc) { this.productDesc = productDesc; }
    public void setProductPrice(Integer productPrice) { this.productPrice = productPrice; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public void setProductImage(String productImage){this.productImage = productImage;}
    public void setStock(Integer stock){this.stock = stock;}
}
