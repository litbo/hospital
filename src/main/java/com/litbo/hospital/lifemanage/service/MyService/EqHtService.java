package com.litbo.hospital.lifemanage.service.MyService;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.EqHt;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;

import java.util.List;

public interface EqHtService {

    /*录入合同*/
    Integer InsertHt(EqHt ht);


    /*展示所有合同,或条件查询*/
    PageInfo<EqHtShowVO> ListHtAccount(Integer pageNum, Integer pageSize, EqHtShowVO showVO);

    /*主键查询装备汇总*/
    String selectZbHz(String id);

    /*通过主键查询合同详情*/
    EqHt selectHtByPrimaryKey(String id);

    /*根据合同编号查询合同详情*/
    EqHt selectHtByHtId(String htid);

    /*查询所有合同编号*/
    List<String> selectHtIds();
    /*根据主键删除合同*/
    int deleteHtByPrimaryKey(String id);
    /*通过主键修改*/
    Integer updateByPrimaryId(EqHt ht);

    /*通过合同编号修改合同状态*/
    Integer updateByHtBianhao(String htBianhao, String htZt);

    /*增加设备厂商*/
    Integer addSbCs(SbCsVO vo);

    /*检测合同是否完成*/
     void loginCheckHtStatus();

    String selectCsNameById(String id);
}
