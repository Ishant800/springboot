package com.example.demo.controller;

import com.example.demo.DTO.ProductCategory;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.Entities.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

//    public String addProduct(@RequestBody ProductDTO productDTO){
//       int rows =  productService.addProduct(productDTO);
//       if(rows > 0) return "insert sucessfull";
//       else
//        return "insert failed";
//    }

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@ModelAttribute ProductDTO productDTO,@RequestParam("file") MultipartFile file){

        try{
            String message = productService.addproduct(productDTO,file);
            return ResponseEntity.ok(Map.of("message ",message));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
        }
        catch(Exception e ){
            return ResponseEntity.status(500).body(Map.of("error",e.getMessage()));
        }
    }

    @PutMapping("/updateproduct/{productId}")
    public String updateproduct(@RequestBody ProductDTO productDTO,@PathVariable Integer productId){
       int rows = productService.updateProduct(productDTO,productId);
         return rows > 0 ? "product updated sucessfully ": " failed to update product";
    }

    @DeleteMapping("deleteproduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId){
       int rows = productService.deleteProduct(productId);
        return rows > 0 ? "product delete sucessfully " : "failed to delete products";
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllproducts();
    }


    @GetMapping("/getall")
    public List<ProductCategory> getProductWithCategory(){
        return productService.getProductsWithCategory();
    }

    @GetMapping("/{productId}")
    public Product getProductwithId(@PathVariable Integer productId){
        return productService.getProductWithId(productId);
    }

}
