package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.vo.DateLowerAndUpperVO;
import com.litbo.hospital.lifemanage.bean.vo.DisposalQueryVO;
import com.litbo.hospital.lifemanage.bean.vo.ScrappedListVO;
import com.litbo.hospital.lifemanage.dao.provider.SgLcclSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * 处置管理Mapper
 */
@Mapper
public interface SgLcclMapper {

    /**
     * 添加处置管理信息
     *
     * @param sgLccl 处置管理
     * @return 添加记录数
     */
    @Insert({
            "insert into sg_lccl (id, eq_id, user_id, declare_time, state)",
            "values (#{id,jdbcType=VARCHAR},#{eqId,jdbcType=VARCHAR}, " +
                    "#{userId,jdbcType=VARCHAR}, #{declareTime,jdbcType=TIMESTAMP},#{state,jdbcType=VARCHAR}) ",
    })
    int insert(SgLccl sgLccl);

    /**
     * 通过主键查询
     *
     * @param id 主键id
     * @return 返回查询记录数
     */
    @Select({
            "select",
            "id, lccl_id, eq_id, user_id, declare_time, mode, report_person, report_time, ",
            "ratify, ratify_time, opinion, clear_person, clear_time, record, record_time, ",
            "storage_location",
            "from sg_lccl",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR, id = true),
            @Arg(column = "lccl_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "eq_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "declare_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "mode", javaType = String.class, jdbcType = JdbcType.CHAR),
            @Arg(column = "report_person", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "report_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "ratify", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "ratify_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "opinion", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "clear_person", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "clear_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "record", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "record_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "storage_location", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    SgLccl selectByPrimaryKey(String id);

    /**
     * 处置查询列表
     *
     * @param dateLowerAndUpperVO 时间上限 下限
     * @return List<SgLccl>
     */

    @SelectProvider(type = SgLcclSqlProvider.class, method = "selectSgLccLList")
    List<DisposalQueryVO> selectSgLccLList(DateLowerAndUpperVO dateLowerAndUpperVO);

    /**
     * 添加处置信息不为空更新
     *
     * @param record 处置管理信息
     * @return 更新记录数
     */
    @UpdateProvider(type = SgLcclSqlProvider.class, method = "updateByEqIdSelective")
    int updateByEqIdSelective(SgLccl record);

    /**
     * 待报废清单
     *
     * @param bmId 部门id
     * @return List<ScrappedListVO>
     */
    @Select("<script>" +
            "SELECT\n" +
            "dbo.eq_info.eq_id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.eq_info.eq_pp,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_price\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "<where>" +
            " <if test=\"isScrapped == null || isScrapped == 0\"> dbo.eq_info.eq_id NOT IN ((SELECT\n" +
            "dbo.sg_lccl.eq_id\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "WHERE\n" +
            "dbo.sg_lccl.clear_time IS NULL)) </if> " +
            " <if test=\"isScrapped != null\"> AND dbo.eq_info.eq_id IN ((SELECT\n" +
            "dbo.sg_lccl.eq_id\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "WHERE\n" +
            "dbo.sg_lccl.clear_time IS NOT NULL)) </if> " +
            " <if test=\"bmId != null\"> AND dbo.eq_info.eq_bmid = #{bmId}</if> " +
            "</where>" +
            "</script>")
    List<ScrappedListVO> selectScrappedList(@Param("bmId") String bmId, @Param("isScrapped") String isScrapped);

    /**
     * 处置申请
     *
     * @param bmId 部门id
     * @return List<ScrappedListVO>
     */
    @Select("<script>" +
            "SELECT\n" +
            "dbo.eq_info.eq_id," +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.eq_info.eq_pp,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_price\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "WHERE\n" +
            "dbo.eq_info.eq_id IN (SELECT\n" +
            "dbo.sg_lccl.eq_id\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "WHERE\n" +
            "dbo.sg_lccl.lccl_id IS NULL)" +
            "<if test=\"bmId != null\"> AND dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR} </if>" +
            "</script>")
    List<ScrappedListVO> selectApplyList(@Param("bmId") String bmId);

    /**
     * 通过设备id查询
     * @return
     */
    @Select("select id from sg_lccl where eq_id = #{eqId,jdbcType=VARCHAR}")
    String getIdByEqId(String eqId);
}