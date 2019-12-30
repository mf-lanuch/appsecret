package com.app.secret.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/30 19:10
 */
@Data
public class GetPersonalOvertimeNewDTO {

    @ApiModelProperty(value = "开始日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workStartDate;

    @ApiModelProperty(value = "结束日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workEndDate;

    @ApiModelProperty(value = "工号")
    @NotBlank(message = "工号不能为空")
    private String pcode;

}
