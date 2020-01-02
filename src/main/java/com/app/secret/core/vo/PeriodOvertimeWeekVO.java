package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/23 16:43
 */
@Data
public class PeriodOvertimeWeekVO {

    @ApiModelProperty("部门Id")
    private String id;

    @ApiModelProperty("部门")
    private String partName;

    @ApiModelProperty("工作年份")
    private Integer workYear;

    @ApiModelProperty("工作月份")
    private Integer workMonth;

    @ApiModelProperty("工作日期")
    private Date workDate;

    @ApiModelProperty("加班时长")
    private int talOverTime;

}
