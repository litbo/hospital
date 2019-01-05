package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.dao.provider.EquipmentAccountProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 电子台账Mapper
 *
 * @author Administrator on 2018-12-16
 */
@Mapper
public interface EquipmentAccountMapper {
    /**
     * 查询电子台账
     *
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @return List<MachineAccountVO>
     */
    @SelectProvider(type = EquipmentAccountProvider.class, method = "selectEquipmentAccount")
    List<MachineAccountVO> selectEquipmentAccount(@Param("category") String category, @Param("state") String state, @Param("departmentId") String departmentId, @Param("equipmentPinyinCode") String equipmentPinyinCode, @Param("departmentCoding") String departmentCoding, @Param("equipmentNumber") String equipmentNumber);
}
