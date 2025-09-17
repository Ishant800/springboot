package com.example.demo.service;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.CustomerProfile;
import com.example.demo.Entities.Order;
import com.example.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
   @Autowired
    private CustomerRepo customerRepo;

   public Customer createCustomer(Customer customer){
       return customerRepo.save(customer);
   }
   public Customer getCustomer(Integer id){
       return customerRepo.findById(id)
               .orElseThrow(()-> new RuntimeException("customer not found"));

   }

   public Customer addOrderToCustomer(Integer customerId, Order order){
       Customer customer = getCustomer(customerId);
       customer.addOrder(order);
       return customerRepo.save(customer);
   }
}
