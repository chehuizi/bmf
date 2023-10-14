package com.bmf.design.api.validator;

import com.bmf.design.api.flow.dto.BusinessFlowConfigCmdReqDTO;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessFlowCmdReqDTOValidator")
public class BusinessFlowCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param businessFlowConfigCmdReqDTO
     * @return
     */
    public boolean v4Create(BusinessFlowConfigCmdReqDTO businessFlowConfigCmdReqDTO) {
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO.getBusinessFlow(), "business flow is null");
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO.getBusinessFlow().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkBlank(businessFlowConfigCmdReqDTO.getBusinessFlow().getFlowName(), "business flow name is blank");
        ParamCheckUtil.checkBlank(businessFlowConfigCmdReqDTO.getBusinessFlow().getFlowAlias(), "business flow alias is blank");
        return true;
    }

    /**
     * 校验addFlowNode方法
     * @param businessFlowConfigCmdReqDTO
     * @return
     */
    public boolean v4AddFlowNode(BusinessFlowConfigCmdReqDTO businessFlowConfigCmdReqDTO) {
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO.getBusinessFlowNode(), "business flow node is null");
        ParamCheckUtil.checkNull(businessFlowConfigCmdReqDTO.getBusinessFlowNode().getFlowId(), "flow id is null");
        ParamCheckUtil.checkBlank(businessFlowConfigCmdReqDTO.getBusinessFlowNode().getNodeName(), "flow node name is blank");
        ParamCheckUtil.checkBlank(businessFlowConfigCmdReqDTO.getBusinessFlowNode().getNodeAlias(), "flow node alias is blank");
        ParamCheckUtil.checkBlank(businessFlowConfigCmdReqDTO.getBusinessFlowNode().getNodeType(), "flow node type is blank");
        return true;
    }
}
