package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.bean.BSbcwBean;
import com.litbo.hospital.beneficial.dao.provider.GxsrProvider;
import com.litbo.hospital.beneficial.vo.ShowSbcwVo;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface GxsrDao {

    @InsertProvider(type = GxsrProvider.class , method = "insertSr")
    int insertSr(BSbcwBean bSbcwBean);

    @SelectProvider(type = GxsrProvider.class , method = "showSbSr")
    ShowSbcwVo showSbSr(Integer aId);

    @Update("update b_sbcw set km_value=#{kmValue,jdbcType=DECIMAL} where a_id=#{aId}")
    Integer updateSbSr(@Param("aId") Integer aId, @Param("kmValue") BigDecimal kmValue);

    @Delete("delete from b_sbcw where a_id=#{aId}")
    Integer deleteSbSr(Integer aId);
}
