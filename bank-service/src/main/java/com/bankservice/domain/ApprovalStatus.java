package com.bankservice.domain;

public class ApprovalStatus {
    private Status status;
    private String data;
    private String error;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
