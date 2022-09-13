package com.example.test;

import cn.hutool.core.util.CharsetUtil;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-04-29  17:55
 */
public class TestBase64 {

    public static void main(String[] args) {
        try {
            System.out.println(new String(
                    Base64.getDecoder().decode("eFBxMXhOSHAxcVRDNjhySGUzdHVkVzB1UkVGVVFYMTlMRFczMXRiVHhOclQwTkNubzZ6SDY4N3cwTG5DdGc9PQ==")
                    , "GB18030")
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        System.out.println(Base64.getEncoder().encode("http://192.169.2.79:9090/emp_files/file/mms/templates/100001/3_2_20220427100409.tms".getBytes()));
    }
    
}
