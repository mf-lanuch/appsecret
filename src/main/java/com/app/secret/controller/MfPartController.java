package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.dto.GetPersonalOvertimeDTO;
import com.app.secret.core.request.PartOverTimeReq;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.PartOverTimeVO;
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

}
