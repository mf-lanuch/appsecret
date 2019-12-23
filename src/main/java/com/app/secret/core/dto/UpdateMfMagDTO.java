package com.app.secret.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author crsu 2019/12/23
 */
@Data
public class UpdateMfMagDTO {
    @NotNull(message = "主键不能为空")
    @ApiModelProperty("主键")
    private java.lang.String id;

    @NotNull(message = "工作日类型不能为空")
    @ApiModelProperty("工作日类型：1工作日 2周末 3节假日")
    private java.lang.Integer workDateType;

    @NotNull(message = "倍率不能为空")
    @ApiModelProperty("倍率")
    private java.lang.Integer magValue;
}
