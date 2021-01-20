package com.bairuitech.anychat.website.controller;

import com.bairuitech.anychat.website.security.JwtAuthenticatioToken;
import com.bairuitech.anychat.website.utils.SecurityUtils;
import com.bairuitech.anychat.website.vo.HttpResult;
import com.bairuitech.anychat.website.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录控制器
 * @author hazer
 * Created on 2021/1/21
 */
@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);

        return HttpResult.ok(token);
    }

}