package com.app.secret.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.entity.AppDept;
import com.app.secret.services.AppDeptService;

@Controller
@RequestMapping(value="/appDept")
public class AppDeptController extends BaseController<AppDept, AppDeptService> {
	
}
