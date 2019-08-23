package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.EqLpjht;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SbCsVO;

public interface EqLpjService {

        /* *//*根据主键删除*/
        int deleteByPrimaryKey(String id);

        /*零配件合同录入*/
        int addLpjHt(EqLpjht ht);

        /*全部查询或选择查询*/
        PageInfo selectAll(Integer pageNum,
                           Integer pageSize,
                           EqLpjHtShowVO lpjHtShowVO);

        /*根据主键更新*/
        int updateByPrimaryKey(EqLpjht ht);

        /*根据合同编号修改合同状态*/
        int updateByJhtId(String htJhtid, String htZt);

        /*增加维修厂商*/
        int addWxCs(SbCsVO vo);

        EqLpjht selectLpjHtByPrimaryKey(String id);
        }
