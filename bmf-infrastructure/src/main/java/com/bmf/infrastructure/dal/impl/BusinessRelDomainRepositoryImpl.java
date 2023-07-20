package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessRelDomain;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRelDomainRepositoryImpl implements BusinessRelDomainRepository {

    @Autowired
    private BusinessRelDomainMapper businessRelDomainMapper;

    @Override
    public BusinessRelDomain selectOne(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return POUtils.convert(businessRelDomainMapper.selectOne(businessRelDomainPO), BusinessRelDomain.class);
    }

    @Override
    public List<BusinessRelDomain> selectList(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return POUtils.convert(businessRelDomainMapper.selectList(businessRelDomainPO), BusinessRelDomain.class);
    }

    @Override
    public boolean insert(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return businessRelDomainMapper.insert(businessRelDomainPO) == 1;
    }

    @Override
    public boolean batchInsert(List<BusinessRelDomain> businessRelDomainList) {
        List<BusinessRelDomainPO> businessRelDomainPOList = POUtils.convertModel2PO(businessRelDomainList,
                BusinessRelDomainPO.class);
        return businessRelDomainMapper.batchInsert(businessRelDomainPOList) > 0;
    }

    @Override
    public boolean update(BusinessRelDomain req) {
        return false;
    }

    @Override
    public boolean batchUpdate(List<BusinessRelDomain> businessRelDomainList) {
        List<BusinessRelDomainPO> businessRelDomainPOList = POUtils.convertModel2PO(businessRelDomainList,
                BusinessRelDomainPO.class);
        return businessRelDomainMapper.batchUpdate(businessRelDomainPOList) > 0;
    }

    @Override
    public boolean delete(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return businessRelDomainMapper.delete(businessRelDomainPO) == 1;
    }

    @Override
    public boolean batchDelete(List<BusinessRelDomain> businessRelDomainList) {
        List<BusinessRelDomainPO> businessRelDomainPOList = POUtils.convertModel2PO(businessRelDomainList,
                BusinessRelDomainPO.class);
        return businessRelDomainMapper.batchDelete(businessRelDomainPOList) == businessRelDomainList.size();
    }

    @Override
    public boolean deleteByBusinessCode(Integer businessCode) {
        return businessRelDomainMapper.deleteByBusinessCode(businessCode) >= 1;
    }
}
