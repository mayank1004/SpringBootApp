package com.example.restDemo.service;

import com.example.restDemo.WSObject.WSCustomerRequest;
import com.example.restDemo.WSObject.WSCustomerResponse;
import com.example.restDemo.appException.domain.OutboundException;
import com.example.restDemo.domain.Customer;
import com.example.restDemo.externalService.ChuckNorrisJoke;
import com.example.restDemo.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServcieImp implements CustomerService {

    private CustomerRespository customerRespository;
    private ChuckNorrisJoke chuckNorrisJoke;

    @Autowired
    public void setChuckNorrisJoke(ChuckNorrisJoke chuckNorrisJoke) {
        this.chuckNorrisJoke = chuckNorrisJoke;
    }

    public CustomerServcieImp() {
    }

    @Autowired
    public void setCustomerRespository(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public WSCustomerResponse findCustomerById(Long id) throws Exception {
        Customer customer = customerRespository.findById(id).orElse(null);
        if(customer != null){
            WSCustomerResponse response = new WSCustomerResponse(customer);
            response = decorateWithJoke(customer);
            return response;
        } else{
            return null;
        }


    }

    @Override
    public List<WSCustomerResponse> findAllCustomers() {
        List<Customer> customers = customerRespository.findAll();
        if(!customers.isEmpty()){
            return customers.stream().map(c -> decorateWithJoke(c)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public Customer saveCustomer(WSCustomerRequest customer) {
        return customerRespository.save(customer.toVO());
    }

    public WSCustomerResponse decorateWithJoke(Customer customer) {
        WSCustomerResponse customerResponse = new WSCustomerResponse(customer);
        try{
            customerResponse.setJokeOfDay(chuckNorrisJoke.getRandomJoke());
        }catch (OutboundException e){
            System.out.println(e.getMessage());
        }
        return customerResponse;
    }
}
