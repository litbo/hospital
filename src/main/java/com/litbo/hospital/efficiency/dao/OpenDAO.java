package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.OpenProvider;
import com.litbo.hospital.efficiency.vo.OpenVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description: 设备开机率DAO层
 * @Author: jz
 * @Date: 2019/8/1 9:45
 */

@Mapper
public interface OpenDAO {

    /**
     * 默认查询上个月设备的开机率
     * @return
     */
    @SelectProvider(type = OpenProvider.class,method = "selectOpen")
    List<OpenVO> selectOpen();

    /**
     * 按照条件查询设备的开机率
     * @param openVO
     * @return
     */
    @SelectProvider(type = OpenProvider.class,method = "selectOpenByCon")
    List<OpenVO> selectOpenByCon(OpenVO openVO);

}
