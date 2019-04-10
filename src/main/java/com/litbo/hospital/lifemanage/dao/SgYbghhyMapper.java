package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgYbghhy;
import com.litbo.hospital.lifemanage.bean.vo.SgYbghhyVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 院办公会会议信息表Mapper接口
 */
@Mapper
public interface SgYbghhyMapper {
    /**
     * 添加院办公会信息
     * @param sgYbghhy 院办公会信息
     * @return 添加记录数
     */
    @Insert("insert into sg_ybghhy (ybghhy_id, sg_id, ybghhy_sjy, ybghhy_sj, \n" +
            "      ybghhy_dd, extend_one, extend_two, \n" +
            "      ybghhy_chry, ybghhy_nr)\n" +
            "    values (#{ybghhyId,jdbcType=VARCHAR},#{sgId,jdbcType=VARCHAR}, #{ybghhySjy,jdbcType=VARCHAR}, #{ybghhySj,jdbcType=TIMESTAMP}, \n" +
            "      #{ybghhyDd,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, \n" +
            "      #{ybghhyChry,jdbcType=LONGVARCHAR}, #{ybghhyNr,jdbcType=LONGVARCHAR})")
    int insertSgInfoZbwyhhy(SgYbghhy sgYbghhy);

    /**
     * 院办公会会议详情
     *
     * @param ybghhyId 院办公会会议id
     * @return SgYbghhyVO
     */
    @Select("SELECT\n" +
            "dbo.sg_ybghhy.ybghhy_chry,\n" +
            "dbo.sg_ybghhy.ybghhy_sjy,\n" +
            "dbo.sg_ybghhy.ybghhy_sj,\n" +
            "dbo.sg_ybghhy.ybghhy_dd,\n" +
            "dbo.sg_ybghhy.ybghhy_nr,\n" +
            "dbo.sg_ybghhy.extend_one,\n" +
            "dbo.sg_ybghhy.extend_two,\n" +
            "dbo.sg_info.isybghsh as issh,\n" +
            "dbo.sg_info.ybghyj as shyj\n" +
            "FROM\n" +
            "dbo.sg_ybghhy\n" +
            "INNER JOIN dbo.sg_info ON dbo.sg_ybghhy.ybghhy_id = dbo.sg_info.ybghhy_id\n" +
            "WHERE\n" +
            "dbo.sg_ybghhy.ybghhy_id = #{ybghhyId,jdbcType=VARCHAR}")
    SgYbghhyVO selectSgYbghhyById(String ybghhyId);
}