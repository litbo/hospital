package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IdlTimeProvider;
import com.litbo.hospital.efficiency.vo.IdlTimeVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description: 工作日闲置时间
 * @Author: jz
 * @Date: 2019/8/2 12:28
 */
@Mapper
public interface IdlTimeDAO {

    /**
     * 默认搜索一月的数据
     * @return 工作日闲置时间
     */
    @SelectProvider(type = IdlTimeProvider.class,method = "selectIdlTime")
    List<IdlTimeVO> selectIdlTime();

    /**
     * 按条件搜索设备的工作日闲置时间
     * @param searchVO  工作日闲置时间条件
     * @return  工作日闲置时间
     */
    @SelectProvider(type = IdlTimeProvider.class,method = "selectIdlTimeByCon")
    List<IdlTimeVO> selectIdlTimeByCon(SearchVO searchVO);

}
