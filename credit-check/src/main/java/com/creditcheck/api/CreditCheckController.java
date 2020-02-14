package com.creditcheck.api;

import com.creditcheck.domain.CreditCheck;
import com.creditcheck.service.CreditCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditcheck")
public class CreditCheckController {

    private CreditCheckService creditCheckService;

    public CreditCheckController(CreditCheckService creditCheckService) {
        this.creditCheckService = creditCheckService;
    }

    @GetMapping
    public ResponseEntity<CreditCheck> get(@RequestParam String SSN)  {

        if(SSN==null){
            throw new IllegalArgumentException("SSN is required");
        }
        CreditCheck creditCheck =  creditCheckService.creditCheck(SSN);

        return ResponseEntity.ok(creditCheck);
    }
}
