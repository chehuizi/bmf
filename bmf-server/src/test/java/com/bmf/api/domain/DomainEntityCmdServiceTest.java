package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainEntityCmdService;
import com.bmf.api.domain.dto.DomainEntityReqDTO;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEntityCmdServiceTest {

    @Autowired
    private DomainEntityCmdService domainEntityCmdService;

    @Test
    public void testAddEntityAttr() {
        DomainEntityReqDTO domainEntityReqDTO = new DomainEntityReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(10001);
        domainEntityReqDTO.setDomainEntity(domainEntity);
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setAttrName("area");
        domainEntityAttr.setAttrType(AttrTypeEnum.INTEGER.getType());
        domainEntityAttr.setAttrDesc("面积");
        domainEntityReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.addEntityAttr(domainEntityReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelEntityAttr() {
        DomainEntityReqDTO domainEntityReqDTO = new DomainEntityReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(100010);
        domainEntityReqDTO.setDomainEntity(domainEntity);
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setEntityIdCode(100010);
        domainEntityAttr.setAttrName("address");
        domainEntityReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.delEntityAttr(domainEntityReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

