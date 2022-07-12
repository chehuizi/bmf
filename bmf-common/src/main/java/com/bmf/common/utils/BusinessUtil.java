package com.bmf.common.utils;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;

public class BusinessUtil {

    public static Business convert(BusinessReqDTO reqDTO) {
        Business business = new Business();
        business.setBusinessCode(reqDTO.getBusiness().getBusinessCode());
        business.setBusinessName(reqDTO.getBusiness().getBusinessName());
        return business;
    }

    public static BusinessRelDomainDO convertBusinessRelDomainDO(BusinessReqDTO businessReqDTO) {
        BusinessRelDomainDO businessRelDomainDO = new BusinessRelDomainDO();
        businessRelDomainDO.setBusinessCode(businessReqDTO.getBusiness().getBusinessCode());
        businessRelDomainDO.setDomainCode(businessReqDTO.getDomain().getDomainCode());
        return businessRelDomainDO;
    }
}