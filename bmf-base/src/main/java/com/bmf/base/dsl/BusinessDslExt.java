package com.bmf.base.dsl;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * DSL扩展类
 */
@Data
public class BusinessDslExt extends BaseModel {

    /**
     * 术语编码
     */
    private Integer dslCode;
    /**
     * 扩展类型
     * @see com.bmf.base.enums.AttrTypeEnum
     */
    private String dslExtType;
    /**
     * 扩展key
     */
    private String dslExtKey;
    /**
     * 扩展value
     */
    private Object dslExtVal;
}
