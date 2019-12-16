package com.app.secret.core.util;

import com.app.secret.core.BaseExceptionEnum;
import com.app.secret.core.base.entity.BaseEntity;
import com.app.secret.core.vo.AjaxResult;

import java.util.List;

public class AjaxResultUtil {

    public static AjaxResult fail(String  msg) {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(500);
        ajax.setMessage(msg);
        return ajax;
    }

    public static <T> AjaxResult ok(String  msg, List<T> t) {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(200);
        ajax.setMessage(msg);
        ajax.setResult(t);
        return ajax;
    }

    public static AjaxResult ok() {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(200);
        return ajax;
    }

    public static AjaxResult ok(String  msg) {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(200);
        ajax.setMessage(msg);
        return ajax;
    }

    public static <T> AjaxResult ok(String  msg, T t) {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(200);
        ajax.setMessage(msg);
        ajax.setObject(t);
        return ajax;
    }

    public static AjaxResult successOrError(int flag, String success, String error, BaseEntity entity) {
        if(flag == 0) {
            return ok(success, entity);
        } else {
            return fail(error);
        }
    }

    public static AjaxResult commomOutPut(BaseExceptionEnum enums) {
        AjaxResult ajax = new AjaxResult();
        ajax.setStatus(enums.getCode());
        ajax.setMessage(enums.getMsg());
        return ajax;
    }
}
