package com.example.security.service.serviceImpl;

import com.example.security.domain.LoginUser;
import com.example.security.domain.Role;
import com.example.security.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl {

    public User selectUserByUsername(String username){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword("$2a$10$ErrO7WgkEBAWVQwuJtbBve7R2.pSKUrfs7zt8XkASqJKqcetMvAUC");
        Set<Role> roles = new HashSet<>();
        Role role1 = new Role(1L, "ROLE_ADMIN");
        Role role2 = new Role(2L, "ROLE_USER");
        roles.add(role1);
        roles.add(role2);
        user.setRoles(roles);
        return user;
    }
}
