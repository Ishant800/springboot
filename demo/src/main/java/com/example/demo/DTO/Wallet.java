package com.example.demo.DTO;

public class Wallet {
    private Long id;
    private Long userId;
    private Double balance;

    public Wallet(){}
    public Wallet(Long id,Long userId,Double balance){
        this.id = id;
        this.userId = id;
        this.balance = balance;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId = userId;}

    public Double getBalance(){return balance;}
    public void setBalance(Double balance){this.balance = balance;}
}
