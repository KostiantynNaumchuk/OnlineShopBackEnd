package com.myname.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_USER,ROLE_ADMIN,ROLE_SUPERUSER;


    @Override
    public String getAuthority() {
        return name();
    }
}
