package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IntegrityProvider;
import com.litbo.hospital.efficiency.vo.IntegrityVO;
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
     * @return
     */
    @SelectProvider(type = IntegrityProvider.class,method = "selectIntegrity")
    List<IntegrityVO> selectIntegrity();

    /**
     * 按条件搜索设备的完好率
     * @param integrityVO
     * @return
     */
    @SelectProvider(type = IntegrityProvider.class,method = "selectIntegrityByCon")
    List<IntegrityVO> selectIntegrityByCon(IntegrityVO integrityVO);

}
