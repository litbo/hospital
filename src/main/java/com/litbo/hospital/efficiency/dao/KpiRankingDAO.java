package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.KpiRankingProvider;
import com.litbo.hospital.efficiency.vo.KpiRankingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description: 各种kpi的排名比较
 * @author: sz
 * @date: 2019/8/4 14:18
 */
@Mapper
public interface KpiRankingDAO {

    /**
     * 设备开机率变化
     * @param kpiRankingVO  开机率
     * @return 返回设备开机率变化的信息
     */
    @SelectProvider(type = KpiRankingProvider.class,method = "selectChange")
    List<KpiRankingVO> selectChange(KpiRankingVO kpiRankingVO);

}
