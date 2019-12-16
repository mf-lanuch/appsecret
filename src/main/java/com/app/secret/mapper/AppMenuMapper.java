package com.app.secret.mapper;

import com.app.secret.entity.AppMenu;
import com.app.secret.core.base.mapper.BaseMapper;
import com.app.secret.entity.AppRole;

import java.util.List;

public interface AppMenuMapper extends BaseMapper<AppMenu>{

   List<AppMenu> selectMenuByRoleId(List<AppRole> roles);
}

