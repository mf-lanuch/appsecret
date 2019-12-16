package com.app.secret.controller;

import com.app.secret.core.vo.AjaxResult;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.entity.AppRole;
import com.app.secret.services.AppRoleService;

import java.util.List;

@RestController
@RequestMapping(value="/appRole")
@Api(tags = "角色")
public class AppRoleController extends BaseController<AppRole, AppRoleService> {

}
