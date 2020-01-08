package com.app.secret.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author crsu 2020/1/8
 */
@Data
public class QueryMfBreakOffDTO extends BasePageQueryRequest {
    @ApiModelProperty("姓名")
    private String pname;

    @ApiModelProperty(value = "工号")
    private String pcode;

    @ApiModelProperty("工作年份")
    private Integer workYear;

    @ApiModelProperty("工作月份")
    private Integer workMonth;

}
