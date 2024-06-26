package com.bmf.infrastructure.dal.po;

import com.bmf.base.enums.AttrTypeEnum;
import lombok.Data;

@Data
public class BusinessDomainEntityAttrPO extends BasePO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 属性名称
     */
    private String attrName;
    /**
     * 属性类型
     * @see AttrTypeEnum
     */
    private String attrType;
    /**
     * 属性描述
     */
    private String attrDesc;

}
