package com.app.secret.controller;

import com.app.secret.core.vo.AjaxResult;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.entity.AppRoleMenu;
import com.app.secret.services.AppRoleMenuService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/appRoleMenu")
@Api(tags = "角色-菜单")
public class AppRoleMenuController extends BaseController<AppRoleMenu, AppRoleMenuService> {

    @PostMapping(value = "/saveRoleMenu")
    public AjaxResult<AppRoleMenu> saveRoleMenu(List<AppRoleMenu> records) {
        return service.saveRoleMenu(records);
    }
}
