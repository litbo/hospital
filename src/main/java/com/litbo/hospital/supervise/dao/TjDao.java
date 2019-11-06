package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.vo.RyVos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TjDao {

    @Select({
            "SELECT p.user_id,e.user_xm AS userName FROM dbo.pb_ydry AS p\n" +
             "INNER JOIN dbo.s_emp AS e ON e.user_id=p.user_id \n" +
             "WHERE p.user_zt NOT LIKE '代替%'"
    })
    List<RyVos> getInfo();

    @Select("SELECT COUNT(*) AS 'pbcs' FROM dbo.pb_ydry AS p WHERE user_id=#{userid}")
    String getPbCiShuByid(String userid);

    @Select({
            "SELECT COUNT(*) AS 'zbcs' FROM [dbo].[pb_ydry] AS p WHERE user_id=#{userid}\n" +
             "AND user_zt = '已到'"
    })
    String getZbCiShuByid(String userid);
}
