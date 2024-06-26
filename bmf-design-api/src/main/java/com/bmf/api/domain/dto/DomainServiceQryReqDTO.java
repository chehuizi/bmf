package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域服务查询请求对象
 */
@Data
public class DomainServiceQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 381158933983925127L;

    /**
     * 领域服务
     */
    private DomainService domainService;
    /**
     * 包含服务属性
     */
    private boolean includeAttr;
}
