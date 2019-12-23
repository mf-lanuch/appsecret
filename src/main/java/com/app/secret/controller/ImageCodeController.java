package com.app.secret.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.secret.core.util.ImageCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * Devil
 * 2019年12月23日
 */
@Controller
@RequestMapping(value = "/image")
@Api("图片操作")
public class ImageCodeController {

	@RequestMapping(value ="/getImageCode", method = RequestMethod.GET)
	@ApiOperation("获取图片验证码")
	public void getImageCode(HttpServletResponse response) throws IOException {
		ImageCode imageCode = new ImageCode(130, 48, 4);
		boolean writeSuccess = imageCode.out(response.getOutputStream());
		System.out.println(imageCode.text());
		System.out.println(writeSuccess);
	}
}
