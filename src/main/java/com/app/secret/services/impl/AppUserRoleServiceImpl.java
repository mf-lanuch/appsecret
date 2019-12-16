package com.app.secret.services.impl;

import org.springframework.stereotype.Service;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.entity.AppUserRole;
import com.app.secret.mapper.AppUserRoleMapper;
import com.app.secret.services.AppUserRoleService;

@Service
public class AppUserRoleServiceImpl extends BaseServiceImpl<AppUserRole, AppUserRoleMapper> implements AppUserRoleService {

}

