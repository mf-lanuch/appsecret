package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.services.MfMagnificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mfMagnification")
@Api(tags = "非IT员工倍率接口")
@IgnoreAccessToken
public class MfMagnificationController {
    @Autowired
    private MfMagnificationService mfMagnificationService;

    @ApiOperation(value = "获取非IT员工倍率信息")
    @RequestMapping(value = "/listMfMagnification", method = RequestMethod.POST)
    public AjaxResult<List<MfMagnificationVO>> listReportPage() {
        return AjaxResult.success(mfMagnificationService.listMfMagnification());
    }
}
