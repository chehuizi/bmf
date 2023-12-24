package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.Business;
import com.bmf.design.infrastructure.dal.mapper.BusinessMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.BusinessRepository;
import com.bmf.design.infrastructure.dal.po.BusinessPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRepositoryImpl implements BusinessRepository {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public Business selectOne(Business req) {
        BusinessPO businessPO = POUtils.convert(req, BusinessPO.class);
        return POUtils.convert(businessMapper.selectOne(businessPO), Business.class);
    }

    @Override
    public List<Business> selectByBusinessCode(List<Integer> businessCodeList) {
        return POUtils.convert(businessMapper.selectByBusinessCode(businessCodeList),
                Business.class);
    }

    @Override
    public boolean insert(Business req) {
        BusinessPO businessPO = POUtils.convert(req, BusinessPO.class);
        return businessMapper.insert(businessPO) == 1;
    }

    @Override
    public boolean update(Business req) {
        BusinessPO businessPO = POUtils.convert(req, BusinessPO.class);
        return businessMapper.update(businessPO) == 1;
    }

    @Override
    public boolean delete(Business req) {
        return false;
    }
}