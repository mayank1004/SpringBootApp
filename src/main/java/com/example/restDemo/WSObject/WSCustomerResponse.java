package com.example.restDemo.WSObject;

import com.example.restDemo.domain.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WSCustomerResponse {
    private String firstName;
    private String lastName;
    private String jokeOfDay;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJokeOfDay() {
        return jokeOfDay;
    }

    public void setJokeOfDay(String jokeOfDay) {
        this.jokeOfDay = jokeOfDay;
    }

    public WSCustomerResponse() {
    }

    public Customer toVO(){
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        return customer;
    }

    public WSCustomerResponse (Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }
}
