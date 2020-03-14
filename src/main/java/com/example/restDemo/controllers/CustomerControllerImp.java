package com.example.restDemo.controllers;

import com.example.restDemo.WSObject.WSCustomerRequest;
import com.example.restDemo.WSObject.WSCustomerResponse;
import com.example.restDemo.appException.domain.DataNotFoundException;
import com.example.restDemo.appException.domain.DataValidationException;
import com.example.restDemo.domain.Customer;
import com.example.restDemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerControllerImp implements CustomerController{
    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerServcieImp;

    public CustomerControllerImp(CustomerService customerService) {
        this.customerServcieImp = customerService;
    }

    public List<WSCustomerResponse> getAllCustomers(){
        return customerServcieImp.findAllCustomers();
    }

    public WSCustomerResponse getCustomerById(@PathVariable Long id) throws Exception {
           WSCustomerResponse customer = customerServcieImp.findCustomerById(id);
           if(customer == null) {
               throw new DataNotFoundException("Id", id.toString());
           }
           return customer;
    }

    public Customer addNewCustomer(@RequestBody WSCustomerRequest customer) throws DataValidationException {
        try {
           return customerServcieImp.saveCustomer(customer);
        } catch (Exception e) {
            throw new DataValidationException(e);
        }
    }
}
