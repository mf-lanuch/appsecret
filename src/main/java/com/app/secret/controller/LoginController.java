package com.app.secret.controller;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.vo.AjaxResult;
import com.app.secret.entity.TokenUsers;
import com.app.secret.services.AppUsersService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/index")
@Api(tags = "demo测试")
@IgnoreAccessToken
public class LoginController {

    @Autowired
    private AppUsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "success";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public AjaxResult<TokenUsers> login(String userCode, String password, HttpServletResponse response) {
        TokenUsers users = usersService.loadUserByUserCode(userCode);
        Cookie cookie = new Cookie("token", users.getToken());
        response.addCookie(cookie);
        cookie.setPath("/");
        return AjaxResult.success(users);
    }
}
