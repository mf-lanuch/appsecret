package com.app.secret.core.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author fanbangnian
 * @date 2019/12/25 18:56
 */
@Data
public class PersonalOtResVO {

    @ApiModelProperty("时间段内的加班总时长")
    private PersonalOvertimeVO personalOvertimeVO;

    @ApiModelProperty("时间段内各日期加班时间")
    private List<PersonalOtListVO> personalOtListVOS;

}
