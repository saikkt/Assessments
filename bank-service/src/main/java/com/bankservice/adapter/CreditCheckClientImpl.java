package com.bankservice.adapter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CreditCheckClientImpl implements CreditCheckClient {



    private RestTemplate restTemplate = new RestTemplate();
    private CreditCheckClientConfig creditCheckClientConfig;

    public CreditCheckClientImpl(CreditCheckClientConfig creditCheckClientConfig) {
        this.creditCheckClientConfig = creditCheckClientConfig;
    }

    @Override
    @Retryable(maxAttempts = 3,
            backoff = @Backoff(delay = 100, maxDelay = 2000, random = true))
    @HystrixCommand(commandKey = "Banking-Service",
                    groupKey = "getEligibilityStatus",
                    fallbackMethod = "getEligibilityStatusFallback")
    public CreditCheckModel getEligibilityStatus(String SSN) {
        ResponseEntity<CreditCheckModel> responseEntity = restTemplate.getForEntity(creditCheckClientConfig.getURL()+"/creditcheck?SSN="+SSN,CreditCheckModel.class);
        CreditCheckModel creditCheckModel = responseEntity.getBody();
        return creditCheckModel;
    }

    public CreditCheckModel getEligibilityStatusFallback(String SSN){
            throw new RuntimeException("Unable to reach credit check service");
    }

}
