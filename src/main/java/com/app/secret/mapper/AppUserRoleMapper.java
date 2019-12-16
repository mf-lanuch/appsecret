package com.app.secret.mapper;

import com.app.secret.entity.AppUserRole;
import com.app.secret.core.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppUserRoleMapper extends BaseMapper<AppUserRole>{

    int saveRoles(@Param("userRoles") List<AppUserRole> userRoles);
}

