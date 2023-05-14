package com.bmf.api.user.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.user.UserBusiness;
import com.bmf.base.user.UserDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户领域请求对象
 */
@Data
public class UserDomainCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 8760479262846718633L;

    private UserDomain userDomain;
}
