package com.litbo.hospital.operational_data_monitoring.software_interface.dao;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqYzTab;
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

}
