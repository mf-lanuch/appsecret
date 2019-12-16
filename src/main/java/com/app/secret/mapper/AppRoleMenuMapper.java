package com.app.secret.mapper;

import com.app.secret.entity.AppRoleMenu;
import com.app.secret.core.base.mapper.BaseMapper;

import java.util.List;

public interface AppRoleMenuMapper extends BaseMapper<AppRoleMenu>{
	int saveRoleMenu(List<AppRoleMenu> records);
}

