package com.app.secret.core.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/23 19:52
 */
@Data
public class PersonalAttenceReq {

    @ApiModelProperty(value = "工号")
    @NotBlank(message = "工号不能为空")
    private String pcode;

    @NotNull(message = "日期不能为空")
    @ApiModelProperty(value = "开始日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workStartDate;

    @NotNull(message = "日期不能为空")
    @ApiModelProperty(value = "结束日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workEndDate;


}
