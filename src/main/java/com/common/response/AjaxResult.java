package com.common.response;

import java.util.Map;

import lombok.Data;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年7月19日 下午4:48:02
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */

@Data
public class AjaxResult {
	
	private Object data;
	private Map<String, Object> map;
	private long status;
	private String message;
	private UserInfo userInfo;
	
}
