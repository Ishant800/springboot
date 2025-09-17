package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseProdDto {
    private Long id;
    private String product_name;
    private String product_des;
    private Long price;

    public ResponseProdDto() {

    }
}
