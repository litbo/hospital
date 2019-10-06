package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.UsingProvider;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.efficiency.vo.UsingVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * description:机时利用率的DAO层
 * @Author: jz
 * @Date: 2019/8/1 16:45
 */
@Mapper
public interface UsingDAO {

    /**
     * 默认查询前一天的机时利用率将数据插入到中间表中
     * @return  机时利用率
     */
    @UpdateProvider(type = UsingProvider.class,method = "selectUsing")
    Integer updateUsing();

    /**
     * 从中间表中取机时利用率
     * @return  机时利用率
     */
    @Select("SELECT *FROM dbo.kpi_using")
    List<UsingVO> selectUsing();

    /**
     * 删除中间表的数据
     * @return 删除的行数
     */
    @Delete("DELETE FROM dbo.kpi_using")
    Integer deleteUsing();

    /**
     * 按照条件查询机时利用率
     * @param searchVO  机时利用率条件
     * @return  机时利用率
     */
    @UpdateProvider(type = UsingProvider.class,method = "selectUsingByCon")
    Integer updateUsingByCon(SearchVO searchVO);

}
