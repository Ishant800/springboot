//package com.example.demo.service;
//import com.example.demo.Entities.Order;
//import com.example.demo.Entities.Product;
//import com.example.demo.repository.OrderRepo;
//import com.example.demo.repository.PaymentRepo;
//import com.example.demo.repository.ProductRepo;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderService {
//    @Autowired
//    public ProductRepo productRepo;
//
//    @Autowired
//    public OrderRepo orderRepo;
//
//    @Autowired
//    public PaymentRepo paymentRepo;
//
//    @Transactional
//    public void placeOrder(Integer productId,Long quantity){
//        Product product = productRepo.findProduct(productId);
//
//        if(product.getStock() < quantity){
//            throw new RuntimeException("Not enough stock");
//        }
//
//        Order order = new Order();
//        order.setQuantity(quantity);
//        order.setTotalPrice(product.getProductPrice() * quantity);
//        orderRepo.save(order);
//
//
//}
//
//}
