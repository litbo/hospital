package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.dao.sqlprovider.JhZdProvider;
import com.litbo.hospital.security.vo.JhKhVo;
import com.litbo.hospital.security.vo.JhZdVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-11-29 11:26
 */
@Mapper
public interface JhZdDao {

    @Insert("insert into jh_zd (jh_name, zbdw,jh_kstime, jh_jstime, jh_pxlx, \n" +
            "      jh_pxxz, jh_pxnrlb,\n" +
            "      user_id, px_addr, \n" +
            "      px_nr)\n" +
            "    values (#{jhName}, #{zbdw}, \n" +
            "      #{jhKstime}, #{jhJstime}, #{jhPxlx}, \n" +
            "      #{jhPxxz}, #{jhPxnrlb}, \n" +
            "      #{userId}, #{pxAddr}, \n" +
            "      #{pxNr})")
    public int addJhZd(JhZd jhZd);

    @Select("SELECT jh.jh_name," +
            "jh.px_addr,\n" +
            "jh.jh_pxlx,\n" +
            "jh.jh_pxxz,\n" +
            "jh.jh_kstime,\n" +
            "jh.jh_jstime,\n" +
            "jh.user_id as userXm,\n" +
            "jh.id,\n" +
            "jh.user_id " +
            "FROM jh_zd AS jh")
    public List<JhZdVo> jhzdList();

    @SelectProvider(type = JhZdProvider.class,method = "findListByKsTime")
    public List<JhZdVo> jhrylrListIndex(@Param("createdate") String createdate, @Param("jhName") String jhName);

    @SelectProvider(type = JhZdProvider.class,method = "findListByJsTime")
    public List<JhZdVo> jhryKhListIndex(@Param("createdate") String createdate, @Param("jhName") String jhName);

    @Select("select * from jh_zd where id = #{id}")
    public JhZd getJhzdById(Integer id);

    @Select("SELECT\n" +
            "dbo.jh_zd.id AS jhId,\n" +
            "dbo.jh_zd.jh_name,\n" +
            "dbo.jh_zd.jh_kstime,\n" +
            "dbo.jh_zd.jh_jstime\n" +
            "FROM\n" +
            "dbo.jh_zd\n" +
            "WHERE\n" +
            "id = #{jhId}")
    public JhKhVo findJhKh(Integer jhId);
}
