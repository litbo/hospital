package com.litbo.hospital.common.utils;

import java.util.List;
import java.util.ArrayList;


public class StringCutUtils {

    public static List<String> stringToList(String s){
        List<String> result = new ArrayList<>();
        s = s.trim();
        int index = 0 ;
        while (true){
            String subs = s.substring(index*2,(index+1)*2);
            int subInt = Integer.parseInt(subs,16);
            result.add(subs);
            if((index+1)*2>=s.length()){
                break;
            }
            index++;
        }
        return result;
    }


    public static List<Integer> stringToIntList(String s){
        List<Integer> result = new ArrayList<>();
        s = s.trim();
        int index = 0 ;
        while (true){
            String subs = s.substring(index*2,(index+1)*2);
            int subInt = Integer.parseInt(subs,16);    // 每两位切割转化为16进制添加到数组
            result.add(subInt);
            if((index+1)*2>=s.length()){
                break;
            }
            index++;
        }
        return result;
    }

    public static Integer getCeng_id(String bm_id){
        List<String> idcuts = StringCutUtils.stringToList(bm_id);
        for(int i=idcuts.size()-1;i>0;i--){
            if(idcuts.get(i)!="00") ;
            return Integer.parseInt(idcuts.get(i));
        }
        return 0;
    }


    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
}
