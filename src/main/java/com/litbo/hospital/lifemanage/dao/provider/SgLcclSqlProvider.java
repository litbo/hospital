package com.litbo.hospital.lifemanage.dao.provider;

import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.vo.DateLowerAndUpperVO;
import org.apache.ibatis.jdbc.SQL;

public class SgLcclSqlProvider {
    /**
     * 处置查询
     * @return sql语句
     */
    public String selectSgLccLList( DateLowerAndUpperVO dateLowerAndUpperVO) {
        SQL sql = new SQL();
        sql.SELECT("dbo.eq_info.eq_id");
        sql.SELECT("dbo.eq_info.eq_sbbh");
        sql.SELECT("dbo.eq_info.eq_name");
        sql.SELECT("dbo.s_bm.bm_name");
        sql.SELECT("dbo.eq_info.eq_gg");
        sql.SELECT("dbo.eq_info.eq_xh");
        sql.SELECT("dbo.eq_info.eq_cgrq");
        sql.SELECT("dbo.eq_info.eq_price");
        sql.SELECT("dbo.s_emp.user_xm AS userName");
        sql.SELECT("dbo.sg_lccl.declare_time");
        sql.SELECT("dbo.sg_lccl.report_time");
        sql.SELECT("dbo.sg_lccl.ratify_time");
        sql.SELECT("dbo.sg_lccl.state");
        sql.FROM("dbo.eq_info");
        sql.INNER_JOIN("dbo.sg_lccl ON dbo.sg_lccl.eq_id = dbo.eq_info.eq_id");
        sql.INNER_JOIN("dbo.s_bm ON dbo.eq_info.eq_bmid = dbo.s_bm.bm_id");
        sql.INNER_JOIN("dbo.s_emp ON dbo.sg_lccl.user_id = dbo.s_emp.user_id");
        if (dateLowerAndUpperVO != null) {
            if (dateLowerAndUpperVO.getLower()!=null){
                sql.WHERE("dbo.sg_lccl.declare_time >= #{lower,jdbcType=VARCHAR}");
            }
            if (dateLowerAndUpperVO.getUpper() != null){
                sql.WHERE("dbo.sg_lccl.declare_time <= #{upper,jdbcType=VARCHAR}");
            }
        }
        return sql.toString();
    }

    /**
     * 通过主键更新的sql语句
     *
     * @param record 处置管理信息
     * @return sql语句
     */
    public String updateByEqIdSelective(SgLccl record) {
        SQL sql = new SQL();
        sql.UPDATE("sg_lccl");

        if (record.getLcclId() != null) {
            sql.SET("lccl_id = #{lcclId,jdbcType=VARCHAR}");
            sql.SET("state = '科室填写信息完成'");
        }

        if (record.getMode() != null) {
            sql.SET("mode = #{mode,jdbcType=CHAR}");
        }

        if (record.getReportPerson() != null) {
            sql.SET("report_person = #{reportPerson,jdbcType=VARCHAR}");
        }

        if (record.getApprover() != null) {
            sql.SET("approver = #{approver,jdbcType=VARCHAR}");
        }

        if (record.getReportTime() != null) {
            sql.SET("report_time = #{reportTime,jdbcType=TIMESTAMP}");
            sql.SET("state = '申请已上报'");
        }

        if (record.getRatify() != null) {
            sql.SET("ratify = #{ratify,jdbcType=VARCHAR}");
        }

        if (record.getRatifyTime() != null) {
            sql.SET("ratify_time = #{ratifyTime,jdbcType=TIMESTAMP}");
            sql.SET("state = '申请已批复'");
        }

        if (record.getOpinion() != null) {
            sql.SET("opinion = #{opinion,jdbcType=VARCHAR}");
        }

        if (record.getClearPerson() != null) {
            sql.SET("clear_person = #{clearPerson,jdbcType=VARCHAR}");
        }

        if (record.getClearTime() != null) {
            sql.SET("clear_time = #{clearTime,jdbcType=TIMESTAMP}");
            sql.SET("state = '设备已清理'");
        }

        if (record.getSbqc() != null){
            sql.SET("sbqc = #{sbqc,jdbcType=VARCHAR}");
        }

        if (record.getRecord() != null) {
            sql.SET("record = #{record,jdbcType=VARCHAR}");
        }

        if (record.getRecordTime() != null) {
            sql.SET("record_time = #{recordTime,jdbcType=TIMESTAMP}");
            sql.SET("state = '设备已备案'");
        }

        if (record.getStorageLocation() != null) {
            sql.SET("storage_location = #{storageLocation,jdbcType=VARCHAR}");
        }

        sql.WHERE("eq_id = #{eqId,jdbcType=VARCHAR}");

        return sql.toString();
    }
}