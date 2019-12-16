package com.app.secret.core.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.secret.core.base.annotation.IgnoreAccessToken;
import com.app.secret.core.util.StringUtil;
import com.app.secret.core.vo.AjaxResult;
import com.auth0.jwt.JWT;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.secret.core.constant.Constant;

import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        Class<?> c = method.getDeclaringClass();
        if(c.isAnnotationPresent(IgnoreAccessToken.class) || method.isAnnotationPresent(IgnoreAccessToken.class)) {
            return true;
        }
        String token = request.getHeader("token");
        if(StringUtil.isNull(token)) {
            throw  new RuntimeException("无token，请重新登录");
        }
        String userCode = JWT.decode(token).getAudience().get(0);
	    if(StringUtil.isNull(userCode)){
            AjaxResult ajax = new AjaxResult();
            ajax.setStatus(404);
            ajax.setMessage("用户名为空");
	        response.getOutputStream().print("");
	        return false;
        }
        //获取session
        HttpSession session = request.getSession(true);
	    session.setAttribute(Constant.USER_KEY, token);
	    return true;
    }
}
