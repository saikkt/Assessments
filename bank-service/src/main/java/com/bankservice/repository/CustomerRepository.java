package com.bankservice.repository;

import com.bankservice.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();
    static{
        Customer customer1 = new Customer("John","Crissman");
        customer1.setSSN("111-11-1111");
        customer1.setCreditCardNumber("3456-5678-3455-4567");
        customer1.setZipCode(00001);
        customers.add(customer1);


        Customer customer2 = new Customer("Marianela", "Crissman");
        customer2.setSSN("222-22-2222");
        customer2.setCreditCardNumber("2345-7896-3784-3943");
        customer2.setZipCode(00002);
        customers.add(customer2);


        Customer customer3 = new Customer("Beth","McDonald");
        customer3.setZipCode(00003);
        customer3.setCreditCardNumber("2345-8907-8908-9087");
        customer3.setSSN("333-33-3333");
        customers.add(customer3);

        Customer customer4 = new Customer("Sai","Pothulapally");
        customer4.setCreditCardNumber("3457-8908-7867-9098");
        customer4.setSSN("444-44-4444");
        customer4.setZipCode(00004);
        customers.add(customer4);
    }

    public List<Customer> findAll(){
        return customers;
    }
}
