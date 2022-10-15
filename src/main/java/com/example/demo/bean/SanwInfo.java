package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 三维风险评测信息
 *
 * @author zhousy
 * @date 2021-09-09  15:17
 */
@Data
@Accessors(chain = true)
@TableName("TM_CUST_RISK_INFO")
@ApiModel(value = "SanwInfo对象", description = "三维风险评测信息表")
public class SanwInfo {

    @ApiModelProperty(value = "客户号")
    @TableField(value = "CAPITAL_ACCOUNT")
    private String capitalAccount;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "MOBILE")
    private String mobile;

    @ApiModelProperty(value = "投资期限：A 0-1年、B 1-5年、C 5年以上")
    @TableField(value = "INVEST_DURATION")
    private String investDuration;

    @ApiModelProperty(value = "最不感兴趣的投资品种")
    @TableField(value = "DISLIKE_TYPE")
    private String dislikeType;

    @ApiModelProperty(value = "风险级别")
    @TableField(value = "EVAL_LEVEL")
    private String evalLevel;
}
