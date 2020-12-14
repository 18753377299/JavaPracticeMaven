package com.common.response;

import java.util.List;

import lombok.Data;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年11月5日 下午4:57:41
 * @version 1.0 
 * @parameter   用于存储用户的基础信息
 * @since  
 * @return  */
@Data
public class UserInfo {
	// 用户名和密码
	private String userCode;
	private String password;
	/*唯一性标志位校验*/
	private String onlyFlag;
	// 用户的token信息
	private String  jwtToken;
	// 权限list
	private List<String> permissionList;
	
}
