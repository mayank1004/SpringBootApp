package com.example.restDemo.bootStrap;

import com.example.restDemo.domain.Customer;
import com.example.restDemo.repository.CustomerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRespository customerRespository;

    public BootStrapData(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setFirstName("Mayank");
        c1.setLastName("Bhatt");
        customerRespository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstName("Aditi");
        c2.setLastName("Akalkotkar");
        customerRespository.save(c2);

        System.out.println("Customers count is:"+customerRespository.count());

    }
}
