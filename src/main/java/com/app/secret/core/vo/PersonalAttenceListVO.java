package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/23 20:25
 */
@Data
public class PersonalAttenceListVO {

    @ApiModelProperty("工号")
    private String pcode;
    @ApiModelProperty("姓名")
    private String pname;
    @ApiModelProperty("工作日期")
    private String workDate;
    @ApiModelProperty("考勤状态")
    private String workStatus;
    @ApiModelProperty("上班时间")
    private String startTime;
    @ApiModelProperty("下班时间")
    private String endTime;

}
