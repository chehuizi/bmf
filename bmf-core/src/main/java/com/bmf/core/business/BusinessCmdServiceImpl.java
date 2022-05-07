package com.bmf.core.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessPO;

import javax.annotation.Resource;

public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Resource
    private BusinessRepository businessRepository;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        boolean ret = businessRepository.insert(req);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> update(BusinessReqDTO req) {
        boolean ret = businessRepository.update(req);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> delete(BusinessReqDTO req) {
        boolean ret = businessRepository.delete(req);
        return Result.success(ret);
    }

    @Override
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        BusinessPO businessPO = businessRepository.selectOne(req);
        BusinessRespDTO businessRespDTO = BusinessUtil.convert(businessPO);
        return Result.success(businessRespDTO);
    }
}