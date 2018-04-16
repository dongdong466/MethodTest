package com.dong1990.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_Pattern {
    public static void main(String[] args) {
        String str = "16670306453";
        // 正则表达式规则
        String regEx = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        String regEx2 = "^\\d+$";
        String regEx3 = "^0(.[0-9]+)?$";
        String regEx4 = "^1[3456789]\\d{9}$";
        String regEx5 = "((13)|(15)|(16)|(19)|(18)|(14)|(17))\\d{9}";
        String regEx6 = "1\\d{2,10}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx4);
        Matcher matcher = pattern.matcher(str);
        boolean rs = matcher.matches();
        System.out.println(rs);
        //Pattern.compile(regEx).matcher(str);
    }
}
