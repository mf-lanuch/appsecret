package com.app.secret.services;


import com.app.secret.core.base.service.BaseService;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.AppUserRoleVo;
import com.app.secret.entity.AppUsers;
import com.app.secret.entity.TokenUsers;

public interface AppUsersService extends BaseService<AppUsers>{

    TokenUsers loadUserByUserCode(String userCode);

    AppUsers loadAppUserByUserCode(String userCode);

    AjaxResult<AppUserRoleVo> addRolesByUserId(AppUserRoleVo user);
}

