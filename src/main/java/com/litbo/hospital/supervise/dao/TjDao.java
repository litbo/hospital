package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TjDao {

//    @Select({
//            "SELECT p.user_id,e.user_xm AS userName FROM dbo.pb_ydry AS p\n" +
//             "INNER JOIN dbo.s_emp AS e ON e.user_id=p.user_id \n" +
//             "WHERE p.user_zt NOT LIKE '代替%' AND p.pb_jhid=#{jhid}"
//    })
//    List<RyVos> getInfo(@Param("jhid") String jhid);

    @Select({
            "SELECT p.user_id,e.user_xm AS userName FROM dbo.pb_ydry AS p\n" +
                    "INNER JOIN dbo.s_emp AS e ON e.user_id=p.user_id \n" +
                    "WHERE p.user_zt NOT LIKE '代替%'"
    })
    List<RyVos> getInfo();


    @Select("SELECT COUNT(*) AS 'pbcs' FROM dbo.pb_ydry AS p WHERE user_id=#{userid}")
    String getPbCiShuByid(String userid);


    @Select({
            "SELECT COUNT(*) AS 'zbcs' FROM dbo.pb_ydry AS p WHERE user_id=#{userid}\n" +
             "AND user_zt = '已到'"
    })
    String getZbCiShuByid(@Param("userid")String userid);

    @Select({
            "SELECT DISTINCT j.pb_jhid,j.pb_date,j.pbJs_date,b.bm_name FROM pb_jh AS j\n" +
            "INNER JOIN s_bm AS b ON j.bm_id=b.bm_id " +
            "AND pb_check='已审核'"
    })
    List<getPbPlanVos> getPbPlanVos();



}
