package com.app.secret.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.vo.AjaxResult;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/index")
@Api(tags = "demo测试")
@IgnoreAccessToken
public class LoginController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "success";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public AjaxResult<String> login(String userCode, String password, HttpServletResponse response) {
        return AjaxResult.success(null);
    }
}
