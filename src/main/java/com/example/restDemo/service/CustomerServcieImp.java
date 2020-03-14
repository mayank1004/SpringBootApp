package com.example.restDemo.service;

import com.example.restDemo.WSObject.WSCustomerRequest;
import com.example.restDemo.WSObject.WSCustomerResponse;
import com.example.restDemo.domain.Customer;
import com.example.restDemo.externalService.ChuckNorrisJoke;
import com.example.restDemo.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Customer> findAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public Customer saveCustomer(WSCustomerRequest customer) {
        return customerRespository.save(customer.toVO());
    }

    public WSCustomerResponse decorateWithJoke(Customer customer) throws Exception {
        WSCustomerResponse customerResponse = new WSCustomerResponse(customer);
        try{
            customerResponse.setJokeOfDay(chuckNorrisJoke.getRandomJoke());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return customerResponse;
    }
}
