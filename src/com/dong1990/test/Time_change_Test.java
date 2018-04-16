package com.dong1990.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time_change_Test {
    public static void main(String[] args) {
        String string = "2018-03-12 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf.parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------");

        Date date = new Date();
        System.out.println("当前时间date类型："+date);
        System.out.println("long型的当前时间毫秒数 ："+date.getTime());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        System.out.println("时间格式转换："+dateStr);
        Date dd = parseDate(dateStr, "yyyyMMddHHmm");
        System.out.println("当前时间毫秒数："+System.currentTimeMillis());
        System.out.println("当前时间格式时间转换"+new java.sql.Date(System.currentTimeMillis()));
        System.out.println("当前时间："+new Timestamp(System.currentTimeMillis()));
    }

    public static Date parseDate(String dateStr, String pattern) {
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            return formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
