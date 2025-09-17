package com.example.demo.DTO;

public class PaymentDto {
private Long orderId;
private double amount;
private String status;

public PaymentDto(Long orderId,double amount,String status){
    this.orderId = orderId;
    this.amount = amount;
    this.status = status;
}

public PaymentDto(){}

    public Long getOrderId(){return orderId;}
    public double getAmount(){return amount;}
    public String getStatus(){return status;}

    public void setOrderId(Long orderId){this.orderId = orderId;}
    public void setAmount(double amount){this.amount = amount;}
    public void setStatus(String status){this.status = status;}
}
