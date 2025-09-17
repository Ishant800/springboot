package com.example.demo.repository;

import com.example.demo.DTO.ProductCategory;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.Entities.Product;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ProductRepo{

private final JdbcTemplate jdbcTemplate;
    public ProductRepo(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
      }

    public int addProduct(ProductDTO dto){
        String sql = "insert into product(product_name,product_desc,product_price,category_id,product_image) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                dto.getProductName(),
                dto.getProductDesc(),
                dto.getProductPrice(),
                dto.getCategoryId(),
                dto.getProductImage()
                );
    }

    public Product findProduct(Integer productId){
        String sql = "SELECT * FROM product WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
            Product p = new Product();
            p.setProductName(rs.getString("product_name"));
            p.setProductDesc(rs.getString("product_desc"));
            p.setProductPrice(rs.getInt("product_price"));
            p.setStock(rs.getInt("stock"));
            p.setProductImage(rs.getString("product_image")); return p;

                },productId);
    }
}
