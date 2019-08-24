package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgPd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SgPdMapper {

    /**
     * 插入盘点扫描到的编号
     *
     * @return
     */
    @Insert({
            "insert into sg_pd (pd_id ,pd_scan_id, pd_czr, pd_jhid )",
            "values (#{pdId,jdbcType=VARCHAR},#{pdScanId,jdbcType=VARCHAR}," +
                    "#{pdCzr,jdbcType=VARCHAR},#{pdJhid,jdbcType=VARCHAR})"})
    int insertPdId(SgPd record);

    /**
     * 查询pdScanId是否重复
     * @param pdScanId
     * @return
     */
    @Select("select pd_scan_id from sg_pd where pd_scan_id = #{pdScanId,jdbcType=VARCHAR}")
    String selectScanId(String pdScanId);

    /**
     * 查询所有插入的扫描到的编号
     * @param pdJhid
     */
    @Select("select pd_scan_id from sg_pd where pd_jhid = #{pdJhid,jdbcType=VARCHAR}")
    List<String> selectAllData(String pdJhid);

    /**
     * 对应设备编号（品名）的设备名字
     * @param pdSbbh
     * @return
     */
    @Select("select eq_name from eq_info where eq_sbbh = #{pdSbbh,jdbcType=VARCHAR}")
    String selectSbbhById(String pdSbbh);

    /**
     * 对应资产编号的设备名字
     * @param pdZcId
     * @return
     */
    @Select("select eq_name from eq_info where eq_zcbh = #{pdZcId,jdbcType=VARCHAR}")
    String selectZcbhById(String pdZcId);

    /**
     * 通过科室id查出该科室下所有的设备名称
     * @param bmId
     * @return
     */
    @Select("select eq_name from eq_info where eq_bmid = #{bmId,jdbcType=VARCHAR}")
    List<String> selectNameByBmId(String bmId);

    /**
     * 根据科室id查出该科室下所有的设备编号
     */
    @Select("select eq_sbbh from eq_info where eq_bmid = #{bmId,jdbcType=VARCHAR}")
    List<String> selectSbbhByBmId(String bmId);

    /**
     * 根据科室id查出该科室下所有的资产编号
     */
    @Select("select eq_zcbh from eq_info where eq_bmid = #{bmId,jdbcType=VARCHAR}")
    List<String> selectZcbhByBmId(String bmId);
}
