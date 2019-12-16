package com.app.secret.services.impl;

import com.app.secret.core.BaseExceptionEnum;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.core.util.AjaxResultUtil;
import com.app.secret.core.util.TokenUtil;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.AppUserRoleVo;
import com.app.secret.entity.AppUserRole;
import com.app.secret.entity.AppUsers;
import com.app.secret.entity.TokenUsers;
import com.app.secret.mapper.AppUserRoleMapper;
import com.app.secret.mapper.AppUsersMapper;
import com.app.secret.services.AppUsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUsersServiceImpl extends BaseServiceImpl<AppUsers, AppUsersMapper> implements AppUsersService {

    @Autowired
    private AppUserRoleMapper userRoleMapper;

    @Override
    public TokenUsers loadUserByUserCode(String userCode) {
        AppUsers users = mapper.loadUserByUserCode(userCode);
        return TokenUtil.genderToken(users);
    }

    @Override
    public AppUsers loadAppUserByUserCode(String userCode) {
        return mapper.loadUserByUserCode(userCode);
    }

    @Override
    public AjaxResult<AppUserRoleVo> addRolesByUserId(AppUserRoleVo user) {
        if(StringUtils.isEmpty(user.getUuid())) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.USER_UUID_CAN_NOT_BE_NULL);
        }
//        if(null == user.getRoles() || user.getRoles().size() == 0) {
//            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.USER_UUID_CAN_NOT_BE_NULL);
//        }

        AppUserRole deleteRole = new AppUserRole();
        deleteRole.setUserId(user.getUuid());
        int flag = userRoleMapper.delete(deleteRole);
        if(flag == 0) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.DELETE_USER_ROLE_FAIL);
        }
        List<AppUserRole> roles = new ArrayList<>();
        if(null == user.getRoles() || user.getRoles().size() == 0) {
            return AjaxResultUtil.ok();
        }

        for(int i = 0; i < user.getRoles().size(); i ++) {
            AppUserRole role = new AppUserRole(user.getUuid(), user.getRoles().get(i).getUuid());
            roles.add(role);
        }
        flag =  userRoleMapper.saveRoles(roles);
        if(flag == 0) {
            return AjaxResultUtil.commomOutPut(BaseExceptionEnum.DELETE_USER_ROLE_FAIL);
        }
        return AjaxResultUtil.ok();
    }
}

