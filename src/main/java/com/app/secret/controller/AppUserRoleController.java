package com.app.secret.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.entity.AppUserRole;
import com.app.secret.services.AppUserRoleService;

@Controller
@RequestMapping(value="/appUserRole")
@Api(tags = "用户-角色")
public class AppUserRoleController extends BaseController<AppUserRole, AppUserRoleService> {
	
}
