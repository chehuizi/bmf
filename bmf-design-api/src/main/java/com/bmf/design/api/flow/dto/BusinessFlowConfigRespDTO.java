package com.bmf.design.api.flow.dto;

import com.bmf.design.api.RespDTO;
import com.bmf.design.base.flow.BusinessFlow;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessFlowConfigRespDTO extends RespDTO implements Serializable {

    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
}