package com.example.demo.controller;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-09  10:34
 */
@Controller
public class RedirectTest {

    @RequestMapping("/redirect/test")
    public String testRedirect(HttpSession session, RedirectAttributes attr){
        session.setAttribute("userName","zsy");
        attr.addAttribute("food","apple");
        attr.addFlashAttribute("userNameTwo","admin");
        return "/index.html";
    }

    @RequestMapping("/heihei")
    public String heihei(HttpSession session,RedirectAttributes attr){
        Object userName = session.getAttribute("userName");
        System.out.println(userName);
        Map<String, ?> flashAttributes = attr.getFlashAttributes();
        Object name = flashAttributes.get("userName");
        System.out.println(name);
        return null;
    }

}
