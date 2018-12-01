package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhZd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-29 11:26
 */
@Mapper
public interface JhZdDao {

    @Insert("insert into jh_zd (jh_name, zbdw,jh_kstime, jh_jstime, jh_pxlx, \n" +
            "      jh_pxxz, jh_pxnrlb, jh_sblx, \n" +
            "      user_id, px_zjr, px_addr, \n" +
            "      px_nr)\n" +
            "    values (#{jhName}, #{zbdw}, \n" +
            "      #{jhKstime}, #{jhJstime}, #{jhPxlx}, \n" +
            "      #{jhPxxz}, #{jhPxnrlb}, #{jhSblx}, \n" +
            "      #{userId}, #{pxZjr}, #{pxAddr}, \n" +
            "      #{pxNr})")
    public int addJhZd(JhZd jhZd);

    @Select("select * from jh_zd")
    public List<JhZd> jhzdList();
}
