package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgReason;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 报废原因Mapper
 */
@Mapper
public interface SgReasonMapper {
    /**
     * 添加报废原因
     * @param record 报废原因信息
     * @return 添加记录数
     */
    @Insert({
        "insert into sg_reason (lccl_id, reason_id)",
        "values (#{lcclId,jdbcType=VARCHAR}, #{reasonId,jdbcType=VARCHAR})"
    })
    int insert(SgReason record);
}