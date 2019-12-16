package com.app.secret.services;


import com.app.secret.core.vo.AjaxResult;
import com.app.secret.entity.AppMenu;

import com.app.secret.core.base.service.BaseService;
import com.app.secret.entity.AppRole;

import java.util.List;

public interface AppMenuService extends BaseService<AppMenu>{

    List<AppMenu> selectMenuByRoleId(List<AppRole> roles);

}

