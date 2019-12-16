package com.app.secret.core.util;

import com.app.secret.core.base.entity.BaseEntity;
import com.app.secret.core.constant.Constant;
import com.app.secret.entity.AppMenu;
import com.app.secret.entity.AppRole;
import com.app.secret.entity.AppUsers;
import com.app.secret.entity.TokenUsers;
import com.app.secret.services.AppMenuService;
import com.app.secret.services.AppRoleService;
import com.app.secret.services.AppUsersService;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class UsersUtil {

    @Value("${debug}")
    private String debug;

    @Autowired
    private HttpSession session;

    @Autowired
    private AppUsersService usersService;

    @Autowired
    private AppRoleService roleService;

    @Autowired
    private AppMenuService menuService;

    public TokenUsers getCurrentUser(){
        String token = (String)session.getAttribute(Constant.USER_KEY);
        return getCurrentUser(token);
    }

    public TokenUsers getCurrentUser(String token) {
        String userCode = JWT.decode(token).getAudience().get(0);
        if(debug.equals("true")) {
            userCode = "admin";
        }
        AppUsers users = usersService.loadAppUserByUserCode(userCode);
        return new TokenUsers(users.getUuid(), users.getUserName(), token);
    }

    public List<AppRole> getCurrentRole() {
        TokenUsers tokenUsers = getCurrentUser();
        return roleService.selectRolesByUserId(tokenUsers.getUuid());
    }


    public List<AppMenu> getCurrentMenu() {
        TokenUsers tokenUsers = getCurrentUser();
        List<AppRole> roles = getCurrentRole();
        return menuService.selectMenuByRoleId(roles);
    }

    public void setDocCreator(BaseEntity baseEntity) {
        TokenUsers tokenUsers = getCurrentUser();
        baseEntity.setDocCreateTime(DateUtil.getCurrentDatetime());
        baseEntity.setDocCreatorId(tokenUsers.getUuid());
        baseEntity.setDocCreatorName(tokenUsers.getUsername());
    }

    public void setDocAlteror(BaseEntity baseEntity) {
        TokenUsers tokenUsers = getCurrentUser();
        baseEntity.setDocAlterorTime(DateUtil.getCurrentDatetime());
        baseEntity.setDocAlterorId(tokenUsers.getUuid());
        baseEntity.setDocAlterorName(tokenUsers.getUsername());
    }


}
