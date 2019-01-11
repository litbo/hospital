package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.bean.BSbcwBean;
import com.litbo.hospital.beneficial.dao.provider.GxsrProvider;
import com.litbo.hospital.beneficial.vo.ShowSbcwVo;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GxcbDao {

    @InsertProvider(type = GxsrProvider.class , method = "insertSr")
    int insertCb(BSbcwBean bSbcwBean);

    @SelectProvider(type = GxsrProvider.class , method = "showSbSr")
    List<ShowSbcwVo> showSbCb(Integer aId);

    @Update("update b_sbcw set km_value=#{kmValue,jdbcType=DECIMAL} where a_id=#{aId}")
    Integer updateSbCb(@Param("aId") Integer aId, @Param("kmValue") BigDecimal kmValue);

    @Delete("delete from b_sbcw where a_id=#{aId}")
    Integer deleteSbCb(Integer aId);
}
