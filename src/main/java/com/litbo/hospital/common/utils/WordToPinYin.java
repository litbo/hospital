package com.litbo.hospital.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class WordToPinYin {
    /**
    * 汉字转成首字母
    * @return  结果为大写
    * */
    public static String toPinYin(String words){
       if(words==null||"".equals(words))
            return "";
        String convert = "";
        int j = 0;
        for(int len = words.length(); j < len; j++) {
                char word = words.charAt(j);
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
                if (pinyinArray != null) {
                    convert += pinyinArray[0].charAt(0);
                } else {
                    convert += word;
                }
        }
        return convert.toUpperCase();
    }

}
