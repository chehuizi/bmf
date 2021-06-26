package com.chz.bmf.domain.base.tactics.aggregate;

import com.chz.bmf.domain.base.meta.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class BusinessAggregate {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;
    /**
     * 业务实体唯一ID
     */
    private String businessEntityId;

    public BusinessAggregate() {
        this.businessEntityId = buildBusinessEntityId();
    }

    /**
     * 构建业务实体唯一ID
     */
    public abstract String buildBusinessEntityId();
}
