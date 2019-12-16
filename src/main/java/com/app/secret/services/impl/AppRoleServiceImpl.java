package com.app.secret.services.impl;

import com.app.secret.core.util.AjaxResultUtil;
import com.app.secret.core.util.TokenUtil;
import com.app.secret.core.util.UsersUtil;
import com.app.secret.core.vo.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.entity.AppRole;
import com.app.secret.mapper.AppRoleMapper;
import com.app.secret.services.AppRoleService;

import java.util.List;

@Service
public class AppRoleServiceImpl extends BaseServiceImpl<AppRole, AppRoleMapper> implements AppRoleService {

    @Autowired
    private UsersUtil usersUtil;

    @Override
    public List<AppRole> selectRolesByUserId(String userId){
        return mapper.selectRolesByUserId(userId);
    }
}

