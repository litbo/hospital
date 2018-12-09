package com.litbo.hospital.supervise.controller;

import java.util.ArrayList;
import java.util.List;


public class TestController {


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

    public static void main(String[] args) {
        String bm_id = "0201050200";
        System.out.println("hh");
        System.out.println(stringToList(bm_id));
    }
}
