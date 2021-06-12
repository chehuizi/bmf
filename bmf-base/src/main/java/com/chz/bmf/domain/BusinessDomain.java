package com.chz.bmf.domain;

import com.chz.bmf.entity.BusinessEntity4Domain;
import com.chz.bmf.meta.BusinessDomainMeta;
import com.chz.bmf.service.BusinessService4Domain;
import lombok.Data;

import java.util.List;

/**
 * 业务领域
 */
@Data
public class BusinessDomain {

    /**
     * 领域元数据
     */
    private BusinessDomainMeta meta;
    /**
     * 领域实体列表
     */
    private List<BusinessEntity4Domain> entityList;
    /**
     * 领域服务列表
     */
    private List<BusinessService4Domain> serviceList;

}
