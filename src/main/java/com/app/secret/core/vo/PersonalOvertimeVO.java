package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import lombok.Data;

/**
 * 个人加班时长信息
 *
 * @author crsu 2019/12/21
 */
@Data
public class PersonalOvertimeVO {
    @ApiModelProperty("姓名")
    private String pname;
    @ApiModelProperty("工号")
    private String pcode;
    @ApiModelProperty("加班时长")
    private int totalOverTime;
    @ApiModelProperty("总工作时长")
    private int totalWorkTime;
}
