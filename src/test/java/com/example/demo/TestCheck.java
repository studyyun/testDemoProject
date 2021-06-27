package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TestCheck {


    //密码不得包含键盘上任意连续的四个字符或shift转换字符
    public static boolean validateKey(String str) {

        //定义横向穷举
        String[][] keyCode = {
                {"`~·", "1!！", "2@@", "3#", "4$￥", "5%", "6^……", "7&", "8*", "9(（", "0）)", "-_", "=+"},
                {" ","qQ", "wW", "eE", "rR", "tT", "yY", "uU", "iI", "oO", "pP", "[{【", "]}】", "\\|、"},
                {" ","aA", "sS", "dD", "fF", "gG", "hH", "jJ", "kK", "lL", ";:", "\'\"’“"},
                {" ","zZ", "xX", "cC", "vV", "bB", "nN", "mM", ",《<", ".>》", "/?？"}
        };

        //找出给出的字符串，每个字符，在坐标系中的位置。
        char[] c = str.toCharArray();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            toHere:
            for (int j = 0; j < keyCode.length; j++) {
                for (int k = 0; k < keyCode[j].length; k++) {
                    String jk = keyCode[j][k];
                    if (jk.contains(String.valueOf(temp))) {
                        x.add(j);
                        y.add(k);
                        break toHere;
                    }
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < x.size() - 3; i++) {
            // 如果X一致，那么就是在一排
            if (x.get(i) == x.get(i + 1) && x.get(i + 1) == x.get(i + 2) && x.get(i + 2) == x.get(i + 3)) {//四者在同一行上
                if (y.get(i) > y.get(i + 3)) {
                    if (y.get(i) - 1 == y.get(i + 1) && y.get(i) - 2 == y.get(i + 2) && y.get(i) - 3 == y.get(i + 3)) {
                        flag = true;
                        break;
                    }
                } else {
                    if (y.get(i) + 1 == y.get(i + 1) && y.get(i) + 2 == y.get(i + 2) && y.get(i) + 3 == y.get(i + 3)) {
                        flag = true;
                        break;
                    }
                }

            } else if (x.get(i) != x.get(i + 1)
                    && x.get(i + 1) != x.get(i + 2)
                    && x.get(i) != x.get(i + 2)
                    && x.get(i) != x.get(i + 3)
                    && x.get(i + 1) != x.get(i + 3)
                    && x.get(i + 2) != x.get(i + 3)
            ) {//四者均不在同一行上,但是如果y相同，说明是一列
                if (y.get(i) == y.get(i + 1) && y.get(i + 1) == y.get(i + 2) && y.get(i+ 2)  == y.get(i + 3)) {
                    flag = true;
                    break;
                }
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(validateKey("1@#$"));
    }
}
