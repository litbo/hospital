package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IntegrityProvider;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 *   设备完好率DAO层
 *   @Author: jz
 *   @date: 2019/7/31 16:59
 */
@Mapper
public interface IntegrityDAO {

    /**
     * 设备的完好率
     * @return 设备的完好率
     */
    @SelectProvider(type = IntegrityProvider.class,method = "selectIntegrity")
    List<IntegrityVO> selectIntegrity();

    /**
     * 按条件搜索设备的完好率
     * @param searchVO 设备的完好率条件
     * @return 设备的完好率
     */
    @SelectProvider(type = IntegrityProvider.class,method = "selectIntegrityByCon")
    List<IntegrityVO> selectIntegrityByCon(SearchVO searchVO);

}
