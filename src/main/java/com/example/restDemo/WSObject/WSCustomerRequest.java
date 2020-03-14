package com.example.restDemo.WSObject;

import com.example.restDemo.domain.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WSCustomerRequest {
    private String firstName;
    private String lastName;

    public WSCustomerRequest() {
    }

    public Customer toVO(){
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        return customer;
    }

    public WSCustomerRequest toVO(Customer customer){
        WSCustomerRequest wsCustomerRequest = new WSCustomerRequest();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        return wsCustomerRequest;
    }
}
