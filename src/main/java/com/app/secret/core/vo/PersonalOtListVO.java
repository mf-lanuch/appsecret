package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/25 18:54
 */
@Data
public class PersonalOtListVO {

    @ApiModelProperty("姓名")
    private String pname;
    @ApiModelProperty("工号")
    private String pcode;
    @ApiModelProperty("工作年份")
    private Integer workYear;
    @ApiModelProperty("工作月份")
    private Integer workMonth;
    @ApiModelProperty("工作日期")
    private Date workDate;
    @ApiModelProperty("加班时长")
    private String talOverTime;

}
