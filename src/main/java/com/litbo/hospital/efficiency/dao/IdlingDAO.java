package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IdlingProvider;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description: 空转率
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
@Mapper
public interface IdlingDAO {

    /**
     * 默认查询前一天的空转率并将数据插入到中间表中
     * @return  插入几行数据
     */
    @UpdateProvider(type = IdlingProvider.class,method = "selectIdling")
    Integer updateIdling();

    /**
     * 查询中间表中的设备空转率
     * @return 设备的空转率
     */
    @Select("SELECT *FROM dbo.kpi_idling")
    List<IdlingVO> selectIdling();

    /**
     * 将中间表数据删除
     * @return  设备的空转率
     */
    @Delete("DELETE FROM dbo.kpi_idling")
    Integer deleteIdling();

    /**
     * 按条件查询设备的空转率
     * @param searchVO  设备的空转率条件
     * @return  设备的空转率
     */
    @UpdateProvider(type = IdlingProvider.class,method = "selectIdlingByCon")
    Integer updateIdlingByCon(SearchVO searchVO);

}
