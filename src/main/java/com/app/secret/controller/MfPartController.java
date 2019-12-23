package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.request.DeptOvertimeReq;
import com.app.secret.core.request.OvertimeRateReq;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.OverTimeRateVO;
import com.app.secret.core.vo.PartOverTimeVO;
import com.app.secret.core.vo.PeriodOverTimeVO;
import com.app.secret.core.vo.PersonaOvertimeVO;
import com.app.secret.services.MfPartService;
import com.app.secret.services.MfUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mfPart")
@Api(tags = "中心加班相关接口")
@IgnoreAccessToken
public class MfPartController {

    @Autowired
    private MfPartService mfPartService;

    @ApiOperation(value = "获取部门加班时长")
    @RequestMapping(value = "/getPartOvertime", method = RequestMethod.POST)
    public AjaxResult<List<PartOverTimeVO>> getPartOvertime(@RequestBody @Validated PartOverTimeReq partOverTimeReq) {
        AjaxResult<List<PartOverTimeVO>> res = new AjaxResult();
        List<PartOverTimeVO> resList = new ArrayList<>();
        try{
            resList = mfPartService.getPartOvertime(partOverTimeReq);
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

    @ApiOperation(value = "获取公司，传统板块，IT板块加班率")
    @RequestMapping(value = "/getOverTimeRate", method = RequestMethod.POST)
    public AjaxResult<OverTimeRateVO> getOverTimeRate(@RequestBody @Validated OvertimeRateReq overtimeRateReq) {
        AjaxResult<OverTimeRateVO> res = new AjaxResult();
        OverTimeRateVO overTimeRateVO = new OverTimeRateVO();
        try{
            overTimeRateVO = mfPartService.getOverTimeRate(overtimeRateReq);
            res.setStatus(200);
            res.setMessage("SUCCESS");
            res.setObject(overTimeRateVO);
            return res;
        }catch (Exception e){
            res.setStatus(-1);
            res.setMessage("数据库查询错误");
            return res;
        }
    }

    @ApiOperation(value = "获取部门当年每个月加班时长")
    @RequestMapping(value = "/getDeptOvertimeMonth", method = RequestMethod.POST)
    public AjaxResult<List<PartOverTimeVO>> getDeptOvertimeMonth(@RequestBody @Validated DeptOvertimeReq deptOvertimeReq) {
        AjaxResult<List<PartOverTimeVO>> res = new AjaxResult();
        List<PartOverTimeVO> resList = new ArrayList<>();
        try{
            resList = mfPartService.getDeptOvertimeMonth(deptOvertimeReq);
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

    @ApiOperation(value = "获取部门当年每个月加班时长及同期加班时长")
    @RequestMapping(value = "/getPeriodOvertime", method = RequestMethod.POST)
    public AjaxResult<List<PeriodOverTimeVO>> getPeriodOvertime(@RequestBody @Validated DeptOvertimeReq deptOvertimeReq) {
        AjaxResult<List<PeriodOverTimeVO>> res = new AjaxResult();
        List<PeriodOverTimeVO> resList = new ArrayList<>();
        try{
            resList = mfPartService.getPeriodOvertime(deptOvertimeReq);
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

}
