package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.provider.EmpProvider;
import com.litbo.hospital.supervise.vo.EmpSelectVO;
import com.litbo.hospital.supervise.vo.EmpVO;
import com.litbo.hospital.supervise.vo.JhEmpVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-09 15:23
 */
@Mapper
public interface EmpDao {

    @Select("select * from s_emp where user_id = #{userId}")
    SEmp getEmpByUserId(String userId);
    @Select("SELECT emp.user_id, emp.user_xm, emp.sex_id, emp.mz_id, emp.zzmm_id, emp.sfzh, emp.gb_id, emp.jg_id, emp.jtzz, emp.bm_id, emp.zggwlb_id, \n" +
            "    emp.zgbzlb_id, emp.zgzt_id, emp.xllb_id, emp.xlzy_id, emp.zwlb_id, emp.tel, emp.email, emp.byyx, emp.qzzp, emp.zp,emp.status\n" +
            " from s_emp emp  INNER JOIN s_bm bm ON (emp.bm_id=bm.bm_id) WHERE bm.wx_flag=1")
    List<SEmp> getWxEmps();

    @Select("SELECT\n" +
            "emp.user_xm\n" +
            "FROM\n" +
            "dbo.s_emp AS emp\n" +
            "WHERE\n" +
            "emp.user_id = #{userId}")
    String getUserXmById(String userId);

    @Select("select * from s_emp where bm_id = #{bmId}")
    List<SEmp> getEmpsByBmId(String bmId);
    @Insert("insert into s_emp (user_id, user_xm, sex_id, \n" +
            "      mz_id, zzmm_id, sfzh, gb_id, \n" +
            "      jg_id, jtzz, bm_id, zggwlb_id, \n" +
            "      zgbzlb_id, zgzt_id, xllb_id, xlzy_id, \n" +
            "      zwlb_id, tel, email, byyx, \n" +
            "      qzzp, zp,status,zc_id)\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{userXm,jdbcType=VARCHAR}, #{sexId,jdbcType=CHAR}, \n" +
            "      #{mzId,jdbcType=CHAR}, #{zzmmId,jdbcType=CHAR}, #{sfzh,jdbcType=CHAR}, #{gbId,jdbcType=CHAR}, \n" +
            "      #{jgId,jdbcType=CHAR}, #{jtzz,jdbcType=VARCHAR}, #{bmId,jdbcType=CHAR}, #{zggwlbId,jdbcType=CHAR}, \n" +
            "      #{zgbzlbId,jdbcType=CHAR}, #{zgztId,jdbcType=CHAR}, #{xllbId,jdbcType=CHAR}, #{xlzyId,jdbcType=CHAR}, \n" +
            "      #{zwlbId,jdbcType=CHAR}, #{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{byyx,jdbcType=VARCHAR}, \n" +
            "      #{qzzp,jdbcType=VARCHAR}, #{zp,jdbcType=VARCHAR},#{status},#{zcId})")
    void saveEmp(SEmp emp);

    @Delete("delete from s_emp where user_id=#{epmId}")
    void deleteEmpByUserId(String empId);

