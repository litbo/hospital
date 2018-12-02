package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SEmp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BmGroupDao {

    @Select("select user_id, user_xm, sex_id, mz_id, zzmm_id, sfzh, gb_id, jg_id, jtzz, bm_id, zggwlb_id, \n" +
            "    zgbzlb_id, zgzt_id, xllb_id, xlzy_id, zwlb_id, tel, email, byyx, qzzp, zp from s_emp")
    public List<SEmp> getBmGroupMembers();

    @Select("select user_id, user_xm, sex_id, mz_id, zzmm_id, sfzh, gb_id, jg_id, jtzz, bm_id, zggwlb_id, \n" +
            "    zgbzlb_id, zgzt_id, xllb_id, xlzy_id, zwlb_id, tel, email, byyx, qzzp, zp from s_emp " +
            "where bm_id = #{bm_id}")
    List<SEmp> getBmGroupMembersByBmId(String bm_id);
}
