package com.example.test;

import java.util.Optional;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-08-04  16:17
 */
public class TestOptional {

    public static void main(String[] args) {
        new TestOptional().test();
    }

    public void test() {
        String text = "1111";
//        String defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        String defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
//        System.out.println(defaultText);
    }


    public String getDefaultValue() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

}
