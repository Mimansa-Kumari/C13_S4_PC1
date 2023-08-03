package com.customerService.Customer.Service.repository;

import com.customerService.Customer.Service.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ICustomerRepository extends MongoRepository<Customer, Integer> {
    @Query("{'product.productName' : {$in:[?0]}}")
    List<Customer> findCustomerByProductName(String productName);
}
