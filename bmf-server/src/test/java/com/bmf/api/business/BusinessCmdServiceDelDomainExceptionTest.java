package com.bmf.api.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.common.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceDelDomainExceptionTest {

    @Autowired
    private BusinessCmdService businessCmdService;

    @Test
    public void test_business_del_domain_exp_80001_1() {
        Result<Boolean> result = businessCmdService.delDomain(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_del_domain_exp_100005_1() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessCmdReqDTO.setBusiness(business);
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(10);
        businessCmdReqDTO.setDomain(domain);
        Result<Boolean> result = businessCmdService.delDomain(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.DOMAIN_HAS_RELATION.getCode() == result.getCode());
    }
}

