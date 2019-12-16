package com.app.secret.mapper;

import com.app.secret.entity.AppUsers;
import com.app.secret.core.base.mapper.BaseMapper;

public interface AppUsersMapper extends BaseMapper<AppUsers>{

    AppUsers loadUserByUserCode(String userCode);
	
}

