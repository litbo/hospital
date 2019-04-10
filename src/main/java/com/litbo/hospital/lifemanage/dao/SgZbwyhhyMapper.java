package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgZbwyhhy;
import com.litbo.hospital.lifemanage.bean.vo.SgZbwyhhyVO;
import org.apache.ibatis.annotations.*;

/**
 * 装备委员会会议信息表Mapper类
 */
@Mapper
public interface SgZbwyhhyMapper {

    /**
     * 添加装备委员会会议信息
     *
     * @param sgZbwyhhy 装备委员会信息
     * @return 更新记录数
     */
    @Insert("insert into sg_zbwyhhy (zbwyhhy_id,sg_id, zbwyhhy_nd, zbwyhhy_chry, \n" +
            "   zbwyhhy_fgld, zbwyhhy_fgldyj, zbwyhhy_sj, \n" +
            "   zbwyhhy_dd, zbwyhhy_zgbm, zbwyhhy_zgbmyj, \n" +
            "   extend_one, extend_two, zbwyhhy_nr\n" +
            "   )\n" +
            " values (#{zbwyhhyId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, #{zbwyhhyNd,jdbcType=VARCHAR}, #{zbwyhhyChry,jdbcType=VARCHAR}, \n" +
            "   #{zbwyhhyFgld,jdbcType=VARCHAR}, #{zbwyhhyFgldyj,jdbcType=VARCHAR}, #{zbwyhhySj,jdbcType=TIMESTAMP}, \n" +
            "   #{zbwyhhyDd,jdbcType=VARCHAR}, #{zbwyhhyZgbm,jdbcType=VARCHAR}, #{zbwyhhyZgbmyj,jdbcType=VARCHAR}, \n" +
            "   #{extendOne,jdbcType=VARCHAR}, #{extendTwo,jdbcType=VARCHAR}, #{zbwyhhyNr,jdbcType=LONGVARCHAR}\n" +
            "   )")
    int insertSgInfoZbwyhhy(SgZbwyhhy sgZbwyhhy);

    /**
     * 装备委员会详情信息
     *
     * @param zbwyhhyId 装备会员会id
     * @return SgZbwyhhyVO
     */
    @Results({
            @Result(column="zbwyhhy_nd",property="zbwyhhyNd"),
            @Result(column="zbwyhhy_chry",property="zbwyhhyChry"),
            @Result(column="zbwyhhy_fgld",property="zbwyhhyFgld"),
            @Result(column="zbwyhhy_fgldyj",property="zbwyhhyFgldyj"),
            @Result(column="zbwyhhy_sj",property="zbwyhhySj"),
            @Result(column="zbwyhhy_dd",property="zbwyhhyDd"),
            @Result(column="zbwyhhy_zgbm",property="zbwyhhyZgbm"),
            @Result(column="zbwyhhy_zgbmyj",property="zbwyhhyZgbmyj"),
            @Result(column="zbwyhhy_nr",property="zbwyhhyNr"),
            @Result(column="iszbwyhsh",property="issh"),
            @Result(column="zbwyhyj",property="shyj"),
            @Result(column="zbwyhhy_id",property="users",
                    many=@Many(
                            select="com.litbo.hospital.lifemanage.dao.SgZbwyhRyMapper.selectZbwyhhyRyByZbwyhId"
                    )
            )
    })
    @Select("SELECT\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_id,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_nd,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_chry,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_fgld,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_fgldyj,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_sj,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_dd,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_zgbm,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_zgbmyj,\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_nr,\n" +
            "dbo.sg_info.iszbwyhsh as issh,\n" +
            "dbo.sg_info.zbwyhyj as shyj\n" +
            "FROM\n" +
            "dbo.sg_zbwyhhy INNER JOIN dbo.sg_info ON dbo.sg_zbwyhhy.zbwyhhy_id = dbo.sg_info.zbwyhhy_id\n" +
            "WHERE\n" +
            "dbo.sg_zbwyhhy.zbwyhhy_id = #{zbwyhhyId,jdbcType=VARCHAR}")
    SgZbwyhhyVO selectSgZbwyhById(String zbwyhhyId);
}