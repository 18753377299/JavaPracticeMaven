package com.common.request;

import lombok.Data;

import java.io.Serializable;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年7月19日 下午3:57:35
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
@Data
public class RiskRequestVo implements Serializable{


	private static final long serialVersionUID = 1L;
	
//	private RiskReportMain riskReportMainVo;
	/**关联火灾风险排查表*/
//	private List<RiskReportFireDanger>  riskReportFireDangerList;
    /**echarts打分信息保存*/
//    private  RiskReportAssess riskReportAssess;
	/*页码*/
    private Integer pageNo;
    /*每页条数*/
    private Integer pageSize;
    
}
