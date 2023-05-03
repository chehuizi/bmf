package com.bmf.api.validator;

import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessFlowCmdReqDTOValidator")
public class BusinessFlowCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param businessFlowCmdReqDTO
     * @return
     */
    public boolean v4Create(BusinessFlowCmdReqDTO businessFlowCmdReqDTO) {
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlow(), "business flow is null");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlow().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlow().getFlowName(), "business flow name is blank");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlow().getFlowAlias(), "business flow alias is blank");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlow().getRoleId(), "role id is null");
        return true;
    }

    /**
     * 校验addFlowNode方法
     * @param businessFlowCmdReqDTO
     * @return
     */
    public boolean v4AddFlowNode(BusinessFlowCmdReqDTO businessFlowCmdReqDTO) {
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlowNode(), "business flow node is null");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlowNode().getFlowId(), "flow id is null");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlowNode().getNodeName(), "flow node name is blank");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlowNode().getNodeAlias(), "flow node alias is blank");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlowNode().getNodeType(), "flow node type is blank");
        ParamCheckUtil.checkBlank(businessFlowCmdReqDTO.getBusinessFlowNode().getDomainElement(), "domain element is blank");
        ParamCheckUtil.checkNull(businessFlowCmdReqDTO.getBusinessFlowNode().getElementId(), "domain element id is null");
        return true;
    }
}