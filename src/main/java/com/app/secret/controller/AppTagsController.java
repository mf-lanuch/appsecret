package com.app.secret.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.secret.core.base.controller.BaseController;
import com.app.secret.entity.AppTags;
import com.app.secret.services.AppTagsService;

@Controller
@RequestMapping(value="/appTags")
@Api(tags = "标签")
public class AppTagsController extends BaseController<AppTags, AppTagsService> {
	
}
