package com.bmf.design.core.design.impl;

import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.core.design.BusinessFlowDesign;
import com.bmf.design.infrastructure.dal.BusinessFlowNodeRepository;
import com.bmf.design.infrastructure.dal.BusinessFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessFlowDesignImpl implements BusinessFlowDesign {

    @Autowired
    private BusinessFlowRepository businessFlowRepository;
    @Autowired
    private BusinessFlowNodeRepository businessFlowNodeRepository;

    @Override
    @Transactional
    public boolean addFlow(BusinessFlow businessFlow) {
        boolean insertRst = businessFlowRepository.insert(businessFlow);
        if (insertRst) {
            insertRst = businessFlowNodeRepository.batchInsert(businessFlow.getNodeList());
        }
        return insertRst;
    }

    @Override
    public boolean updateFlow(BusinessFlow businessFlow) {
        return false;
    }

    @Override
    public BusinessFlow queryFlow(BusinessFlow businessFlow) {
        return businessFlowRepository.selectOne(businessFlow);
    }
}