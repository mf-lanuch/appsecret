package com.app.secret.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/22 14:04
 */
@Data
public class OvertimeRateDto {

    @ApiModelProperty("加班时长")
    private String totalOverTime;

    @ApiModelProperty("加班率")
    private double overTimeRate;

    @ApiModelProperty("同期加班率")
    private double periodOvertimeRate;

}
