package com.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-20  14:17
 */
public class TestLong {

    private Map<Short, String> alphabetMap = new HashMap<>();

    {
        //初始化26个大写的英文字母
        for (short i = 0; i < 26; i++) {
            //65是大写字母A的ASCII码值
            alphabetMap.put(i, (char) (65 + i) + "");
        }
    }
    
    public static void main(String[] args) {
        TestLong aLong = new TestLong();
        String s = aLong.alphabetMap.get((short)3);

        short res = (short) ((3 << 10) | (2 << 5) | 4);

        /*System.out.println(Long.parseLong("+456132135"));
        System.out.println(Long.parseLong("0013548546464"));*/
        char c = (char) 13548546666L;
        int ccc = c;
        System.out.println(c);
        System.out.println(ccc);
        System.out.println(Integer.toBinaryString(ccc));
        String binaryString = Long.toBinaryString(13548546666L);
        System.out.println(binaryString.substring(binaryString.length()-15));
        System.out.println(binaryString);
        
        int j = 0;
        for (int i = 0; i < 10000; i++) {
            j++;
        }
        System.out.println(j);
        j = 0;
        System.out.println(j);
    }
}
