package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class AdviseController {

    /*@ExceptionHandler(Exception.class)
    public ModelAndView testException(Exception e) {
        log.error("报错啦", e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("myerror");
        return mv;
    }*/

}
