package com.bankservice.api;

import com.bankservice.domain.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerModel customerModel){
        Customer customer = new Customer(customerModel.getFirstName(),customerModel.getLastName());
        customer.setZipCode(customerModel.getZipCode());
        customer.setSSN(customerModel.getSSN());
        customer.setCreditCardNumber(customerModel.getCreditCardNumber());

        return customer;
    }

    public static CustomerModel toModel(Customer customer){
        CustomerModel customerModel = new CustomerModel(customer.getFirstName(),customer.getLastName());
        customerModel.setCreditCardNumber(customer.getCreditCardNumber());
        customerModel.setSSN(customer.getSSN());
        customerModel.setZipCode(customer.getZipCode());

        return customerModel;
    }
}
