package com.app.secret.core.vo;

import com.app.secret.core.dto.OvertimeRateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/28 16:59
 */
@Data
public class OverTimeForAllVO {
    @ApiModelProperty("公司加班率")
    private OvertimeRateDto companyitOvertime;

    @ApiModelProperty("IT板块加班率")
    private OvertimeRateDto itOvertime;

    @ApiModelProperty("传统板块加班率")
    private OvertimeRateDto traditionOvertime;
}
