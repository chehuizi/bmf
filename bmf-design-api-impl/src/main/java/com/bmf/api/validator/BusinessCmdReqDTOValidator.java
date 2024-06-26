package com.bmf.api.validator;

import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessCmdReqDTOValidator")
public class BusinessCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4Create(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessPrefix(), "business prefix is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessAlias(), "business alias is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessName(), "business name is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessDesc(), "business description is blank");
        return true;
    }

    /**
     * 校验addDomain方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4AddDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getDomain(), "domain is null");
        return true;
    }

    /**
     * 校验delDomain方法
     * @return
     */
    public boolean v4DelDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getDomain(), "domain is null");
        return true;
    }

    /**
     * 校验buildDomainRelation方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4BuildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        checkDomainRelation(businessCmdReqDTO.getRelationship());
        return true;
    }

    /**
     * 校验removeDomainRelation方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4RemoveDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        checkDomainRelation(businessCmdReqDTO.getRelationship());
        return true;
    }

    /**
     * 校验BusinessDomainRelationship参数
     * @param relationship
     */
    private void checkDomainRelation(BusinessDomainRelationship relationship) {
        ParamCheckUtil.checkNull(relationship, "relationship is null");
        ParamCheckUtil.checkNull(relationship.getBusinessCode(), "business code is null");
        ParamCheckUtil.checkBlank(relationship.getRelationship(), "relationship is blank");
        ParamCheckUtil.checkNull(relationship.getRoleA(), "roleA is null");
        ParamCheckUtil.checkNull(relationship.getRoleB(), "roleB is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain(), "roleA's domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain().getDomainCode(), "roleA's domain code is null");
        ParamCheckUtil.checkBlank(relationship.getRoleA().getRole(), "roleA's role is blank");
        ParamCheckUtil.checkNull(relationship.getRoleB().getDomain(), "roleB's domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain().getDomainCode(), "roleB's domain code is null");
        ParamCheckUtil.checkBlank(relationship.getRoleB().getRole(), "roleB's role is blank");
    }
}
