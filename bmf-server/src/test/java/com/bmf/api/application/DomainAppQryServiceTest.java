package com.bmf.api.application;

import com.bmf.design.api.Result;
import com.bmf.design.api.application.DomainAppQryService;
import com.bmf.design.api.application.dto.DomainAppQryReqDTO;
import com.bmf.design.api.application.dto.DomainAppRespDTO;
import com.bmf.design.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainAppQryServiceTest {

    @Autowired
    private DomainAppQryService domainAppQryService;

    @Test
    public void test_domain_app_api_query() {
        DomainAppQryReqDTO reqDTO = new DomainAppQryReqDTO();
        reqDTO.setDomainCode(101);
        Result<DomainAppRespDTO> result = domainAppQryService.queryOne(reqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}