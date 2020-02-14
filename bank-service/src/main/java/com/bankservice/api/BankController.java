package com.bankservice.api;

import com.bankservice.domain.ApprovalStatus;
import com.bankservice.domain.Customer;
import com.bankservice.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/creditlimitincrease")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerModel>> get(){
       List<Customer> customers =  bankService.getAllCustomers();
       List<CustomerModel> customerModels =  customers.stream().map(c->CustomerMapper.toModel(c)).collect(Collectors.toList());

       return ResponseEntity.ok(customerModels);
    }
    @PostMapping
    public ResponseEntity<ApprovalStausModel> getApproval(@RequestBody CustomerModel customerModel){
        Customer customer = CustomerMapper.toEntity(customerModel);
        ApprovalStatus approvalStatus = bankService.getApprovalStatus(customer.getSSN());
        ApprovalStausModel approvalStausModel = ApprovalStatusMapper.toModel(approvalStatus);

        return ResponseEntity.ok(approvalStausModel);
    }
}
