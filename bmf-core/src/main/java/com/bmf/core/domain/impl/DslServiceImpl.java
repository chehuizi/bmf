package com.bmf.core.domain.impl;

import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.core.domain.DslService;
import com.bmf.infrastructure.dal.DslExtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DslServiceImpl implements DslService {

    @Autowired
    private DslExtRepository dslExtRepository;

    @Override
    public Boolean addDslExt(List<BusinessDslExt> dslExtList) {
        return dslExtRepository.batchInsert(dslExtList);
    }

    @Override
    public Boolean delDslExt(BusinessDslExt dslExt) {
        return dslExtRepository.delete(dslExt);
    }
}
