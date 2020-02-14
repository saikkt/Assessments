package com.bankservice.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreditCheckModel {
    @JsonProperty
    private EligibilityStatus eligibilityStatus;

    public EligibilityStatus getEligibilityStatus() {
        return eligibilityStatus;
    }

    public void setEligibilityStatus(EligibilityStatus eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }
}
