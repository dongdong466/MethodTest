package com.dong1990.test;

import com.dong1990.utils.b;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class DES_BASE64_Test {

    public static void main(String[] args) throws Exception {
        String account = "CN3122117";
        String password = "7V684b3+Vn7Gte*";
        String s1 = DES_Base64_encode(account.getBytes(), "12345678".getBytes()).toString();
        String s2 = DES_Base64_encode(password.getBytes(), "12345678".getBytes()).toString();
        System.out.println("des加密base64编码后:");
        System.out.println(s1);
        System.out.println(s2);
        String s3 = decode("12345678",s1);
        String s4 = decode("12345678",s2);
        System.out.println("des解密base64解码后:");
        System.out.println(s3);
        System.out.println(s4);
    }

    private static String decode(String paramString1, String paramString2) throws Exception {
        byte[] ps = b.a(paramString2);
        byte[] bs = paramString1.getBytes();
        DESKeySpec dks = new DESKeySpec(bs);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        Key secretKey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
        AlgorithmParameterSpec paramSpec = iv;
        cipher.init(2, secretKey, paramSpec);
        return new String(cipher.doFinal(ps));
    }

    /**
     * DES加密  后 BASE64编码    DES:密钥12345678
     * @param content
     * @param keyBytes
     * @return
     */
    public static String DES_Base64_encode(byte[] content, byte[] keyBytes) {
        try {
            DESKeySpec keySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(keySpec.getKey()));
            byte[] result = cipher.doFinal(content);

            return new String(Base64.encodeBase64(result));
        } catch (Exception e) {
            System.out.println("exception:" + e.toString());
        }
        return null;
    }


}
