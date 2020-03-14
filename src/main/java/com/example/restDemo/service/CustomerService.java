package com.example.restDemo.service;

import com.example.restDemo.WSObject.WSCustomerRequest;
import com.example.restDemo.WSObject.WSCustomerResponse;
import com.example.restDemo.controllers.CustomerControllerImp;
import com.example.restDemo.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CustomerControllerImp.BASE_URL)
public interface CustomerService {
    WSCustomerResponse findCustomerById(Long id) throws Exception;
    List<Customer> findAllCustomers();
    Customer saveCustomer(WSCustomerRequest customer);
}
