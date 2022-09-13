package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-01-06  11:56
 */
public class TestList {

    public static void main(String[] args) {
//        System.out.println(new TestList().assemBlyYearTable(20211101, 20211122));
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        Matcher matcher = pattern.matcher("++1354854777");
        System.out.println(matcher.find());
        int i = 0;
        i = i++;
        System.out.println(i);
    }

    private String assemBlyYearTable(int begin, int end) {
        List<String> list = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            list.add("RMS_MT_RVOK" + i);
        }
        //遍历组装年表
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(" select count(*) from ( ");
        for (int i = 0; i < list.size(); i++) {
            strBuilder.append(" SELECT * FROM ");
            strBuilder.append(list.get(i));
            //最后不加union all
            if (i == list.size() - 1) {
                break;
            }
            strBuilder.append(" UNION ALL ");
        }
        strBuilder.append(" ) ");
        return strBuilder.toString();
    }
    
}
