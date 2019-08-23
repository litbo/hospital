package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.bean.SgDhdj;
import com.litbo.hospital.lifemanage.bean.vo.DhdjksjsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgDhdjVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 到货登记表Mapper接口
 */
@Mapper
public interface SgDhdjMapper {


    /**
     * 添加到货登记信息
     *
     * @param sgDhdj 到货登记信息
     * @return 添加记录数
     */

    /*如果全部到货添加进sg_dhdj，否则进记录表里*/
    @Insert(" insert into sg_dhdj (dhdj_id, dhdj_shdw, dhdj_fhdw, \n" +
            "      dhdj_shr, dhdj_fhr, dhdj_shrdh, \n" +
            "      dhdj_fhrdh, dhdj_mdd, dhdj_fhd, \n" +
            "      dhdj_shxxdz, dhdj_fhxxdz, dhsj, \n" +
            "      dhdj_wlgs, dhdj_bjgs, dhdj_ysdh, \n" +
            "      dhdj_byfy, dhdj_ysfs, dhdj_jsr, \n" +
            "      dhdj_cfdd, ht_id, sg_id, \n" +
            "      dhdj_fhxs, dhdj_sdxs, dhdj_csxs, \n" +
            "      dhdj_bz, dhdj_isqbdh, extend_one, \n" +
            "      extend_two)\n" +
            "    values (#{dhdjId,jdbcType=VARCHAR}, #{dhdjShdw,jdbcType=VARCHAR}, #{dhdjFhdw,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShr,jdbcType=VARCHAR}, #{dhdjFhr,jdbcType=VARCHAR}, #{dhdjShrdh,jdbcType=VARCHAR}, \n" +
            "      #{dhdjFhrdh,jdbcType=VARCHAR}, #{dhdjMdd,jdbcType=VARCHAR}, #{dhdjFhd,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShxxdz,jdbcType=VARCHAR}, #{dhdjFhxxdz,jdbcType=VARCHAR}, #{dhsj,jdbcType=DATE}, \n" +
            "      #{dhdjWlgs,jdbcType=VARCHAR}, #{dhdjBjgs,jdbcType=VARCHAR}, #{dhdjYsdh,jdbcType=INTEGER}, \n" +
            "      #{dhdjByfy,jdbcType=DECIMAL}, #{dhdjYsfs,jdbcType=VARCHAR}, #{dhdjJsr,jdbcType=VARCHAR}, \n" +
            "      #{dhdjCfdd,jdbcType=VARCHAR}, #{htId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, \n" +
            "      #{dhdjFhxs,jdbcType=INTEGER}, #{dhdjSdxs,jdbcType=INTEGER}, #{dhdjCsxs,jdbcType=INTEGER}, \n" +
            "      #{dhdjBz,jdbcType=VARCHAR}, #{dhdjIsqbdh,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "      #{extendTwo,jdbcType=VARCHAR})")
    int insertSgDhdj(SgDhdj sgDhdj);

    @Insert(" insert into sg_dhdj_log (dhdj_id, dhdj_shdw, dhdj_fhdw, \n" +
            "      dhdj_shr, dhdj_fhr, dhdj_shrdh, \n" +
            "      dhdj_fhrdh, dhdj_mdd, dhdj_fhd, \n" +
            "      dhdj_shxxdz, dhdj_fhxxdz, dhsj, \n" +
            "      dhdj_wlgs, dhdj_bjgs, dhdj_ysdh, \n" +
            "      dhdj_byfy, dhdj_ysfs, dhdj_jsr, \n" +
            "      dhdj_cfdd, ht_id, sg_id, \n" +
            "      dhdj_fhxs, dhdj_sdxs, dhdj_csxs, \n" +
            "      dhdj_bz, dhdj_isqbdh, extend_one, \n" +
            "      extend_two)\n" +
            "    values (#{dhdjId,jdbcType=VARCHAR}, #{dhdjShdw,jdbcType=VARCHAR}, #{dhdjFhdw,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShr,jdbcType=VARCHAR}, #{dhdjFhr,jdbcType=VARCHAR}, #{dhdjShrdh,jdbcType=VARCHAR}, \n" +
            "      #{dhdjFhrdh,jdbcType=VARCHAR}, #{dhdjMdd,jdbcType=VARCHAR}, #{dhdjFhd,jdbcType=VARCHAR}, \n" +
            "      #{dhdjShxxdz,jdbcType=VARCHAR}, #{dhdjFhxxdz,jdbcType=VARCHAR}, #{dhsj,jdbcType=DATE}, \n" +
            "      #{dhdjWlgs,jdbcType=VARCHAR}, #{dhdjBjgs,jdbcType=VARCHAR}, #{dhdjYsdh,jdbcType=INTEGER}, \n" +
            "      #{dhdjByfy,jdbcType=DECIMAL}, #{dhdjYsfs,jdbcType=VARCHAR}, #{dhdjJsr,jdbcType=VARCHAR}, \n" +
            "      #{dhdjCfdd,jdbcType=VARCHAR}, #{htId,jdbcType=VARCHAR}, #{sgId,jdbcType=VARCHAR}, \n" +
            "      #{dhdjFhxs,jdbcType=INTEGER}, #{dhdjSdxs,jdbcType=INTEGER}, #{dhdjCsxs,jdbcType=INTEGER}, \n" +
            "      #{dhdjBz,jdbcType=VARCHAR}, #{dhdjIsqbdh,jdbcType=VARCHAR}, #{extendOne,jdbcType=VARCHAR}, \n" +
            "      #{extendTwo,jdbcType=VARCHAR})")
    int insertSgDhdjLog(SgDhdj sgDhdj);

 /*   *//**
     * 到货登记科室接收列表
     *
     * @param ksId 科室id
     * @return List<DhdjksjsVO>
     */
    @Select("SELECT\n" +
            "dbo.sg_djhw.djhw_id,\n" +
            "dbo.sg_dhdj.ht_id,\n" +
            "dbo.sg_dhdj.sg_id,\n" +
            "dbo.sg_dhdj.dhdj_fhdw,\n" +
            "dbo.sg_dhdj.dhdj_ysdh,\n" +
            "dbo.sg_info.bh,\n" +
            "dbo.sg_dhdj.dhsj,\n" +
            "dbo.sg_dhdj.dhdj_cfdd,\n" +
            "dbo.sg_dhdj.dhdj_sdxs\n" +
            "\n" +
            "FROM\n" +
            "dbo.sg_dhdj\n" +
            "INNER JOIN dbo.sg_djhw ON dbo.sg_djhw.dhdj_id = dbo.sg_dhdj.dhdj_id\n" +
            "INNER JOIN dbo.sg_info ON dbo.sg_djhw.sg_id = dbo.sg_info.id\n" +
            " WHERE \n" +
            "dbo.sg_info.bm_id = #{ksId,jdbcType=VARCHAR} AND\n" +
            "dbo.sg_dhdj.dhdj_isqbdh = '1'")
    List<DhdjksjsVO> selectDjhwKsjs(String ksId);

    /**
     * 科室接收货物详情信息
     *
     * @param djhwId 到货登记id
     * @return SgDhdjVO
     */
    @Select("SELECT\n" +
            "dbo.sg_dhdj.dhdj_shdw,\n" +
            "dbo.sg_dhdj.dhdj_fhdw,\n" +
            "dbo.sg_dhdj.dhdj_shr,\n" +
            "dbo.sg_dhdj.dhdj_fhr,\n" +
            "dbo.sg_dhdj.dhdj_shrdh,\n" +
            "dbo.sg_dhdj.dhdj_fhrdh,\n" +
            "dbo.sg_dhdj.dhdj_fhd,\n" +
            "dbo.sg_dhdj.dhdj_shxxdz,\n" +
            "dbo.sg_dhdj.dhdj_fhxxdz,\n" +
            "dbo.sg_dhdj.dhsj,\n" +
            "dbo.sg_dhdj.dhdj_wlgs,\n" +
            "dbo.sg_dhdj.dhdj_bjgs,\n" +
            "dbo.sg_dhdj.dhdj_ysdh,\n" +
            "dbo.sg_dhdj.dhdj_byfy,\n" +
            "dbo.sg_dhdj.dhdj_ysfs,\n" +
            "dbo.sg_dhdj.dhdj_jsr,\n" +
            "dbo.sg_dhdj.dhdj_cfdd,\n" +
            "dbo.sg_dhdj.ht_id,\n" +
            "dbo.sg_dhdj.dhdj_fhxs,\n" +
            "dbo.sg_dhdj.dhdj_sdxs,\n" +
            "dbo.sg_dhdj.dhdj_csxs,\n" +
            "dbo.sg_dhdj.dhdj_mdd\n" +
            "FROM\n" +
            "dbo.sg_dhdj\n" +
            "INNER JOIN dbo.sg_djhw ON dbo.sg_dhdj.dhdj_id = dbo.sg_djhw.dhdj_id\n" +
            "WHERE\n" +
            "dbo.sg_djhw.djhw_id = #{djhwId,jdbcType=VARCHAR}")
    SgDhdj selectSgDhdjDetails(String djhwId);

    /*科室到货登记的时候选择合同编号* */
    @Select("select DISTINCT dbo.eq_ht.ht_bianhao from eq_ht where  dbo.eq_ht.ht_bianhao \n" +
            "             NOT IN (select dbo.sg_dhdj.ht_id from dbo.sg_dhdj) order by dbo.eq_ht.ht_bianhao" )
    List<String> selectHtBianhaos();

    /*查询到货登记表里面的所有合同号*/
    @Select("select dbo.sg_dhdj.ht_id from dbo.sg_dhdj order by dbo.sg_dhdj.ht_id ")
    List<String> selectDhdjHtids();
    /*查询记录表里的合同编号/将分批到货的合同id也加入*/
    @Select("select distinct dbo.eq_ht.ht_bianhao from eq_ht where  dbo.eq_ht.ht_bianhao " +
            " IN (select dbo.sg_dhdj_log.ht_id from dbo.sg_dhdj_log where dbo.sg_dhdj_log.dhdj_isqbdh='0')" +
            "  order by dbo.eq_ht.ht_bianhao " )
    List<String> selectHtBianhaos2();

    /*将全部到货的合同记录表里的数据弄到到货登记表里面去*/
    @Select("SELECT * \n" +
            "FROM\n" +
            "dbo.sg_dhdj_log\n" +
            "WHERE\n" +
            "dbo.sg_dhdj_log.dhdj_isqbdh ='1' ")
    List<SgDhdj> selectDhdjLogQbdh();

    /*在到货登记记录表查询同一个到货登记记录的最后一条*/
    @Select("select top 1 * from sg_dhdj_log where ht_id=#{htid} ORDER BY dhsj desc ")
    SgDhdjVO selectLastOneDhdjLog(String htid);

    @Select("select * from sg_dhdj_log\n" +
            " inner join sg_djhw_log on sg_dhdj_log.dhdj_id=sg_djhw_log.dhdj_id\n" +
            " where sg_djhw_log.djhw_id=#{djhwid} ")
    SgDhdj selectOneDhdjLog(String djhwid);
    /**/
    /*查看到货登记ji里面的所有数据*/
    @Select("select * from sg_dhdj")
    List<SgDhdjVO> selectAllDhdj();

    /*根据合同编号查询记录表里的记录*/
    @Select("select * from sg_dhdj_log where ht_id=#{htid} order by dhsj desc")
    List<SgDhdjVO> selectDhdjLogByHtid(String htid);

    /*根据合同编号查询到货登记一条记录*/
    @Select("select * from sg_dhdj where ht_id=#{htid}")
    List<SgDhdjVO> selectSgDhdjOneByHtid(String htid);
    /*删除到货登记记录*/
    @Delete("delete from sg_dhdj where ht_id=#{htid}")
    int deleteDhdjByHtid(String htid);
    /*删除到货登记记录表记录*/
    @Delete("delete from sg_dhdj_log where ht_id=#{htid}")
    int deleteDhdjJlByHtid(String htid);
    /*删除登记货物记录*/
    @Delete("delete from sg_djhw where djhw_htid=#{htid}")
    int deleteDjhwByHtid(String htid);
    /*删除登记货物记录表记录*/
    @Delete("delete from sg_djhw_log where djhw_htid=#{htid}")
    int deleteDjhwJlByHtid(String htid);
    /*删除验收记录*/
    @Delete("delete from sg_ys where ht_id=#{htid}")
    int deleteYsByHtid(String htid);
}