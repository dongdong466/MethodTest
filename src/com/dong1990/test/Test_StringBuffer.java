package com.dong1990.test;

import org.apache.commons.lang.StringUtils;

public class Test_StringBuffer {
    public static void main(String[] args) {
        StringBuffer_test();
        Test_gateway();
    }

    private static void Test_gateway() {
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
        }
        if(lt != "" && lt.length()>0){
            gateway_spcode=gateway_spcode+"L:"+lt;
        }
        if(dx != "" && dx.length()>0){
            gateway_spcode=gateway_spcode+"D:"+dx;
        }
        if(gateway_spcode.length()>0){
            gateway_spcode=gateway_spcode.substring(0, gateway_spcode.length()-1);
        }
        System.out.println(gateway_spcode);
    }

    private static void StringBuffer_test() {
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
}
