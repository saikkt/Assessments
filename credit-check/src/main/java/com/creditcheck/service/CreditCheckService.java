package com.creditcheck.service;

import com.creditcheck.domain.CreditCheck;
import com.creditcheck.domain.EligibilityStatus;
import com.creditcheck.domain.Person;
import com.creditcheck.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckService {
    private PersonRepository personRepository;

    public CreditCheckService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public CreditCheck creditCheck(String SSN)  {
        CreditCheck creditCheck = new CreditCheck();
        if(personRepository.findBySSN(SSN).isEligibility()==true)
        {
            creditCheck.setEligibilityStatus(EligibilityStatus.YES);
        }
        else {
            creditCheck.setEligibilityStatus(EligibilityStatus.NO);
        }
        return creditCheck;
    }
}
