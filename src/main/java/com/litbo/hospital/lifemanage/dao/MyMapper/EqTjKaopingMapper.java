package com.litbo.hospital.lifemanage.dao.MyMapper;

import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingKsListVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjKaoPingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EqTjKaopingMapper {

/**根据装备调出表的id查询出所有有此id的交接记录表,
 * 比较里面的装备编码,不匹配的即为未送达，并统计数量,
 * 根据调剂申请id查询出所有装备调出记录的编号,调配时间,
 * 调配数量,指挥长
 * 根据装备调出Id查询科室信息
 * */
    /*根据调剂申请id查询所有装备调出编号,
    只查询已经送达的调配单 */
    @Select("select id,tj_dpsj dpsj,tj_tpsl dpcount,tj_zhz zhz from tj_zbdc where tj_sqtj=#{sqtjid}" +
            " and tj_dcjd='1'")
    List<EqTjKaoPingVO> getAllZongKaoPing(String sqtjid);

    /*根据调剂申请id查询事件性质*/
    @Select("select tj_sfyl from eq_tjsq where id=#{id}")
    String getSfylBySqid(String id);

    /*根据装备调出id查询当前调配单的需要送达的设备和科室信息*/
    @Select(" select tj_dcks bmid ,tj_zbbm zbmc,tj_tpsl count from tj_zbdc where " +
            " id=#{dpdid}")
    List<EqTjKaoPingKsListVO> getAllTjKs(String dpdid);

    /*根据装备调出Id查询已经交接的装备信息*/
    @Select("select tjjj_bianma from eq_tjjj where tjjj_zbdcid=#{dpdid}")
    List<String> getAllTjjjZbs(String dpdid);


}