    @Select("select s_bm.obm_id,s_bm.bm_id,s_bm.bm_name " +
            "from s_emp INNER JOIN s_bm on(s_emp.bm_id=s_bm.bm_id) where s_emp.user_id = #{empId}")
    SBm getBmByEmpId(String empId);
    @Select("select * from s_emp where user_id = #{id}")
    SEmp getEmpsById(String id);
    @Select("select * from s_emp where bm_id = #{bmId}")
    List<SEmp> listEmpByBmId(String bmId);
    @Select(" SELECT bm.bm_name,emp.user_xm,emp.user_id,emp.status, sex.sex,xllb.xllb,zwlb.zwlb,emp.byyx\n" +
            " from s_emp emp\n" +
            " LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)\n" +
            " LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
            " LEFT JOIN s_xllb xllb ON (xllb.xllb_id=emp.xllb_id)\n" +
            " LEFT JOIN s_zwlb zwlb ON (zwlb.zwlb_id=emp.zwlb_id)")
    List<EmpSelectVO> listSelectEmps();
    @Select(" SELECT bm.bm_name,emp.user_xm,emp.user_id,emp.status, sex.sex,xllb.xllb,zwlb.zwlb,emp.byyx\n" +
            " from s_emp emp\n" +
            " LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)\n" +
            " LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
            " LEFT JOIN s_xllb xllb ON (xllb.xllb_id=emp.xllb_id)\n" +
            " LEFT JOIN s_zwlb zwlb ON (zwlb.zwlb_id=emp.zwlb_id) where emp.user_xm like '%'+#{userName}+'%'")
    List<EmpSelectVO> listSelectEmpsByUserName(String userName);
    @Select(" SELECT bm.bm_name,emp.user_xm,emp.user_id,emp.status, sex.sex,xllb.xllb,zwlb.zwlb,emp.byyx\n" +
            " from s_emp emp\n" +
            " LEFT JOIN s_bm bm ON (emp.bm_id=bm.bm_id)\n" +
            " LEFT JOIN s_sex sex ON (sex.sex_id=emp.sex_id)\n" +
            " LEFT JOIN s_xllb xllb ON (xllb.xllb_id=emp.xllb_id)\n" +
            " LEFT JOIN s_zwlb zwlb ON (zwlb.zwlb_id=emp.zwlb_id) where emp.user_id=#{userId}")
    EmpSelectVO listSelectEmpsByUserId(String userId);
    @SelectProvider(type = EmpProvider.class,method = "selectEmpsByX")
    List<EmpSelectVO> listSelectEmpBybmIdAndUserId(@Param("bmId") String bmId, @Param("userId") String userId,@Param("status") String status,@Param("bmName") String bmName);
    @Select("SELECT emp2.user_id,emp2.user_xm from s_emp as emp1 INNER JOIN s_emp emp2 ON (emp1.bm_id=emp2.bm_id) " +
            "where emp1.user_id=#{userId} ")
    List<SEmp> listPartnerByUserId(String userId);
    @Select("select ur.user_id ,ep.user_xm from s_user ur LEFT JOIN s_emp ep ON(ur.user_id=ep.user_id) where \n" +
            "ur.user_id in (SELECT emp2.user_id from s_emp as emp1 INNER JOIN s_emp emp2 ON (emp1.bm_id=emp2.bm_id) where emp1.user_id=#{userId}) ")
    List<SEmp> listBmPartnerByUserId(String userId);
    @Select("select * from s_emp where user_id=#{userId}")
    EmpVO getEmpsByUserId(String userId);
    @Update("update s_emp\n" +
        "    set user_xm = #{userXm,jdbcType=VARCHAR},\n" +
        "      sex_id = #{sexId,jdbcType=CHAR},\n" +
        "      mz_id = #{mzId,jdbcType=CHAR},\n" +
        "      zzmm_id = #{zzmmId,jdbcType=CHAR},\n" +
        "      sfzh = #{sfzh,jdbcType=CHAR},\n" +
        "      gb_id = #{gbId,jdbcType=CHAR},\n" +
        "      jg_id = #{jgId,jdbcType=CHAR},\n" +
        "      jtzz = #{jtzz,jdbcType=VARCHAR},\n" +
        "      bm_id = #{bmId,jdbcType=CHAR},\n" +
        "      zggwlb_id = #{zggwlbId,jdbcType=CHAR},\n" +
        "      zgbzlb_id = #{zgbzlbId,jdbcType=CHAR},\n" +
        "      zgzt_id = #{zgztId,jdbcType=CHAR},\n" +
        "      xllb_id = #{xllbId,jdbcType=CHAR},\n" +
        "      xlzy_id = #{xlzyId,jdbcType=CHAR},\n" +
        "      zwlb_id = #{zwlbId,jdbcType=CHAR},\n" +
        "      tel = #{tel,jdbcType=VARCHAR},\n" +
        "      email = #{email,jdbcType=VARCHAR},\n" +
        "      byyx = #{byyx,jdbcType=VARCHAR},\n" +
        "      qzzp = #{qzzp,jdbcType=VARCHAR},\n" +
        "      zp = #{zp,jdbcType=VARCHAR}\n" +
        "    where user_id = #{userId,jdbcType=VARCHAR}")
    void updateEmp(SEmp emp);

    @SelectProvider(type = EmpProvider.class,method = "selectEmpByIdOrName")
    public List<JhEmpVo> getJhEmpVo(@Param("userId") String userId , @Param("userXm") String userXm);

    @Select("select bm_id from s_emp where user_id = #{userId}")
    public String getBmIdByUserId(String userId);

    @Select("select user_id from s_emp where user_xm like #{xm}")
    List<String> getIdByXm(String xm);
}
