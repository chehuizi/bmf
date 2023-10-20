package com.bmf.design.api.user.dto;

import com.bmf.design.api.RespDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.user.UserBusiness;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户业务返回对象
 */
@Data
@NoArgsConstructor
public class UserBusinessRespDTO extends RespDTO implements Serializable {

    /**
     * 用户下的业务列表
     */
    private List<UserBusiness> userBusinessList;
    /**
     * 业务列表
     */
    private List<Business> businessList;

    public UserBusinessRespDTO(List<UserBusiness> userBusinessList, List<Business> businessList) {
        this.userBusinessList = userBusinessList;
        this.businessList = businessList;
    }
}