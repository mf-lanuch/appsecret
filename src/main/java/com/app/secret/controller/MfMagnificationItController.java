package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.dto.UpdateMfMagDTO;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.MfMagnificationVO;
import com.app.secret.entity.MfMagnificationIt;
import com.app.secret.services.MfMagnificationItService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/mfMagnificationIt")
@Api(tags = "IT员工倍率接口")
@IgnoreAccessToken
public class MfMagnificationItController {

    @Autowired
    private MfMagnificationItService mfMagnificationItService;

    @ApiOperation(value = "获取IT员工倍率信息")
    @RequestMapping(value = "/listMfMagnificationIt", method = RequestMethod.POST)
    public AjaxResult<List<MfMagnificationVO>> listReportPage() {
        return AjaxResult.success(mfMagnificationItService.listMfMagnificationIt());
    }

    @ApiOperation(value = "修改非IT员工倍率信息")
    @RequestMapping(value = "/updateMfMagnification", method = RequestMethod.POST)
    public AjaxResult<MfMagnificationIt> updateMfMagnification(@RequestBody UpdateMfMagDTO dto) {
        return AjaxResult.success(mfMagnificationItService.updateMfMagnificationIt(dto));
    }
}
