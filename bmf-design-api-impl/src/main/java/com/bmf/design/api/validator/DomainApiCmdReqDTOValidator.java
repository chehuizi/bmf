package com.bmf.design.api.validator;

import com.bmf.design.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainApiCmdReqDTOValidator")
public class DomainApiCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param domainAppCmdReqDTO
     * @return
     */
    public boolean v4Create(DomainAppCmdReqDTO domainAppCmdReqDTO) {
        ParamCheckUtil.checkNull(domainAppCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainAppCmdReqDTO.getDomainAppApiList(), "business api list is null");
        return true;
    }
}