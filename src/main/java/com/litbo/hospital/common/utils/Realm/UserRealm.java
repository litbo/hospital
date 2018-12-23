package com.litbo.hospital.common.utils.Realm;


import com.litbo.hospital.user.bean.SRight;
import com.litbo.hospital.user.bean.SRole;
import com.litbo.hospital.user.bean.SUser;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.service.RoleService;
import com.litbo.hospital.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm
{

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RightService rightService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        List<SRole> rolesByUsername = roleService.getRoleByUsername(username);
        for (SRole role : rolesByUsername) {
            roles.add(role.getRoleName());
            List<SRight> rightsByUsername = rightService.getRightsByRolename(role.getRoleName());
            for (SRight right : rightsByUsername) {
                info.addStringPermission(right.getRightName());
            }
        }


        info.setRoles(roles);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = token.getPrincipal().toString();
        SUser user = userService.getUserByUsername(username);

        if(user!=null){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getUserPwd(),getName());
            return authcInfo;
        }
        return  null;

    }
}
