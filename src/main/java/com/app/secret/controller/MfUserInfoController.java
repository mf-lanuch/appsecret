package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.services.MfUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mfUserInfo")
@Api(tags = "员工信息接口")
@IgnoreAccessToken
public class MfUserInfoController {

    @Autowired
    private MfUserInfoService mfUserInfoService;

    @ApiOperation(value = "获取员工个人加班时长")
    @RequestMapping(value = "/getPersonalOvertime", method = RequestMethod.POST)
    public AjaxResult<PersonaOvertimeVO> listReportPage(@RequestBody @Validated GetPersonalOvertimeDTO query) {
        return AjaxResult.success(mfUserInfoService.getPersonalOvertime(query));
    }

}
