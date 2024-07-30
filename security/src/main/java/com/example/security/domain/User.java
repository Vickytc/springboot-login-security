package com.example.security.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class User implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色集合
     */
    private Set<Role> roles;


}
