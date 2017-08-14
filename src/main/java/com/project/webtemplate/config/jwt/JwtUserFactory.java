package com.project.webtemplate.config.jwt;

import com.project.webtemplate.config.RoleEnum;
import com.project.webtemplate.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create (User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getPassword(), getUserRole(user.getRole()));
    }

    private static List<GrantedAuthority> getUserRole(RoleEnum role) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.name());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(simpleGrantedAuthority);
        return grantedAuthorityList;
    }
}
