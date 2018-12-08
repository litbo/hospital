package com.litbo.hospital.security.dao;

import com.litbo.hospital.security.bean.FwPjqlZjb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FwPjqlZjbDao {
    @Insert( {"<script>",
            "insert into fw_pjql_zjb(pjql_id, pj_id, pj_count) values ",
            "<foreach collection='fwPjqlZjbs' item='item' index='index' separator=','>",
            "(#{item.pjqlId}, #{item.pjId}, #{item.pjCount})", "</foreach>",
            "</script>"
    })
    int insertFwPjqlZjbList(@Param("fwPjqlZjbs") List<FwPjqlZjb> fwPjqlZjbs);

}
