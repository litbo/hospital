package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IntegrityProvider;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *   设备完好率DAO层
 *   @Author: jz
 *   @date: 2019/7/31 16:59
 */
@Mapper
public interface IntegrityDAO {

    /**
     * 查询设备的完好率并插入中间表
     * @return 插入的行数
     */
    @UpdateProvider(type = IntegrityProvider.class,method = "selectIntegrity")
    Integer updateIntegrity();

    /**
     * 查询中间表的数据
     * @return  设备的完好率
     */
    @Select("SELECT *FROM dbo.kpi_integrity")
    List<IntegrityVO> selectIntegrity();

    /**
     * 删除中间表的数据
     * @return  删除的行数
     */
    @Delete("DELETE FROM dbo.kpi_integrity")
    Integer deleteIntegrity();

    /**
     * 按条件查询设备的完好率
     * @param searchVO 设备的完好率条件
     * @return 设备的完好率
     */
    @UpdateProvider(type = IntegrityProvider.class,method = "selectIntegrityByCon")
    Integer updateIntegrityByCon(SearchVO searchVO);

}
