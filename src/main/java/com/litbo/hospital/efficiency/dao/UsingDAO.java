package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.UsingProvider;
import com.litbo.hospital.efficiency.vo.SearchVO;
import com.litbo.hospital.efficiency.vo.UsingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description:机时利用率的DAO层
 * @Author: jz
 * @Date: 2019/8/1 16:45
 */
@Mapper
public interface UsingDAO {

    /**
     * 默认搜索前一天的机时利用率
     * @return
     */
    @SelectProvider(type = UsingProvider.class,method = "selectUsing")
    List<UsingVO> selectUsing();

    /**
     * 按照条件搜索机时利用率
     * @param searchVO
     * @return
     */
    @SelectProvider(type = UsingProvider.class,method = "selectUsingByCon")
    List<UsingVO> selectUsingByCon(SearchVO searchVO);

}
