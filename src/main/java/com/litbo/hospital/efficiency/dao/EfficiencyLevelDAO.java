package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.EfficiencyLevelProvider;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
import com.litbo.hospital.efficiency.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * description: 效率等级
 * @author: sz
 * @date: 2019/8/5 10:32
 */
@Mapper
public interface EfficiencyLevelDAO {

    /**
     * 设备的效率等级
     * @return 返回效率等级
     */
    @SelectProvider(type = EfficiencyLevelProvider.class,method = "selectLevel")
    List<EfficiencyLevelVO> selectLevel();

    /**
     * 按条件查询的效率等级
     * @param searchVO 查询的条件
     * @return 返回信息
     */
    @SelectProvider(type = EfficiencyLevelProvider.class,method = "selectLevelByCon")
    List<EfficiencyLevelVO> selectLevelByCon(SearchVO searchVO);

}
