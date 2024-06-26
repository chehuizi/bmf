package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.base.Business;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessCmdServiceImpl.class);

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DomainService domainService;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessCmdReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessCheckUtil.checkNonNull(business, BizCodeEnum.BUSINESS_IS_EXISTED);
        req.getBusiness().setBusinessCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_BUSINESS.getKey()));
        return ResultUtil.success(businessService.createBusiness(req.getBusiness()));
    }

    @Override
    public Result<Boolean> update(BusinessCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(BusinessCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4AddDomain")
    public Result<Boolean> addDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessService.addDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4DelDomain")
    public Result<Boolean> delDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        List<BusinessDomainRelation> businessDomainRelationList = businessService.queryBusinessDomainRelation(business, domain);
        BusinessCheckUtil.checkNonNull(businessDomainRelationList, BizCodeEnum.DOMAIN_HAS_RELATION);
        return ResultUtil.success(businessService.delDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4BuildDomainRelation")
    public Result<Boolean> buildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessRelDomain businessRelDomain = businessService.queryBusinessRelDomain(business, domainA);
        BusinessCheckUtil.checkNull(businessRelDomain, BizCodeEnum.BUSINESS_REL_DOMAIN_NOT_EXIST);
        businessRelDomain = businessService.queryBusinessRelDomain(business, domainB);
        BusinessCheckUtil.checkNull(businessRelDomain, BizCodeEnum.BUSINESS_REL_DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessCmdReqDTO.getRelationship()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4RemoveDomainRelation")
    public Result<Boolean> removeDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessCmdReqDTO.getRelationship()));
    }

    @Override
    public Result<Boolean> addRole(BusinessCmdReqDTO businessCmdReqDTO) {
        businessCmdReqDTO.getBusinessRole().setRoleId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ROLE.getKey()));
        return ResultUtil.success(businessService.addRole(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getBusinessRole()));
    }

    @Override
    public Result<Boolean> delRole(BusinessCmdReqDTO businessCmdReqDTO) {
        return ResultUtil.success(businessService.delRole(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getBusinessRole()));
    }
}
