package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

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

}
