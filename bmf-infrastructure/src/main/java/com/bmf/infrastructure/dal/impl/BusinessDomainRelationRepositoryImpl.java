package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelationMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDomainRelationRepositoryImpl implements BusinessDomainRelationRepository {

    @Autowired
    private BusinessDomainRelationMapper businessDomainRelationMapper;

    @Override
    public BusinessDomainRelation selectOne(BusinessDomainRelation req) {
        return null;
    }

    @Override
    public List<BusinessDomainRelation> selectList(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = POUtils.convert(req, BusinessDomainRelationPO.class);
        return POUtils.convert(businessDomainRelationMapper.selectList(businessDomainRelationPO), BusinessDomainRelation.class);
    }

    @Override
    public List<BusinessDomainRelation> selectByDomain(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = POUtils.convert(req, BusinessDomainRelationPO.class);
        return POUtils.convert(businessDomainRelationMapper.selectByDomain(businessDomainRelationPO), BusinessDomainRelation.class);
    }

    @Override
    public boolean insert(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = POUtils.convert(req, BusinessDomainRelationPO.class);
        return businessDomainRelationMapper.insert(businessDomainRelationPO) == 1;
    }

    @Override
    public boolean batchInsert(List<BusinessDomainRelation> businessDomainRelationList) {
        List<BusinessDomainRelationPO> businessDomainRelationPOList = POUtils.convertModel2PO(businessDomainRelationList,
                BusinessDomainRelationPO.class);
        return businessDomainRelationMapper.batchInsert(businessDomainRelationPOList) > 0;
    }

    @Override
    public boolean update(BusinessDomainRelation req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = POUtils.convert(req, BusinessDomainRelationPO.class);
        return businessDomainRelationMapper.delete(businessDomainRelationPO) == 1;
    }
}
