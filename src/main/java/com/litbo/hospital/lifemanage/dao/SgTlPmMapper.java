package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.dao.mapper.SgTiPmProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 讨论申购设备关联表Mapper接口
 */
@Mapper
public interface SgTlPmMapper {
    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param pmId 设备品名ID
     * @return 添加的数据的数量
     */
    @InsertProvider(type = SgTiPmProvider.class, method = "insertSgTiPmSql")
    public int insertSgTlPm(String kstlId, List<Integer> pmId);
    /*
    int countByExample(SgTlPmExample example);

    int deleteByExample(SgTlPmExample example);

    int deleteByPrimaryKey(SgTlPmKey key);

    int insert(SgTlPmKey record);

    int insertSelective(SgTlPmKey record);

    List<SgTlPmKey> selectByExample(SgTlPmExample example);

    int updateByExampleSelective(@Param("record") SgTlPmKey record, @Param("example") SgTlPmExample example);

    int updateByExample(@Param("record") SgTlPmKey record, @Param("example") SgTlPmExample example);
     */
}