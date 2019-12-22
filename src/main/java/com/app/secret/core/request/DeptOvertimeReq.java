package com.app.secret.core.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/22 16:38
 */
@Data
public class DeptOvertimeReq {

    @NotBlank(message = "工号不能为空")
    @ApiModelProperty(value = "部门Id")
    private String partId;

    @NotNull(message = "年份不能为空")
    @ApiModelProperty(value = "开始年份")
    private int workYearStart;

    @NotNull(message = "年份不能为空")
    @ApiModelProperty(value = "结束年份")
    private int workYearEnd;

    @NotNull(message = "月份不能为空")
    @ApiModelProperty(value = "开始月份")
    private int workMonthStart;

    @NotNull(message = "月份不能为空")
    @ApiModelProperty(value = "结束月份")
    private int workMonthEnd;
}
