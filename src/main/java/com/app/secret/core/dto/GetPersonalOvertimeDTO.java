package com.app.secret.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author crsu 2019/12/21
 */
@Data
public class GetPersonalOvertimeDTO {
    @NotNull(message = "workYearStart不能为空")
    @ApiModelProperty("起始日期_工作年份")
    private Integer workYearStart;

    @NotNull(message = "workMonthStart不能为空")
    @ApiModelProperty("起始日期_工作月份")
    private Integer workMonthStart;

    @NotNull(message = "workYearEnd不能为空")
    @ApiModelProperty("终止日期_工作年份")
    private Integer workYearEnd;

    @NotNull(message = "workMonthEnd不能为空")
    @ApiModelProperty("终止日期_工作月份")
    private Integer workMonthEnd;

    @ApiModelProperty(value = "工号")
    @NotBlank(message = "工号不能为空")
    private String pcode;
}
