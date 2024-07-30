package com.example.security.service.serviceImpl;

import com.example.security.context.AuthenticationContextHolder;
import com.example.security.domain.LoginUser;
//import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;
@Service
public class LoginServiceImpl {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    public String login(String username, String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        AuthenticationContextHolder.setContext(authenticationToken);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        AuthenticationContextHolder.clearContext();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

}
