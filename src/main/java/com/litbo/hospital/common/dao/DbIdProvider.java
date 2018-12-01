package com.litbo.hospital.common.dao;

/**
 * @author zjc
 * @create 2018-11-29 17:07
 */
public class DbIdProvider {

    public String queryDbId(String DbTable,String idName){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select top 1 "+idName+" from "+ DbTable + " order by " + idName + " desc");
        return stringBuilder.toString();
    }
}
