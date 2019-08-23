package com.litbo.hospital.efficiency.dao;

import com.litbo.hospital.efficiency.dao.provider.EfficiencyLevelProvider;
import com.litbo.hospital.efficiency.vo.EfficiencyLevelVO;
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
     * 按条件搜索的效率等级
     * @param levelVO 搜索的条件
     * @return 返回信息
     */
    @SelectProvider(type = EfficiencyLevelProvider.class,method = "selectLevelByCon")
    List<EfficiencyLevelVO> selectLevelByCon(EfficiencyLevelVO levelVO);

}
