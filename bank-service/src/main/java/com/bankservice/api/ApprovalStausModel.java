package com.bankservice.api;

import com.bankservice.domain.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ApprovalStausModel {
    @JsonProperty
    private Status status;
    @JsonProperty
    private String data;
    @JsonProperty
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
