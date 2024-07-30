package com.example.security.service.serviceImpl;

import com.example.security.domain.LoginUser;
import com.example.security.domain.Role;
import com.example.security.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordServiceImpl passwordService;

    @Resource
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.selectUserByUsername(username);
        passwordService.validate(user);
        //取出角色和权限信息
        Set<Role> roles = user.getRoles();

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new LoginUser(user,authorities);
    }

}
