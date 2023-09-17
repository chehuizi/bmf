package com.bmf.api.business;

import com.alibaba.fastjson.JSON;
import com.bmf.api.Result;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.domain.qry.DomainQryService;
import com.bmf.base.Business;
import com.bmf.base.Domain;
import com.bmf.base.enums.*;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.downstream.ConformistRole;
import com.bmf.base.strategy.role.partner.PartnerRole;
import com.bmf.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.base.strategy.symmetric.Partnership;
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
public class BusinessCmdStrategyDesignServiceTest {

    @Autowired
    private BusinessCmdService businessCmdService;
    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_business_save_strategy_design_1() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessCmdReqDTO.setBusiness(business);
        List<Domain> domainList = new ArrayList<>();
        Domain domain1 = new Domain();
        domain1.setDomainCode(101);
        domain1.setDomainAlias("ims");
        domain1.setDomainName("库存域_车慧子");
        domain1.setDomainType(DomainTypeEnum.CORE.getType());
        domain1.setDomainLevel(DomainLevelEnum.TWO.getValue());
        domain1.setDomainPosition("{\"x\": 500, \"y\": 100}");
        domainList.add(domain1);
        Domain domain2 = new Domain();
        domain2.setDomainCode(104);
        domain2.setDomainAlias("ofc");
        domain2.setDomainName("履约域");
        domain2.setDomainType(DomainTypeEnum.CORE.getType());
        domain2.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain2.setDomainPosition("{\"x\": 1000, \"y\": 200}");
        domainList.add(domain2);
        Domain domain3 = new Domain();
        domain3.setDomainCode(109);
        domain3.setDomainAlias("tms");
        domain3.setDomainName("物流域");
        domain3.setDomainType(DomainTypeEnum.CORE.getType());
        domain3.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain3.setDomainPosition("{\"x\": 500, \"y\": 300}");
        domainList.add(domain3);
        Domain domain4 = new Domain();
        domain4.setDomainCode(110);
        domain4.setDomainAlias("wms");
        domain4.setDomainName("仓储域");
        domain4.setDomainType(DomainTypeEnum.CORE.getType());
        domain4.setDomainLevel(DomainLevelEnum.THREE.getValue());
        domain4.setDomainPosition("{\"x\": 500, \"y\": 400}");
        domainList.add(domain4);
        businessCmdReqDTO.setDomainList(domainList);
        List<DomainRelationship> relationshipList = new ArrayList<>();
        DomainRelationship relationship1 = new UpstreamDownstreamRelationship();
        relationship1.setRoleA(new OpenHostServiceRole(domain1));
        relationship1.setRoleB(new ConformistRole(domain2));
        relationshipList.add(relationship1);
        DomainRelationship relationship2 = new UpstreamDownstreamRelationship();
        relationship2.setRoleA(new OpenHostServiceRole(domain1));
        relationship2.setRoleB(new ConformistRole(domain3));
        relationshipList.add(relationship2);
        DomainRelationship relationship3 = new UpstreamDownstreamRelationship();
        relationship3.setRoleA(new OpenHostServiceRole(domain1));
        relationship3.setRoleB(new ConformistRole(domain4));
        relationshipList.add(relationship3);
        DomainRelationship relationship4 = new Partnership();
        relationship4.setRoleA(new PartnerRole(domain2));
        relationship4.setRoleB(new PartnerRole(domain3));
        relationshipList.add(relationship4);
        DomainRelationship relationship5 = new Partnership();
        relationship5.setRoleA(new PartnerRole(domain2));
        relationship5.setRoleB(new PartnerRole(domain4));
        relationshipList.add(relationship5);
        businessCmdReqDTO.setRelationshipList(relationshipList);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_save_strategy_design_2() {
        String str = "{\"business\":{\"businessCode\":102},\"domainList\":[{\"domainCode\":\"0\",\"domainName\":\"库存域\",\"domainAlias\":\"ofc\",\"domainType\":\"generic\",\"domainLevel\":2,\"extInfo\":{\"style\":{\"backgroundColor\":\"red\"}},\"domainPosition\":\"{\\\"x\\\":500,\\\"y\\\":-43}\"},{\"domainCode\":\"1\",\"domainName\":\"仓储域\",\"domainAlias\":\"wms\",\"domainType\":\"generic\",\"domainLevel\":2,\"extInfo\":{\"style\":{\"backgroundColor\":\"pink\"}},\"domainPosition\":\"{\\\"x\\\":234,\\\"y\\\":110}\"}],\"relationshipList\":[{\"relationship\":\"upstream-downstream\",\"roleA\":{\"domain\":{\"domainCode\":\"0\",\"domainAlias\":\"ofc\"},\"role\":\"OHS\"},\"roleB\":{\"domain\":{\"domainCode\":\"1\",\"domainAlias\":\"wms\"},\"role\":\"OHS\"}}]}";
        BusinessCmdReqDTO businessCmdReqDTO = JSON.parseObject(str, BusinessCmdReqDTO.class);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}