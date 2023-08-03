package com.customerService.Customer.Service.service;

import com.customerService.Customer.Service.domain.Customer;
import com.customerService.Customer.Service.exception.CustomerWithSpecifiedIdAlreadyExist;
import com.customerService.Customer.Service.exception.CustomerWithTheSpecifiedIdDoesNotExist;
import com.customerService.Customer.Service.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Customer saveCustomerDetails(Customer customer) throws CustomerWithSpecifiedIdAlreadyExist {
        if(iCustomerRepository.findById(customer.getCustomerId()).isEmpty())
        {
            return iCustomerRepository.save(customer);
        }
        else
        {
            throw new CustomerWithSpecifiedIdAlreadyExist();
        }
    }

    @Override
    public List<Customer> fetchAllCustomerDetails() {
        return iCustomerRepository.findAll();
    }

    @Override
    public boolean deleteCustomerDetails(int customerId)  throws CustomerWithTheSpecifiedIdDoesNotExist {
        if(iCustomerRepository.findById(customerId).isPresent())
        {
            iCustomerRepository.deleteById(customerId);
            return true;
        }
        else
        {
            throw new CustomerWithTheSpecifiedIdDoesNotExist();
        }
    }

    @Override
    public List<Customer> findCustomerByProductName(String productName) {
        return iCustomerRepository.findCustomerByProductName(productName);
    }


}
