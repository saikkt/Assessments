package com.bankservice.adapter;

public interface CreditCheckClient {
    CreditCheckModel getEligibilityStatus(String SSN);
}
