package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.domain.PageResult;
import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.dto.GetPersonalOvertimeNewDTO;
import com.app.secret.core.dto.QueryOverTimeListDTO;
import com.app.secret.core.dto.QueryPersonalOtDetailDTO;
import com.app.secret.core.request.PersonalAttenceReq;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.PersonalOtDetailVO;
import com.app.secret.core.vo.PersonalOtResVO;
import com.app.secret.core.vo.PersonalOvertimeVO;
import com.app.secret.core.vo.PersonalAttenceListVO;
import com.app.secret.services.MfUserInfoService;
import com.app.secret.services.MfWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MfWorkService mfWorkService;

    @ApiOperation(value = "获取员工个人加班时长")
    @RequestMapping(value = "/getPersonalOvertime", method = RequestMethod.POST)
    public AjaxResult<PersonalOvertimeVO> listReportPage(@RequestBody @Validated GetPersonalOvertimeNewDTO query) {
        return AjaxResult.success(mfUserInfoService.getPersonalOvertime(query));
    }

    @ApiOperation(value = "获取员工考勤明细")
    @RequestMapping(value = "/getPersonalAttenceList", method = RequestMethod.POST)
    public AjaxResult<PageResult<PersonalAttenceListVO>> getPersonalAttenceList(@RequestBody @Validated PersonalAttenceReq personalAttenceReq) {
        AjaxResult<PageResult<PersonalAttenceListVO>> res = new AjaxResult();
        PageResult<PersonalAttenceListVO> resList;
        try{
            resList = mfUserInfoService.getPersonalAttenceList(personalAttenceReq);
            res.setStatus(200);
            res.setMessage("SUCCESS");
            res.setObject(resList);
            return res;
        }catch (Exception e){
            res.setStatus(-1);
            res.setMessage("数据库查询错误");
            return res;
        }
    }

    @ApiOperation(value = "获取员工的加班统计列表")
    @RequestMapping(value = "/listPersonaOvertime", method = RequestMethod.POST)
    public AjaxResult<PageResult<PersonalOvertimeVO>> listPersonaOvertime(@RequestBody @Validated QueryOverTimeListDTO dto) {
        return AjaxResult.success(mfUserInfoService.listPersonaOvertime(dto));
    }

    @ApiOperation(value = "获取员工的加班明细列表")
    @RequestMapping(value = "/listPersonalOtDetail", method = RequestMethod.POST)
    public AjaxResult<PageResult<PersonalOtDetailVO>> listPersonalOtDetail(@RequestBody @Validated QueryPersonalOtDetailDTO dto) {
        return AjaxResult.success(mfWorkService.listPersonalOtDetail(dto));
    }
}
