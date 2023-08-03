package com.customerService.Customer.Service.repository;

import com.customerService.Customer.Service.domain.Customer;
import com.customerService.Customer.Service.domain.Product;
import com.customerService.Customer.Service.exception.CustomerWithSpecifiedIdAlreadyExist;
import com.customerService.Customer.Service.exception.CustomerWithTheSpecifiedIdDoesNotExist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataMongoTest
class ICustomerRepositoryTest {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    private Customer customer;
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(11,"XYZ","JJGUG");
        customer = new Customer(2,"Manish",8989,"jkhhk",product);
    }

    @AfterEach
    void tearDown() {
        product = null;
        customer = null;
        iCustomerRepository.deleteAll();
    }

    @DisplayName("Test case for saving customer objects")
    @Test
    public void saveCustomerDetails(){
        iCustomerRepository.save(customer);
        Customer customer1 = iCustomerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1.getCustomerId());
        assertEquals(customer.getCustomerId(),customer1.getCustomerId());
    }

    @DisplayName("Test case for deleting customer objects")
    @Test
    public void deleteCustomerDetails(){
        iCustomerRepository.insert(customer);
        Product product1 = new Product(222,"harry","kjeldjw");
        Customer customer1 = new Customer(22,"priyanshu",8474,"llk",product1);
        iCustomerRepository.deleteById(customer1.getCustomerId());
        boolean actual = iCustomerRepository.findById(customer1.getCustomerId()).isEmpty();
        assertEquals(true,actual);
    }

    @DisplayName("Test case for finding Product Name")
    @Test
    public void findCustomerByProductName()
    {
        iCustomerRepository.insert(customer);
        Product product1 = new Product(222,"harry","kjeldjw");
        Customer customer1 = new Customer(22,"priyanshu",8474,"llk",product1);
        iCustomerRepository.insert(customer1);
        List<Customer> list = iCustomerRepository.findAll();
        assertEquals(2,list.size());
        assertEquals("harry",list.get(1).getProduct().getProductName());
    }
}