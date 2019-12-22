package com.app.secret.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/22 14:04
 */
@Data
public class OvertimeRateDto {

    @ApiModelProperty("工作年份")
    private Integer workYear;

    @ApiModelProperty("工作月份")
    private Integer workMonth;

    @ApiModelProperty("加班率")
    private double overTimeRate;

}
