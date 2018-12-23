package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.vo.MachineAccountSearchCriteriaVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 电子台账Mapper
 *
 * @author Administrator on 2018-12-16
 */
@Mapper
public interface EquipmentAccountMapper {
    /**
     * 分页查询电子台账
     *
     * @param machineAccountSearchCriteriaVO 查询条件
     * @return List<MachineAccountVO>
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_yq,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_bmid,\n" +
            "dbo.eq_info.eq_tzlb,\n" +
            "dbo.eq_info.eq_qysj,\n" +
            "dbo.eq_info.eq_synx\n" +
            "FROM dbo.eq_info\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_sbbh IS NOT NULL AND\n" +
            "dbo.eq_info.eq_zcbh IS NOT NULL")
    List<MachineAccountVO> selectEquipmentAccount(MachineAccountSearchCriteriaVO machineAccountSearchCriteriaVO);
}
