package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-24  17:40
 */
@Controller
public class TestOauth {


    @GetMapping("/oauth/authorize")
    public void getCode(String response_type, String client_id, String redirect_uri, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(redirect_uri + "?code=123456").forward(request, response);
    }

    @GetMapping("/oauth/token")
    public String getToken(String client_id, String client_secret, String grant_type, String code, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "!@$%@^@$^www";
    }

}
