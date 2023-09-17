package com.bmf.base.application;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务API
 */
@Data
public class DomainApi extends BaseModel {

    /**
     * 应用ID
     */
    private Integer appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用描述
     */
    private String appDesc;
    /**
     * API名称
     */
    private String apiName;
    /**
     * API路径
     */
    private String apiPath;
    /**
     * API描述
     */
    private String apiDesc;
    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;
    /**
     * 领域服务编码
     */
    private Integer serviceCode;
    /**
     * 领域服务别名（英文）
     */
    private String serviceAlias;
}
