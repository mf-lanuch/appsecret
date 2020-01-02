package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/23 9:48
 */
@Data
public class PeriodOverTimeVO {

    @ApiModelProperty("部门Id")
    private String id;

    @ApiModelProperty("部门")
    private String partName;

    @ApiModelProperty("工作年份")
    private Integer workYear;

    @ApiModelProperty("工作月份")
    private Integer workMonth;

    @ApiModelProperty("加班时长")
    private int talOverTime;

    @ApiModelProperty("同期加班时长")
    private int lastOverTime;


}
