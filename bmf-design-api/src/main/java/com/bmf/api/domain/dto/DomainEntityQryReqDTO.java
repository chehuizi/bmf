package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.entity.DomainEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域实体qry请求对象
 */
@Data
public class DomainEntityQryReqDTO extends ReqDTO implements Serializable {


    /**
     * 领域实体
     */
    private DomainEntity domainEntity;
    /**
     * 包含实体属性
     */
    private boolean includeAttr;
    /**
     * 包含实体值对象
     */
    private boolean includeVo;
}
