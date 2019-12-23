package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 倍率信息
 *
 * @author crsu 2019/12/21
 */
@Data
public class MfMagnificationVO {
    @ApiModelProperty("主键")
    private java.lang.String id;
    @ApiModelProperty("工作日类型：1工作日 2周末 3节假日")
    private java.lang.Integer workDateType;
    @ApiModelProperty("倍率")
    private java.lang.Integer magValue;
    @ApiModelProperty("更新时间")
    private java.util.Date updateTime;
}
