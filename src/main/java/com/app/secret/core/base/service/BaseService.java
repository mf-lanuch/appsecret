package com.app.secret.core.base.service;

import java.util.List;

import com.app.secret.core.base.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;

public interface BaseService<T extends BaseEntity>  {
	List<T> select(T entity);
	List<T> selectAll();
	T selectByPrimaryKey(String uuid);
	List<T> selectByExample(T entity);
	List<T> selectByExample(Example example);
	int selectCount(T entity);
	int selectCountByExample(T entity);
	int selectCountByExample(Example example);
	T selectOne(T entity);
	T selectOneByExample(T entity);
	int insert(T entity);
	int insertSelective(T entity);
	int updateByPrimaryKey(T entity);
	int updateByPrimaryKeySelective(T entity);
	int updateByExample(T entity);
	int updateByExample(T entity, Example example);
	int updateByExampleSelective(T entity);
	int updateByExampleSelective(T entity, Example example);
	int delete(T entity);
	int deleteByExample(T entity);
	int deleteByExample(Example example);
	int deleteByPrimaryKey(T entity);
	PageInfo<T> getQueryByPage(T entity, PageInfo<T> page);
}
