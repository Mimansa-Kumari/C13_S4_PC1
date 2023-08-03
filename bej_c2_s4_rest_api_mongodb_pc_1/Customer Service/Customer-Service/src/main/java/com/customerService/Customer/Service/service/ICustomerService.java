package com.customerService.Customer.Service.service;

import com.customerService.Customer.Service.domain.Customer;
import com.customerService.Customer.Service.exception.CustomerWithSpecifiedIdAlreadyExist;
import com.customerService.Customer.Service.exception.CustomerWithTheSpecifiedIdDoesNotExist;

import java.util.List;

public interface ICustomerService {
    public Customer saveCustomerDetails(Customer customer) throws CustomerWithSpecifiedIdAlreadyExist;
    public List<Customer> fetchAllCustomerDetails();
    public boolean deleteCustomerDetails(int customerId) throws CustomerWithTheSpecifiedIdDoesNotExist;
    public List<Customer> findCustomerByProductName(String productName);
}
