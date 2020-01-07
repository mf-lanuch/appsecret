package com.app.secret.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author crsu 2019/12/25
 */
@Data
public class QueryPersonalOtDetailDTO extends BasePageQueryRequest {
    @NotNull
    @ApiModelProperty(value = "开始日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workStartDate;

    @NotNull
    @ApiModelProperty(value = "结束日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workEndDate;

    @NotNull(message = "工号不能为空")
    @ApiModelProperty(value = "工号")
    private String pcode;
}
