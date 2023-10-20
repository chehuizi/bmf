package com.bmf.design.base.tactics.entity;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 领域实体属性
 */
@Data
public class DomainEntityAttr extends BaseModel {

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