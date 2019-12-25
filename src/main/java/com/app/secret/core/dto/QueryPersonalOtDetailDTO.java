package com.app.secret.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author crsu 2019/12/25
 */
@Data
public class QueryPersonalOtDetailDTO {
    @NotNull(message = "工作年份不能为空")
    @ApiModelProperty("工作年份")
    private Integer workYear;

    @NotNull(message = "工作月份不能为空")
    @ApiModelProperty("工作月份")
    private Integer workMonth;

    @NotNull(message = "工作月份不能为空")
    @ApiModelProperty(value = "工号")
    private String pcode;
}
