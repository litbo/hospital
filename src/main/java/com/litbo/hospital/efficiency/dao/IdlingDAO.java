package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.IdlingProvider;
import com.litbo.hospital.efficiency.vo.IdlingVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description: 空转率
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
@Mapper
public interface IdlingDAO {

    /**
     * 默认搜索前一天的空转率
     * @return
     */
    @SelectProvider(type = IdlingProvider.class,method = "selectIdling")
    List<IdlingVO> selectIdling();

    /**
     * 按条件搜索设备的空转率
     * @param searchVO
     * @return
     */
    @SelectProvider(type = IdlingProvider.class,method = "selectIdlingByCon")
    List<IdlingVO> selectIdlingByCon(SearchVO searchVO);

}
