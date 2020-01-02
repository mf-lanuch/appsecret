package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/21 17:33
 */
@Data
public class PartOverTimeVO {

    @ApiModelProperty("部门Id")
    private String id;

    @ApiModelProperty("部门")
    private String partName;

    @ApiModelProperty("加班时长")
    private int talOverTime;

}
