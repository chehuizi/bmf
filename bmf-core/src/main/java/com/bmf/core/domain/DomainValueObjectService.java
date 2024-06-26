package com.bmf.core.domain;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;

/**
 * 领域值对象服务
 */
public interface DomainValueObjectService {

    /**
     * 查询领域值对象
     * @param domainValueObject
     * @return
     */
    DomainValueObject queryDomainValueObject(DomainValueObject domainValueObject);
    /**
     * 添加值对象属性
     * @param valueObjectAttr
     * @return
     */
    Boolean addValueObjectAttr(DomainValueObjectAttr valueObjectAttr);

    /**
     * 删除值对象属性
     * @param valueObjectAttr
     * @return
     */
    Boolean delValueObjectAttr(DomainValueObjectAttr valueObjectAttr);
}
