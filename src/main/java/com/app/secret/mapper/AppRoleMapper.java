package com.app.secret.mapper;

import com.app.secret.entity.AppRole;
import com.app.secret.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppRoleMapper extends BaseMapper<AppRole>{

    List<AppRole> selectRolesByUserId(@Param("userId") String userId);
}

