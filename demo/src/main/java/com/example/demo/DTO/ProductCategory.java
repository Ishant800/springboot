package com.example.demo.DTO;

public class ProductCategory {
    private Integer productId;
    private String productName;
    private String productDesc;
    private Integer productPrice;
    private String categoryName;
    private Integer categoryId;

    public ProductCategory(){}
    public ProductCategory(Integer productId,String productName,String productDesc,Integer productPrice,Integer categoryId,String categoryName){
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    //getters
    public Integer getProductId(){return productId;}
    public String getProductName(){return productName;}
    public String getProductDesc(){return productDesc;}
    public Integer getProductPrice(){return productPrice;}
    public Integer getCategoryId(){return categoryId;}
    public String getCategoryName(){return categoryName;}

    //setters
    public void setProductId(Integer productId){this.productId = productId;}
    public void setProductName(String productName){this.productName = productName;}
    public void setProductDesc(String productDesc){this.productDesc = productDesc;}
    public void setProductPrice(Integer productPrice){this.productPrice = productPrice;}
    public void setCategoryId(Integer categoryId){this.categoryId = categoryId;}
    public  void setCategoryName(String categoryName){this.categoryName = categoryName;}

}
