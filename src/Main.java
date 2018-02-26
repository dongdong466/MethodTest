

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.trim;

public class Main {

    public static void main(String[] args) {
        /*String account = DES_Base64_encode("N520520".getBytes(),"1234567890".getBytes()).toString();
        String ac_password = DES_Base64_encode("N521521521".getBytes(),"1234567890".getBytes()).toString();
        System.out.println(account+" : "+ac_password);*/
        //String ac_password = DES_Base64_encode("a.123456".getBytes(),"1234567890".getBytes()).toString();
        //System.out.println(" : "+ac_password);

        //Test_StringBuffer();
        //Test_Pattern();
        /*Float num1;

        String qq = "19.987";

        num1 = Float.valueOf(qq.toString());
        System.out.println(num1);*/

        //System.out.println(MD5("admin"+"ClAdmin168^&*"+"20180123161600"));

        // C:\Users\XS-021\Downloads\tunnelSignature.xls


        //Test_file_reader();
        String str = "qwertyuiop123;是";
        System.out.println(str.getBytes().length);
        System.out.println(str.length());
        if(str.getBytes().length==str.length()){
            System.out.println("没有汉字");
        }else{
            System.out.println("有汉字");
        }

    }

    private static  void Test_file_reader(){
        String pathString = "c:"+File.separator+"Users"+File.separator+"XS-021"+
                File.separator+"Downloads"+File.separator+"tunnelSignature.txt";
        File file = new File(pathString);
        BufferedReader reder = null;
        try{
            reder = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String string = null;
            while ((string = reder.readLine()) != null) {
                System.out.println(string);
            }
        }catch(Exception e){

        }
    }

    private static  void Test_file(){
        String pathString = "c:"+File.separator+"Users"+File.separator+"XS-021"+
                File.separator+"Downloads"+File.separator+"tunnelSignatures.txt";
        File file = new File(pathString);
        try {
            FileInputStream fi = new FileInputStream(file);
            HSSFWorkbook book = new HSSFWorkbook(fi);
            //HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File("C:/Users/XS-021/Downloads/tunnelSignature.xls")));
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Test_gateway(){
        String spCode = "gateway:1-spcode:0401,gateway:2-spcode:12512141311," +
                "gateway:2-spcode:123123123,gateway:1-spcode:12512141311,gateway:1-spcode:1111";

        String[] s;
        StringBuilder sbyd = new StringBuilder();
        StringBuilder sblt = new StringBuilder();
        StringBuilder sbdx = new StringBuilder();
        s=spCode.split(",");
        String yd="";
        String lt="";
        String dx="";
        for (int i = 0; i < s.length; i++) {
            //s[i]=s[i].replaceAll("gateway:,", "");
            s[i]=s[i].replaceAll("spcode:", ",");
            s[i]=s[i].replaceAll("gateway:1-", "Y");
            s[i]=s[i].replaceAll("gateway:2-", "L");
            s[i]=s[i].replaceAll("gateway:3-", "D");

            if(s[i].startsWith("Y")){
                sbyd.append(s[i].substring(2, s[i].length()) +",");
            }
            yd=sbyd+"";
            //System.out.println(sbyd+"");
            //System.out.println("sss "+new StringBuilder(yd).append(sbyd).toString());
            if(s[i].startsWith("L")){
                sblt.append(s[i].substring(2, s[i].length()) +",");
            }
            lt=sblt+"";
            if(s[i].startsWith("D")){
                sbdx.append(s[i].substring(2, s[i].length()) +",");
            }
            dx=sbdx+"";
        }
        String gateway_spcode="";
        if(yd != "" && yd.length()>0){
            gateway_spcode=gateway_spcode+"Y:"+yd;
        }if(lt != "" && lt.length()>0){
            gateway_spcode=gateway_spcode+"L:"+lt;
        }if(dx != "" && dx.length()>0){
            gateway_spcode=gateway_spcode+"D:"+dx;
        }if(gateway_spcode.length()>0){
            gateway_spcode=gateway_spcode.substring(0, gateway_spcode.length()-1);
        }
        System.out.println(gateway_spcode);
    }
    private static void Test_Pattern(){
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
    private static void Test_StringBuffer(){
        String name = "gateway:1-name:李芳180通道产品,gateway:1-name:新产品-行业泰逗," +
                "gateway:3-name:李芳180通道产品,gateway:2-name:李芳180通道产品";
        StringBuilder sbyd=new StringBuilder();
        StringBuilder sblt=new StringBuilder();
        StringBuilder sbdx=new StringBuilder();
        String[] stringArray;
        stringArray = name.split(",");
        String YD_product = "";
        String LT_product = "";
        String DX_product = "";
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = stringArray[i].replaceAll("gateway:1-name","Y");
            stringArray[i] = stringArray[i].replaceAll("gateway:2-name","L");
            stringArray[i] = stringArray[i].replaceAll("gateway:3-name","D");
            if(stringArray[i].startsWith("Y")){
                sbyd.append(stringArray[i].substring(2,stringArray[i].length())+",");
            }
            YD_product = new StringBuilder(YD_product).append(sbyd).toString();
            if(stringArray[i].startsWith("L")){
                sblt.append(stringArray[i].substring(2,stringArray[i].length())+",");
            }
            LT_product = new StringBuilder(LT_product).append(sblt).toString();
            if(stringArray[i].startsWith("D")){
                sbdx.append(stringArray[i].substring(2,stringArray[i].length())+",");
            }
            DX_product = new StringBuilder(DX_product).append(sbdx).toString();
        }
        String name2 = "";
        if(StringUtils.isNotBlank(YD_product)){
            name2 = new StringBuilder(name2).append(new StringBuilder("移动通道产品:")).append(sbyd).toString();
        }
        if(StringUtils.isNotBlank(LT_product)){
            name2 = new StringBuilder(name2).append(new StringBuilder("联通通道产品:")).append(sblt).toString();
        }
        if(StringUtils.isNotBlank(YD_product)){
            name2 = new StringBuilder(name2).append(new StringBuilder("电信通道产品:")).append(sbdx).toString();
        }
        if(StringUtils.isNotBlank(name2)){
            name2 = name2.substring(0,name2.length() - 1);
        }
        sbyd.delete(0, sbyd.length());
        sblt.delete(0, sblt.length());
        sbdx.delete(0, sbdx.length());
        System.out.println(name2);
        name2 = name2.replace(",联通",";联通");
        name2 = name2.replace(",电信",";电信");
        System.out.println("-------------------------");
        System.out.println(name2);
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

    /**
     * MD5加密
     * @param decript
     * @return
     */
    public static String MD5(String decript) {
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
 class test {
    private String string;

     public String getString() {
         return string;
     }

     public void setString(String string) {
         this.string = string;
     }
 }