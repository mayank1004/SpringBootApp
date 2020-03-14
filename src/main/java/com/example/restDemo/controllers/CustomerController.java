package com.example.restDemo.controllers;

import com.example.restDemo.WSObject.WSCustomerRequest;
import com.example.restDemo.WSObject.WSCustomerResponse;
import com.example.restDemo.appException.domain.DataValidationException;
import com.example.restDemo.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(CustomerControllerImp.BASE_URL)
public interface CustomerController {

    @GetMapping
    List<WSCustomerResponse> getAllCustomers();

    @GetMapping("/{id}")
    WSCustomerResponse getCustomerById(@PathVariable Long id) throws Exception;

    @PostMapping
    Customer addNewCustomer(@RequestBody WSCustomerRequest customer) throws DataValidationException;

}
