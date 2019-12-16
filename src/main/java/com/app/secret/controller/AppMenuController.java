package com.app.secret.controller;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.TreeDataSetVo;
import com.app.secret.entity.AppMenu;
import com.app.secret.services.AppMenuService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/appMenu")
@Api(tags = "菜单")
public class AppMenuController extends BaseController<AppMenu, AppMenuService> {

    public AjaxResult<TreeDataSetVo> getMenus(AppMenu record) {
        List<AppMenu> list = service.selectAll();
        return null;
    }
}
