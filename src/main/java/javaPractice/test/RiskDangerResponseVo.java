package javaPractice.test;

import java.io.Serializable;

/**
 * @Description: 大灾调度平台统计类报表返回数据类型(供大灾调度平台使用)
 * @Author: liqiankun
 * @Params: dateTime: 时间
 * @Return: ins.framework.web.AjaxResult
 * @Date: 20200426
 */
public class RiskDangerResponseVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*简化版数量*/
	private Integer simplifyNum;
	/*专业版数量*/
	private Integer  majorNum;
	/*总任务数量: 专业版数量+简化版数量*/
	private Integer totalNum;
	/*机构编码*/
	private  String comCode;
	/*机构名称*/
	private String comName;
	/*时间*/
	private String dateTime;
	
	public Integer getSimplifyNum() {
		return simplifyNum;
	}
	public void setSimplifyNum(Integer simplifyNum) {
		this.simplifyNum = simplifyNum;
	}
	public Integer getMajorNum() {
		return majorNum;
	}
	public void setMajorNum(Integer majorNum) {
		this.majorNum = majorNum;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
}
