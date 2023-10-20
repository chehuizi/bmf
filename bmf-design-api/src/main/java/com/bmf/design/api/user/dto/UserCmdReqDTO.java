package com.bmf.design.api.user.dto;

import com.bmf.design.api.ReqDTO;
import com.bmf.design.base.user.User;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户请求对象
 */
@Data
public class UserCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -1973480973231971730L;

    private User user;
}