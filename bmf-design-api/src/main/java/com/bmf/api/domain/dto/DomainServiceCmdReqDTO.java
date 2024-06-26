package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域服务请求对象
 */
@Data
public class DomainServiceCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 118824266913896116L;
    /**
     * 领域服务
     */
    private DomainService domainService;
    /**
     * 服务属性
     */
    private DomainServiceAttr serviceAttr;
}
