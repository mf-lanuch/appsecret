package com.app.secret.controller;

import com.app.secret.core.BaseExceptionEnum;
import com.app.secret.core.base.controller.BaseController;
import com.app.secret.core.util.AjaxResultUtil;
import com.app.secret.core.util.TokenUtil;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.AppUserRoleVo;
import com.app.secret.entity.AppUsers;
import com.app.secret.services.AppUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/appUsers")
@Api(tags = "用户")
public class AppUsersController extends BaseController<AppUsers, AppUsersService> {

    @RequestMapping(value = "/saveUsers", method = {RequestMethod.POST})
    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
    public AjaxResult<AppUsers> saveUsers(@RequestBody  AppUsers users) {
        if(StringUtils.isEmpty(users.getUserName())) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.USER_NAME_CAN_NOT_BE_NULL);
        }
        if(StringUtils.isEmpty(users.getUserCode())) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.USER_NAME_CAN_NOT_BE_NULL);
        }
        if(StringUtils.isEmpty(users.getUserPswd())) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.USER_PSWD_CAN_NOT_BE_NULL);
        }
        users.setUuid(TokenUtil.genUUID());
        users.setUserPswd(TokenUtil.getMD5(users.getUserPswd()));
        int flag = service.insertSelective(users);
        return AjaxResultUtil.successOrError(flag, "success", "error", users);
    }

    @RequestMapping(value = "/saveUsers", method = {RequestMethod.POST})
    @ApiOperation(value = "新增用户角色")
    @ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
    public AjaxResult<AppUserRoleVo> addRolesByUserId(@RequestBody AppUserRoleVo user) {
        return service.addRolesByUserId(user);
    }
}
