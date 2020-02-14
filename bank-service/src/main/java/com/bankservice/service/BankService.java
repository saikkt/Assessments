package com.bankservice.service;

import com.bankservice.adapter.CreditCheckClient;
import com.bankservice.adapter.CreditCheckModel;
import com.bankservice.adapter.EligibilityStatus;
import com.bankservice.domain.ApprovalStatus;
import com.bankservice.domain.Customer;
import com.bankservice.domain.Status;
import com.bankservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private CustomerRepository customerRepository;
    private CreditCheckClient creditCheckClient;

    public BankService(CustomerRepository customerRepository, CreditCheckClient creditCheckClient) {
        this.customerRepository = customerRepository;
        this.creditCheckClient = creditCheckClient;
    }
     public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
     }

   public ApprovalStatus getApprovalStatus(String SSN){
        ApprovalStatus approvalStatus = new ApprovalStatus();
        CreditCheckModel creditCheckModel = creditCheckClient.getEligibilityStatus(SSN);
        if(creditCheckModel.getEligibilityStatus().ordinal()==0){
            approvalStatus.setStatus(Status.SUCCESS);
            approvalStatus.setData("Your request is approved");
        }
        else {
            approvalStatus.setStatus(Status.FAILURE);
            approvalStatus.setData("Your request is not approved.");
        }
        return approvalStatus;
   }
}
