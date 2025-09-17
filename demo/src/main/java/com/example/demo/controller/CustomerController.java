package com.example.demo.controller;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.Order;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
  private CustomerService customerService;

    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer){
      return customerService.createCustomer(customer);
  }
  @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id){
      return customerService.getCustomer(id);
  }

  @PostMapping("/{customerId}/orders")
  public Customer addOrder(@PathVariable Integer customerId, @RequestBody Order order) {
    return customerService.addOrderToCustomer(customerId, order);
  }
}
