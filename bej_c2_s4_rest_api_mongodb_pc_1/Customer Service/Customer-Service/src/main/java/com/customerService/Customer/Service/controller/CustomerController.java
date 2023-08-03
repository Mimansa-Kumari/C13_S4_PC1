package com.customerService.Customer.Service.controller;

import com.customerService.Customer.Service.domain.Customer;
import com.customerService.Customer.Service.exception.CustomerWithSpecifiedIdAlreadyExist;
import com.customerService.Customer.Service.exception.CustomerWithTheSpecifiedIdDoesNotExist;
import com.customerService.Customer.Service.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    ICustomerService iCustomerService;

    @Autowired
    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?>saveCustomerDetails(@RequestBody Customer customer) throws CustomerWithSpecifiedIdAlreadyExist
    {
        Customer customer1 = iCustomerService.saveCustomerDetails(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<?>fetchAllCustomerDetails()
    {
        List<Customer> list = iCustomerService.fetchAllCustomerDetails();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/delBy/{customerId}")
    public ResponseEntity<?>deleteCustomerDetails(@PathVariable int customerId)  throws CustomerWithTheSpecifiedIdDoesNotExist
    {
        Boolean check = iCustomerService.deleteCustomerDetails(customerId);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }

    @GetMapping("/getCustomerBy/{productName}")
    public ResponseEntity<?>findCustomerByProductName(@PathVariable String productName)
    {
        List<Customer> list = iCustomerService.findCustomerByProductName(productName);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
