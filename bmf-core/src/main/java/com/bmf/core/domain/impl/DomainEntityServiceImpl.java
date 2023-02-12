package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DomainEntityServiceImpl implements DomainEntityService {

    @Autowired
    private DomainEntityRepository domainEntityRepository;

    @Override
    public DomainEntity queryDomainEntity(DomainEntity domainEntity) {
        BusinessDomainEntityPO domainEntityPO = domainEntityRepository.selectOne(domainEntity);
        if (Objects.isNull(domainEntityPO)) {
            return null;
        }
        return DomainPOUtil.convert(domainEntityPO);
    }

}
