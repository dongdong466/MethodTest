package com.dong1990.test;

import com.dong1990.utils.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AES_16_MD5_Test {
    public static void main(String[] args) {
        System.out.println("测试");
        System.out.println("这是一段伤心的往事");
        String content = "【东吴人寿】【东吴人寿】尊敬的{$var}{$var}，您好！" +
                "感谢您过去一年对东吴人寿VIP俱乐部的信任和支持！您的{$var}会籍期成功延续至{$var}。" +
                "详情请关注“东吴人寿微服务”微信公众号或详询****。" +
                "短信退订回Tfgfgfdgdfg嘎嘎嘎嘎嘎嘎灌灌灌灌灌嘎嘎嘎嘎嘎嘎灌灌灌灌灌嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎灌" +
                "灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌嘎嘎嘎嘎嘎嘎灌灌灌灌灌嘎嘎嘎嘎嘎嘎灌灌灌灌灌嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎" +
                "嘎嘎嘎嘎嘎灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌退订回T";

        byte[] encryptResult = MD5.encrypt(content, "12345678");
        // 转换成16进制
        String encryptResultStr = MD5.parseByte2HexStr(encryptResult);
        System.out.println("content加密后："+encryptResultStr);
        System.out.println("--------------------------------------------");


        byte[] decryptFrom = MD5.parseHexStr2Byte(encryptResultStr);
        // AES解密
        byte[] decryptResult = MD5.decrypt(decryptFrom, "12345678");
        System.out.println("--------------------------------------------");
        System.out.println("content解密后："+decryptResult.toString());

        try {
            String isoString = new String(decryptResult,"ISO-8859-1");
            String srt2=new String(decryptResult,"UTF-8");
            System.out.println("--------------------------------------------");
            //System.out.println("content解密后："+isoString);

            System.out.println("content解密后转UTF-8编码："+srt2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // MD5 加密的用法
        System.out.println(MD5_method("admin"+"ClAdmin168^&*"+"20180123161600"));
        System.out.println(MD5.getMd5("admin"+"ClAdmin168^&*"+"20180123161600"));

    }

    /**
     * MD5加密
     * @param decript
     * @return
     */
    public static String MD5_method(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

}
