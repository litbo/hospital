package com.litbo.hospital.lifemanage.dao.MyMapper;


import com.litbo.hospital.lifemanage.bean.MyBean.CzGcMb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CzGcMbMapper {

    /*全查或条件查询模板列表*/
    @Select("<script>" +
            "select mb_id,mb_mc from cz_gc_mb\n" +
            "<if test=\"mbmc != null and mbmc !='' \">" +
            " where mb_mc like CONCAT('%',#{mbmc},'%')"+
            "</if>" +
            "</script>")
    List<CzGcMb> AllCzGzMb(@Param("mbmc") String mbmc);
    /*根据主键查询模板*/
    @Select("select * from cz_gc_mb where mb_id=#{id}")
    CzGcMb selectOneMbByPrimaryKey(String id);
    /*录入模板*/
    @Insert("insert into cz_gc_mb values(#{mbId},#{mbMc},#{mbNr,jdbcType=VARCHAR})")
    int insertMb(CzGcMb mb);

}