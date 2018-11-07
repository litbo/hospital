package com.litbo.hospital.common.utils.poi;

import com.alibaba.fastjson.JSONObject;
import net.sf.cglib.beans.BeanMap;

import java.util.*;

public class ListToListMap {

    /**
     *List<List></>转换成map  键为id
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

    /**
     * 把对象转化成map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 把List<T>转化成List<Map></>
     * @param objList
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setAge(18);
        user.setAddr("河南");
        Map<String, Object> map = beanToMap(user);
        //System.out.println(map);
        Collection<Object> values = map.values();
        System.out.println(values);
    }

}
