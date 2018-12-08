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
            result.add(subs);
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

}
