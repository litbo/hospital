//package com.litbo.hospital.operational_data_monitoring.offline_inventory.dao;
//
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.vo.SearchVO;
//import com.litbo.hospital.operational_data_monitoring.offline_inventory.bean.CountingMainTable;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
///**
// * @BelongsProject: hospital
// * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.offline_inventory.dao
// * @Author: looli
// * @CreateTime: 2019-08-04 14:45
// * @Description: todo
// */
//public interface CountingMainDAO {
//
//    @Select({"<script>",
//            "select * from counting_main_table",
//            "<where>",
//            "<if test='cPddh != null'>     c_pddh = #{cPddh} </if>\n",
//            "<if test='cShr != null'> AND  c_shr = #{cShr} </if>\n",
//            "<if test='cYwlx != null'> AND c_ywlx = #{cYwlx} </if>\n",
//            "</where>",
//            "</script>"})
//    List<CountingMainTable> select(SearchVO searchVO);
//
//}
