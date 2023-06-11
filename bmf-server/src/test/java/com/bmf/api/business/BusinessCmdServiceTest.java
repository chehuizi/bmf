package com.bmf.api.business;

import com.bmf.api.Result;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.domain.qry.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.BusinessPrefixEnum;
import com.bmf.base.enums.BusinessRoleTypeEnum;
import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.flow.BusinessRole;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.downstream.ConformistRole;
import com.bmf.base.strategy.role.partner.PartnerRole;
import com.bmf.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceTest {

    @Autowired
    private BusinessCmdService businessCmdService;
    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_business_create() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessPrefix(BusinessPrefixEnum.B.getPrefix());
        business.setBusinessName("共享两轮业务");
        business.setBusinessAlias("sharing-bike");
        business.setBusinessDesc("共享单车、电单车");
        businessCmdReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.create(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_update() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        business.setBusinessAlias("sharing-bike");
        business.setBusinessDesc("共享两轮业务（单车、电单车）");
        businessCmdReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.update(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_add_domain() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessCmdReqDTO.setBusiness(business);
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(104);
        domain.setDomainPosition("{x: 0, y:400}");
        businessCmdReqDTO.setDomain(domain);
        Result<Boolean> result = businessCmdService.addDomain(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_del_domain() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10003);
        businessCmdReqDTO.setBusiness(business);
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(102);
        businessCmdReqDTO.setDomain(domain);
        Result<Boolean> result = businessCmdService.delDomain(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_save_strategy_design() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessCmdReqDTO.setBusiness(business);
        List<BusinessDomain> businessDomainList = new ArrayList<>();
        BusinessDomain domain1 = new BusinessDomain();
        domain1.setDomainCode(101);
        domain1.setDomainAlias("ofc");
        domain1.setDomainName("履约域");
        domain1.setDomainPosition("{\"x\": 500, \"y\": 100}");
        businessDomainList.add(domain1);
        BusinessDomain domain2 = new BusinessDomain();
        domain2.setDomainCode(102);
        domain2.setDomainAlias("tms");
        domain2.setDomainName("物流域");
        domain2.setDomainPosition("{\"x\": 500, \"y\": 200}");
        businessDomainList.add(domain2);
        businessCmdReqDTO.setDomainList(businessDomainList);
        List<BusinessDomainRelationship> relationshipList = new ArrayList<>();
        BusinessDomainRelationship relationship1 = new BusinessDomainRelationship();
        relationship1.setRelationship(RelationshipEnum.PS.getType());
        relationship1.setRoleA(new PartnerRole(domain1));
        relationship1.setRoleB(new PartnerRole(domain2));
        relationshipList.add(relationship1);
        businessCmdReqDTO.setRelationshipList(relationshipList);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_build_domain_relation() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessCmdReqDTO.setBusiness(business);
        UpstreamDownstreamRelationship<OpenHostServiceRole, ConformistRole> upstreamDownstreamRelationship =
                new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setBusinessCode(102);
        OpenHostServiceRole ohs = new OpenHostServiceRole();
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(104);
        domainQryReqDTO.setBusinessDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainQryReqDTO);
        ohs.setDomain(result1.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleA(ohs);
        ConformistRole cf = new ConformistRole();
        domain.setDomainCode(101);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainQryReqDTO);
        cf.setDomain(result2.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleB(cf);
        businessCmdReqDTO.setRelationship(upstreamDownstreamRelationship);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_remove_domain_relation() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10003);
        businessCmdReqDTO.setBusiness(business);
        UpstreamDownstreamRelationship<OpenHostServiceRole, ConformistRole> upstreamDownstreamRelationship
                = new UpstreamDownstreamRelationship<>();
        upstreamDownstreamRelationship.setBusinessCode(10003);
        OpenHostServiceRole roleA = new OpenHostServiceRole();
        roleA.setDomain(new BusinessDomain(102));
        upstreamDownstreamRelationship.setRoleA(roleA);
        ConformistRole roleB = new ConformistRole();
        roleB.setDomain(new BusinessDomain(103));
        upstreamDownstreamRelationship.setRoleB(roleB);
        businessCmdReqDTO.setRelationship(upstreamDownstreamRelationship);
        Result<Boolean> result = businessCmdService.removeDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_add_role() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessCmdReqDTO.setBusiness(business);
        BusinessRole role = new BusinessRole();
        role.setBusinessCode(102);
        role.setRoleName("仓管");
        role.setRoleAlias("warehouse manager");
        role.setRoleType(BusinessRoleTypeEnum.MANAGER.getType());
        role.setRoleDesc("仓库管理员");
        businessCmdReqDTO.setBusinessRole(role);
        Result<Boolean> result = businessCmdService.addRole(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_del_role() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessCmdReqDTO.setBusiness(business);
        BusinessRole role = new BusinessRole();
        role.setBusinessCode(101);
        role.setRoleId(10001);
        businessCmdReqDTO.setBusinessRole(role);
        Result<Boolean> result = businessCmdService.delRole(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}

