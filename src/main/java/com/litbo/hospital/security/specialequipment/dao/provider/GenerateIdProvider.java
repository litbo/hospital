package com.litbo.hospital.security.specialequipment.dao.provider;

public class GenerateIdProvider {

    public String queryGenerateId(String DbTable,String idName){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select top 1 "+idName+" from "+ DbTable + " order by " + idName + " desc");
        return stringBuilder.toString();
    }

}
