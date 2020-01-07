package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.services.MfBreakOffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value="/mfBreakOff")
@Api(tags = "调休信息接口")
@IgnoreAccessToken
public class MfBreakOffController {

    @Autowired
    private MfBreakOffService mfBreakOffService;

    @ApiOperation(value = "初始化12月份调休数据（调休时长为随机数，不大于可调休时长）")
    @RequestMapping(value = "/initMfBreakOff", method = RequestMethod.POST)
    public AjaxResult<String> initMfBreakOff() throws ParseException {
        mfBreakOffService.initMfBreakOff();
        return AjaxResult.success("Done");
    }

}
