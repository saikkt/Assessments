package com.creditcheck.domain;

public class Person {

    private String SSN;
    private boolean eligibility;

    public Person(String SSN, boolean eligibility) {
        this.SSN = SSN;
        this.eligibility = eligibility;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public boolean isEligibility() {
        return eligibility;
    }

    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }
}
