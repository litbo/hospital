package com.litbo.hospital.common.utils.poi;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToListMap {

    public static void main(String[] args) {
        //JSONObject.parseObject();
    }

    /**
     *list转换成map  键为id
     * @param lists
     * @param listTitle
     * @return
     */
    public static List<Map<String, Object>> listToMap(List<List<Object>> lists, List listTitle){
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            int size = listTitle.size();
            HashMap hashMap = new HashMap();
            for (int j = 0; j < size; j++) {
                hashMap.put(listTitle.get(j),lists.get(i).get(j));
            }
            mapList.add(hashMap);
        }
        return mapList;
    }

    /**
     * 把map转化成对象
     * @param paramMap
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T parseMap2Object(Map<String, Object> paramMap, Class<T> cls) {
        return JSONObject.parseObject(JSONObject.toJSONString(paramMap), cls);

    }


}
