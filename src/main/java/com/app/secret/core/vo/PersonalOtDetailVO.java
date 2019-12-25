package com.app.secret.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 个人加班明细信息
 *
 * @author crsu 2019/12/25
 */
@Data
public class PersonalOtDetailVO {
    @ApiModelProperty("工号")
    private String pcode;

    @ApiModelProperty("姓名")
    private String pname;

    @ApiModelProperty("工作日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date workDate;

    @ApiModelProperty("加班开始时间")
    private java.util.Date otStartTime;

    @ApiModelProperty("上班刷卡")
    private java.util.Date startTime;

    @ApiModelProperty("下班刷卡（结束时间）")
    private java.util.Date endTime;

    @ApiModelProperty("加班时长（小时）")
    private String overTime;

}
