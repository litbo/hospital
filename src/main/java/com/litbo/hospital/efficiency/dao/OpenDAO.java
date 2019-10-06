package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.OpenProvider;
import com.litbo.hospital.efficiency.vo.OpenVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description: 设备开机率DAO层
 * @Author: jz
 * @Date: 2019/8/1 9:45
 */

@Mapper
public interface OpenDAO {

    /**
     * 默认查询上个月设备的开机率插入中间表中
     * @return  更新的条数
     */
    @UpdateProvider(type = OpenProvider.class,method = "updateOpen")
    Integer updateOpen();

    /**
     *  查询中间表的数据
     * @return  设备的开机率
     */
    @Select("SELECT *FROM dbo.kpi_open")
    List<OpenVO> selectOpen();

    /**
     * 把中间表的数据删除
     * @return  删除的条数
     */
    @Delete("DELETE FROM dbo.kpi_open")
    Integer deleteOpen();

    /**
     * 按照条件查询设备的开机率
     * @param searchVO 查询条件
     * @return 返回
     */
    @UpdateProvider(type = OpenProvider.class,method = "updateOpenByCon")
    Integer updateOpenByCon(SearchVO searchVO);

}
