package com.example.security.service.serviceImpl;

import com.example.security.context.AuthenticationContextHolder;
import com.example.security.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import sun.misc.MessageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PasswordServiceImpl {

    public void validate(User user)
    {
        Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder.getContext();
        String AuthUsername = usernamePasswordAuthenticationToken.getName();
        String AuthPassword = usernamePasswordAuthenticationToken.getCredentials().toString();

        if (matches(user, AuthPassword)) {
            System.out.println("验证成功！");
        } else {
            System.out.println("验证失败！");
        }
    }

    public boolean matches(User user, String rawPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
