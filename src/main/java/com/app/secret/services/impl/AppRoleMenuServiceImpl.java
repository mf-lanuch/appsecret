package com.app.secret.services.impl;

import com.app.secret.core.util.AjaxResultUtil;
import com.app.secret.core.util.TokenUtil;
import com.app.secret.core.vo.AjaxResult;
import org.springframework.stereotype.Service;
import com.app.secret.core.base.serviceimpl.BaseServiceImpl;
import com.app.secret.entity.AppRoleMenu;
import com.app.secret.mapper.AppRoleMenuMapper;
import com.app.secret.services.AppRoleMenuService;

import java.util.List;

@Service
public class AppRoleMenuServiceImpl extends BaseServiceImpl<AppRoleMenu, AppRoleMenuMapper> implements AppRoleMenuService {

    @Override
    public AjaxResult<AppRoleMenu> saveRoleMenu(List<AppRoleMenu> records) {
        for (AppRoleMenu record: records) {
            record.setUuid(TokenUtil.genUUID());
        }
        int flag = mapper.saveRoleMenu(records);
        return AjaxResultUtil.successOrError(flag, "success", "save role menu error", null);
    }
}

