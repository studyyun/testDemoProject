package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-07-12  11:35
 */
public class TestNull {

    public static void main(String[] args) {
//        Bean bean = new Bean();
//        System.out.println(Objects.equals(2, bean.getYear()));

        System.out.println(System.currentTimeMillis());
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

        List<String> list = new ArrayList<>();
        System.out.println(list.contains("qweqwe"));
    }

}

class Bean{

    private Integer year;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
