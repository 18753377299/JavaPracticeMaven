package javaPractice.simple.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Chen
 * @create 2021-02-16 1:14
 */

@Setter
@Getter
public class RequestBean {

    /**
     * 审核状态
     */
    private String[] assetUnderwriteStatus;

    /**
     * 页数
     */
    private Integer pageNo = 1;
    /**
     * 每页数量
     */
    private Integer pageSize = 5;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startDate;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;


    /* 库存查询条件*/

    /**
     * 归属机构
     */
    private String assetComCode;

    /**
     * 使用类型
     */
    private String assetAttributeLevel;

    /**
     * 使用人员工号
     */
    private String assetApplyStaffCode;

    /**
     * 使用人员名称
     */
    private String assetApplyStaffName;

    /**
     * 资产性质
     */
    private String assetNature;

    /**
     * 资产种类
     */
    private String assetSort;

    /**
     * 成本最小值
     */
    private BigDecimal assetMinAmount;

    /**
     * 成本最大值
     */
    private BigDecimal assetMaxAmount;

    /**
     * 资产状态
     */
    private String[] assetStatus;

    /* 工单查询条件*/

    /**
     * 工单类型
     */
    private String workOrderType;


    /** 申请原因*/
    private String assetApplyReason;

    /** 资产id*/
    private String assetId;

    /** 用户工号*/
    private Integer userId;


    /** 如果是审核的时候,需要增加   "0": 待审核查询 */
    private String queryType;


    /** 数据权限： 所有员工工号集合  */
    private List<String> userNames;


    /** 数据权限： 所有归属机构集合  */
    private List<Integer> comIds;


}
