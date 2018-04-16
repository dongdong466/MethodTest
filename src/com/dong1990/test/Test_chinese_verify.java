package com.dong1990.test;

public class Test_chinese_verify {
    public static void main(String[] args) {
        String str = "qwertyuiop123;是";
        System.out.println(str.getBytes().length);
        System.out.println(str.length());
        if(str.getBytes().length==str.length()){
            System.out.println("没有汉字");
        }else{
            System.out.println("有汉字");
        }
    }
}
