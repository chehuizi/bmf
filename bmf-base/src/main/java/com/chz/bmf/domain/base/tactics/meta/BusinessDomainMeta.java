package com.chz.bmf.domain.base.tactics.meta;

import lombok.Data;

/**
 * 业务领域元数据
 */
@Data
public abstract class BusinessDomainMeta {

    /**
     * 等级
     */
    private BusinessDomainLevelEnum level;
    /**
     * 名称
     */
    private BusinessDomainNameEnum name;

    public BusinessDomainMeta(BusinessDomainLevelEnum level, BusinessDomainNameEnum name) {
        this.level = level;
        this.name = name;
    }
}