package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqXm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface  EqYzTabDAO {
        @Insert({"<script>",
                "insert into eq_yz_tab (eq_id, yz_XmBm\n" +
                "      )\n" +
                "    values " +
                "<foreach item='eqyz' collection='list' separator=',' > \n" +
                "( #{eqyz.eqId,jdbcType=VARCHAR}, #{eqyz.yzXmBm,jdbcType=VARCHAR})",
                "</foreach>",
                "</script>"})
        void save(List<EqYzTab> eqYzTabs);

        /**
         * 删除医嘱与设备关联信息
         */
        @Delete("delete from eq_yz_tab")
        void delete();


        @Delete({"<script>",
                "delete from eq_yz_tab where " +
                 "eq_id in ",
                "<foreach item='id1' collection='list' open='(' separator=',' close=')'> #{id1.eqId} </foreach>",
                "and yz_XmBm in",
                "<foreach item='id2' collection='list' open='(' separator=',' close=')'> #{id2.yzXmBm} </foreach>"
                ,"</script>"})
        void delete2(List<EqYzTab> eqYzTabList);


        @Select({"<script>",
                "SELECT\n" +
                        "\ta.id,b.eq_id,c.Sf_XmBm,b.eq_name,d.bm_name,c.Sf_XmMc,c.Sf_Price,c.Sf_Unit\t\n" +
                        "FROM",
                        "\teq_yz_tab a\n" +
                        "\tLEFT JOIN eq_info b ON a.eq_id = b.eq_id\n" +
                        "\tLEFT JOIN his_SFXM_DICT c ON a.yz_XmBm = c.Sf_XmBm\n" +
                        "\tLEFT JOIN s_bm d ON b.eq_bmid = d.bm_id",
                "<where>",
                "<if test='eqName != null'>  b.eq_name like '%${eqName}%' </if>\n" +
                "<if test='SfXmMc != null'>  and c.Sf_XmMc like '%${SfXmMc}%' </if>\n" +
                "</where>",
                "ORDER BY b.eq_name",
                "</script>"})
        List<EqXm> show(EqXm eqXm);

        /**
         * 修改
         * @param eqXm
         */
        @Update("update eq_yz_tab set eq_id = #{eqId} where id=#{id}")
        void update(EqXm eqXm);

        @Delete("delete from eq_yz_tab where id = #{id}")
        void deleteOne(String id);

        /**
         * 批量删除
         * @param ids
         */
        @Delete({"<script>",
                "delete from eq_yz_tab where id in",
                "<foreach item='id' collection='array' open='(' separator=',' close=')'> #{id} </foreach>",
                "</script>"})
        void deletes(String[] ids);

}
