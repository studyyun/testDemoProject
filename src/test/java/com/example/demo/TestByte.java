package com.example.demo;

public class TestByte {

    public static void main(String[] args) {
        String a = "hello";
//        String a = "白雪";
        for (char c : a.toCharArray()) {
            System.out.println(Integer.toBinaryString(c));
        }
    }


}








