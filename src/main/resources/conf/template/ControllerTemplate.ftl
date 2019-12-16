package com.${packageName}.${modelName}.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.secret.core.base.controller.BaseController;
import com.${packageName}.${modelName}.entity.${className};
import com.${packageName}.${modelName}.services.${className}Service;

@Controller
@RequestMapping(value="/${lowerName}")
public class ${className}Controller extends BaseController<${className}, ${className}Service> {
	
}
