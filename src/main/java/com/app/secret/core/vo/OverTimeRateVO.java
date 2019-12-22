package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/22 13:21
 */
@Data
public class OverTimeRateVO {

    @ApiModelProperty("公司加班率")
    private double companyitOvertimeRate;

    @ApiModelProperty("IT板块加班率")
    private double itOvertimeRate;

    @ApiModelProperty("传统板块加班率")
    private double traditionOvertimeRate;

}
