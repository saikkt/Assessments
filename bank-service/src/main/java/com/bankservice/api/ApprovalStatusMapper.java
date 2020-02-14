package com.bankservice.api;

import com.bankservice.domain.ApprovalStatus;

public class ApprovalStatusMapper {
    public static ApprovalStausModel toModel(ApprovalStatus approvalStatus){
        ApprovalStausModel approvalStausModel = new ApprovalStausModel();
        approvalStausModel.setStatus(approvalStatus.getStatus());
        approvalStausModel.setData(approvalStatus.getData());
        approvalStausModel.setError(approvalStatus.getError());

        return approvalStausModel;
    }
}
