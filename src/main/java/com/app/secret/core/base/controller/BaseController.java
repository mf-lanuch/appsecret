package com.app.secret.core.base.controller;

import java.util.List;
import java.util.UUID;

import com.app.secret.core.util.AjaxResultUtil;
import com.app.secret.core.util.UsersUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.secret.core.base.entity.BaseEntity;
import com.app.secret.core.base.service.BaseService;
import com.app.secret.core.vo.AjaxResult;
import com.github.pagehelper.PageInfo;

public class BaseController<T extends BaseEntity, S extends BaseService<T>> {

	@Autowired
	protected S service;

	@Autowired
	private UsersUtil usersUtil;
	
	@RequestMapping(value = "/insertSelective.do",method={RequestMethod.POST})
	@ResponseBody
	@ApiOperation(value = "新增")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public AjaxResult<T> insertSelective(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		BaseEntity baseEntity = (BaseEntity)record;
		baseEntity.setUuid(UUID.randomUUID().toString());
		usersUtil.setDocCreator(baseEntity);
		int flag = service.insertSelective(record);
		return AjaxResultUtil.successOrError(flag, "成功", "失败", service.selectByPrimaryKey(baseEntity.getUuid()));
	}
	
	@RequestMapping(value = "/selectOne.do",method={RequestMethod.POST})
	@ResponseBody
	@ApiOperation(value = "查询(单个)")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public T selectOne(@RequestBody T record){
		List<T> records = service.select(record);
		if(null == records || records.size() == 0 ){
			return null;
		}
		return records.get(0);
	}
	
	@RequestMapping(value = "/updateSelective.do",method={RequestMethod.POST})
	@ResponseBody
	@ApiOperation(value = "更新")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public AjaxResult<T> updateSelective(@RequestBody T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		usersUtil.setDocAlteror(record);
		int flag = service.updateByPrimaryKeySelective(record);
		return AjaxResultUtil.successOrError(flag, "成功", "失败", service.selectByPrimaryKey(record.getUuid()));
	}
	
	@RequestMapping(value = "/delete.do",method={RequestMethod.GET})
	@ResponseBody
	@ApiOperation(value = "删除")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public AjaxResult<T> delete(T record){
		AjaxResult<T> ajax = new AjaxResult<T>();
		int flag = service.deleteByPrimaryKey(record);
		return AjaxResultUtil.successOrError(flag, "成功", "失败", null);
	}
	
	@RequestMapping(value = "/getQueryByPage.do", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "分页数据")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public PageInfo<T> getQueryByPage(T record, PageInfo<T> page){
		return service.getQueryByPage(record, page);
	}

	@RequestMapping(value = "/getLists.do", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取List数据")
	@ApiImplicitParam(name = "token", value = "token", dataType = "String", paramType = "header", required = true)
	public List<T> getList(T record){
		return service.select(record);
	}

}
