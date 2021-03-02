package com.common.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年7月19日 下午3:19:03
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */

@Data
public class RiskGradeVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//总分值
	private BigDecimal  score;
	// echarts图中显示数据的vo类
//	private RiskReportAssess riskReportAssess;
	
	
}
