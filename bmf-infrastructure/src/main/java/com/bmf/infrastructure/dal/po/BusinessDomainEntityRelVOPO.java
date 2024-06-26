package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainEntityRelVOPO extends BasePO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;

}
