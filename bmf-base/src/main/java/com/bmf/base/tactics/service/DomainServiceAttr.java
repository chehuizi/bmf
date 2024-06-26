package com.bmf.base.tactics.service;

import com.bmf.base.BaseModel;
import com.bmf.base.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 领域服务属性
 */
@Data
public class DomainServiceAttr extends BaseModel {

    /**
     * 领域服务编码
     */
    private Integer serviceCode;
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
