package com.app.secret.core.vo;

import com.app.secret.entity.AppRole;
import com.app.secret.entity.AppUsers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "用户-角色")
public class AppUserRoleVo extends AppUsers{

    @ApiModelProperty(value = "用户拥有的角色")
    private List<AppRole> roles;

    public List<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }
}
