package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author crsu 2020/1/8
 */
@Data
public class MfBreakOffVO {
    @ApiModelProperty("工号")
    private String pcode;

    @ApiModelProperty("姓名")
    private String pname;

    @ApiModelProperty("工作年份")
    private Integer workYear;

    @ApiModelProperty("工作月份")
    private Integer workMonth;

    @ApiModelProperty("可调休时长")
    private java.sql.Time usableBreakOffTime;

    @ApiModelProperty("已调休时长")
    private java.sql.Time usedBreakOffTime;

    @ApiModelProperty("调休率")
    private String breakOffVal;
}
