package com.app.secret.services;


import com.app.secret.core.vo.AjaxResult;
import com.app.secret.entity.AppRoleMenu;

import com.app.secret.core.base.service.BaseService;

import java.util.List;

public interface AppRoleMenuService extends BaseService<AppRoleMenu>{

    AjaxResult<AppRoleMenu> saveRoleMenu(List<AppRoleMenu> records);
}

