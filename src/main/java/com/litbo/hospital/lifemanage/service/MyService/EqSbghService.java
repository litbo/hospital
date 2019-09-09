package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqSbghZbVO;

import java.util.Date;

public interface EqSbghService {

    /*设备归还增加*/
    int insertEqSbgh(EqSbghVO sbgh);

    /*归还设备记录全部查询与条件查询*/
    PageInfo selectAllSbgh(Integer pageNum, Integer pageSize, String bmid, Date qssj, Date jssj, String lx);

    /*单个查归还记录*/
    EqSbghVO selectOneSbghByPrimaryKey(String id);
    /*根据设备编号查询设备调剂交接Id,所属科室和借出科室*/
    EqSbghZbVO selectEq2ByBianhao(String sbbh, String lx);

    /*根据调剂交接id查询已经归还的设备编号*/
    PageInfo selectAllSbgh(Integer pageNum, Integer pageSize, String dpjjid);

    /*根据装备编号查询调剂交接表中要还装备*/
    PageInfo  selectElseZb(Integer pageNum, Integer pageSize, String drks, String dcks);

    /*根据主键修改设备归还记录*/
    int updateEqsbghByPrimaryKey(EqSbghVO vo);

}
