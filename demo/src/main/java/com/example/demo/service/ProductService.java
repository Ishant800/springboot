package com.example.demo.service;

import com.example.demo.DTO.ProductCategory;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.Entities.Product;
import com.example.demo.Utility.FileUploadUtil;
import com.example.demo.repository.ProductRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRepo productRepo;
    public ProductService(JdbcTemplate jdbcTemplate,ProductRepo productRepo){

        this.jdbcTemplate = jdbcTemplate;
        this.productRepo =productRepo;
    }

    public int updateProduct(ProductDTO dto,Integer productId){
        String sql = "update product set product_name = ?,product_desc = ?, product_price = ? where product_id = ?";
        return jdbcTemplate.update(sql,dto.getProductName(),dto.getProductDesc(),dto.getProductPrice(),productId);
    }


    public String addproduct(ProductDTO productDTO, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("file cannot be empty");
        }

        String savedFile = FileUploadUtil.saveFile(file);

        // Save only relative path or filename to DB (not full path)
        productDTO.setProductImage(savedFile);

        // Business logics
        int rows = productRepo.addProduct(productDTO);
        return rows > 0 ? "product add successfully" : "failed to add product";
    }



    public int deleteProduct(int productId){
        String sql = "DELETE FROM product WHERE product_id = ?";
        return jdbcTemplate.update(sql,productId);
    }

    public List<ProductDTO> getAllproducts(){
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            ProductDTO dto = new ProductDTO();
            dto.setProductId(rs.getInt("product_id"));
            dto.setProductName(rs.getString("product_name"));
            dto.setProductDesc(rs.getString("product_desc"));
            dto.setProductPrice(rs.getInt("product_price"));
            dto.setCategoryId(rs.getInt("category_id"));
            return dto;
        } );
    }

    public List<ProductCategory> getProductsWithCategory(){
        String sql = "SELECT p.product_id,p.product_name,product_desc,p.product_price ," +
                "c.category_name,c.category_id" + " FROM product p " + "INNER JOIN category c ON p.category_id = c.category_id";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            ProductCategory dto = new ProductCategory();
            dto.setCategoryId(rs.getInt("category_id"));
            dto.setProductId(rs.getInt("product_id"));
            dto.setProductName(rs.getString("product_name"));
            dto.setProductDesc(rs.getString("product_desc"));
            dto.setProductPrice(rs.getInt("product_price"));
            dto.setCategoryName(rs.getString("category_name"));
            return dto;
        });
    }

    public Product getProductWithId(Integer productId){
        return productRepo.findProduct(productId);
    }
//    public int updateProduct(int i)
}
//
