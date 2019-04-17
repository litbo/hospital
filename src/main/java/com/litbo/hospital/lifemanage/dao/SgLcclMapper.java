package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.vo.*;
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
     * 通过处置管理id查询对应设备id
     * @param id 处置管理id
     * @return 设备id
     */
    @Select("SELECT eq_id FROM sg_lccl WHERE id = #{id,jdbcType=VARCHAR}")
    String selectEqIdById(@Param("id") String id);

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
            "dbo.eq_info.eq_sbbh IS NOT NULL AND dbo.eq_info.eq_id NOT IN ((SELECT\n" +
            "dbo.sg_lccl.eq_id\n" +
            "FROM\n" +
            "dbo.sg_lccl WHERE dbo.sg_lccl.issh = 1 OR dbo.sg_lccl.issh IS NULL  ))" +
            " <if test=\"bmId != null\"> AND dbo.eq_info.eq_bmid = #{bmId}</if> " +
            "</where>" +
            "</script>")
    List<ScrappedListVO> selectNoScrappedList(@Param("bmId") String bmId);

    /**
     * 已报废清单
     * @param bmId 部门id
     * @return List<ScrappedListVO>
     */
    @Select("<script>" +
            "SELECT\n" +
            "dbo.eq_info.eq_id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_pp,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_price,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.sg_lccl.id\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "INNER JOIN dbo.sg_lccl ON dbo.eq_info.eq_id = dbo.sg_lccl.eq_id\n" +
            "WHERE\n" +
            "dbo.sg_lccl.clear_time IS NOT NULL" +
            " <if test=\"bmId != null\"> AND dbo.eq_info.eq_bmid = #{bmId}</if> " +
            "</script>")
    List<ScrappedListVO> selectYesScrappedList(@Param("bmId") String bmId);
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
            "dbo.eq_info.eq_sbbh IS NOT NULL AND dbo.eq_info.eq_id IN (SELECT\n" +
            "dbo.sg_lccl.eq_id\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "WHERE\n" +
            "dbo.sg_lccl.lccl_id IS NULL AND issh IS NULL)" +
            "<if test=\"bmId != null\"> AND dbo.eq_info.eq_bmid = #{bmId,jdbcType=VARCHAR} </if>" +
            "</script>")
    List<ScrappedListVO> selectApplyList(@Param("bmId") String bmId);

    /**
     * 待上报列表
     *
     * @param tab 标记 1待上报列表 2待批复列表 3待清理设备 4待备案处置设备
     * @return List
     */
    @Select("<script>" +
            "SELECT\n" +
            "dbo.eq_info.eq_id,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.s_bm.bm_name,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_cgrq,\n" +
            "dbo.eq_info.eq_price,\n" +
            "dbo.s_emp.user_xm as userName,\n" +
            "dbo.sg_lccl.declare_time,\n" +
            "dbo.sg_lccl.opinion,\n" +
            "dbo.sg_lccl.opinion2,\n" +
            "dbo.sg_lccl.mode,\n" +
            "dbo.sg_lccl.id\n" +
            "FROM\n" +
            "dbo.eq_info\n" +
            "INNER JOIN dbo.sg_lccl ON dbo.eq_info.eq_id = dbo.sg_lccl.eq_id\n" +
            "INNER JOIN dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id\n" +
            "INNER JOIN dbo.s_emp ON dbo.sg_lccl.user_id = dbo.s_emp.user_id" +
            "<where>" +
            "<if test=\"tab == 1\"> dbo.sg_lccl.lccl_id IS NOT NULL AND dbo.sg_lccl.report_person IS NULL</if>" +
            "<if test=\"tab == 2\"> AND dbo.sg_lccl.report_person IS NOT NULL AND dbo.sg_lccl.ratify IS NULL AND dbo.sg_lccl.issh = 1</if>" +
            "<if test=\"tab == 3\"> AND dbo.sg_lccl.ratify IS NOT NULL AND dbo.sg_lccl.clear_person IS NULL AND dbo.sg_lccl.issh = 1</if>" +
            "<if test=\"tab == 4\"> AND dbo.sg_lccl.clear_person IS NOT NULL AND dbo.sg_lccl.record IS NULL</if>" +
            "</where>" +
            "ORDER BY dbo.sg_lccl.declare_time DESC" +
            "</script>")
    List<DisposalReportListVO> selectXList(@Param("tab") String tab);

    /**
     * 处置流程信息查询
     * @param eqId 设备id
     * @return DisposalProcessListVO
     */
    @Select("SELECT\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_zcbh,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_qysj,\n" +
            "dbo.eq_info.eq_cgrq,\n" +
            "dbo.eq_info.eq_price,\n" +
            "dbo.s_emp.user_xm AS userId,\n" +
            "dbo.sg_lccl.declare_time,\n" +
            "dbo.sg_lccl.id\n" +
            "\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "INNER JOIN dbo.eq_info ON dbo.sg_lccl.eq_id = dbo.eq_info.eq_id\n" +
            "INNER JOIN dbo.s_emp ON dbo.sg_lccl.user_id = dbo.s_emp.user_id\n" +
            "WHERE\n" +
            "dbo.sg_lccl.eq_id = #{eqId,jdbcType=VARCHAR} AND dbo.sg_lccl.issh IS NULL")
    DisposalProcessListVO selectDisposalProcess(String eqId);

    /**
     * 流程处理详情
     *
     * @param id 流程处理主键id
     * @return LcclToVO
     */
    @Select("SELECT\n" +
            "dbo.sg_lccl.id,\n" +
            "dbo.sg_lccl.user_id,\n" +
            "dbo.sg_lccl.declare_time,\n" +
            "dbo.sg_lccl.mode,\n" +
            "dbo.sg_lccl.report_person,\n" +
            "dbo.sg_lccl.report_time,\n" +
            "dbo.sg_lccl.ratify,\n" +
            "dbo.sg_lccl.ratify_time,\n" +
            "dbo.sg_lccl.opinion,\n" +
            "dbo.sg_lccl.opinion2,\n" +
            "dbo.sg_lccl.clear_person,\n" +
            "dbo.sg_lccl.clear_time,\n" +
            "dbo.sg_lccl.record,\n" +
            "dbo.sg_lccl.record_time,\n" +
            "dbo.sg_lccl.storage_location,\n" +
            "dbo.sg_lccl.state,\n" +
            "dbo.sg_lccl.approver,\n" +
            "dbo.sg_lccl.sbqc,\n" +
            "dbo.sg_lccl.issh,\n" +
            "dbo.eq_info.eq_sbbh,\n" +
            "dbo.eq_info.eq_name,\n" +
            "dbo.eq_info.eq_gg,\n" +
            "dbo.eq_info.eq_xh,\n" +
            "dbo.eq_info.eq_zcbh,\n" +
            "dbo.eq_info.eq_price,\n" +
            "dbo.eq_info.eq_qysj,\n" +
            "dbo.eq_info.eq_cgrq\n" +
            "FROM\n" +
            "dbo.sg_lccl\n" +
            "INNER JOIN dbo.eq_info ON dbo.sg_lccl.eq_id = dbo.eq_info.eq_id\n" +
            "WHERE\n" +
            "dbo.sg_lccl.id = #{id,jdbcType=VARCHAR}")
    LcclToVO selectLcclById(String id);

    /**
     * 查询处置原因
     * @param id 流程处理id
     * @return 处置原因
     */
    @Select("SELECT\n" +
            "dbo.sg_reason.reason_id\n" +
            "FROM\n" +
            "dbo.sg_reason\n" +
            "WHERE\n" +
            "dbo.sg_reason.lccl_id = #{id,jdbcType=VARCHAR}")
    List<String> selectReasonIdsByLcclId(String id);
}