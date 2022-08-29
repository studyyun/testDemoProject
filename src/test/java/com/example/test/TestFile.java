package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-03  10:48
 */
@Slf4j
public class TestFile {

    public static void main(String[] args) throws JSONException {
        File file = new File("filetest.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (int i = 0; i < 100_0000; i++) {
                /*String k = 13500000000L + i +"";
                fileOutputStream.write(("set "+ k + " 1" + "\r\n").getBytes());*/
                String k = 13500000000L + i +"";
                fileOutputStream.write(("sadd phone " + k + "\r\n").getBytes());

            }
        } catch (Exception e){
            System.out.println(e);
        }

        /*JSONObject jsonObject = null;
        String aaa = jsonObject.getString("aaa");
        System.out.println(aaa);*/

//        String b = "dasda";
//        System.out.println(b.substring(1,1));
//        test();
    }

    public static void test(){
        Throwable var3 = null;

        try {
            int i = 2/0;
        } catch (Throwable var13) {
            var3 = var13;
            throw var13;
        } finally {
            if (var3 != null) {
                try {
                    int i = 3/0;
                } catch (Throwable var12) {
                    var3.addSuppressed(var12);
//                    throw var12;
                }
            } else {
                System.out.println(231231);
            }
        }
    }

}
