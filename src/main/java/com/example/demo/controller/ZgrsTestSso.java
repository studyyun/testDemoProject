package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-08  14:37
 */
@Controller
public class ZgrsTestSso {

    @RequestMapping("/zgrs/sso")
    public String getToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("requestToken");
        response.setHeader("hello","hello222");
        response.sendRedirect("http://192.168.1.176:8888/getCode");
        return "";
    }

    @RequestMapping("/zgrs/destroy")
    public String destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("requestToken");
        response.setHeader("hello","hello222");
        response.sendRedirect("https://www.baidu.com/");
        return "";
    }

}
