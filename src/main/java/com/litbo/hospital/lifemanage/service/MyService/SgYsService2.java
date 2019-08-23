package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgHzYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgJsYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgLcYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgSwYsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;


import java.util.List;
import java.util.Map;

/**
 * @author NCH
 */
public interface SgYsService2 {
    /**
     * 查询本科室待商务验收设备
     */
    PageInfo<SgYsListVO> sgWaitSwYsList(Integer pageNum, Integer pageSize, String ksid, String htid);

    /**
     * 添加商务验收记录
     */
    int insertSw(SgSwYsVO sw);

    /**
     * 查询本科室待技术验收设备
     */
    PageInfo<SgYsListVO> sgWaitJsYsList(Integer pageNum, Integer pageSize, String ksid, String htid);

    /**
     * 插入技术验收情况
     */

    int insertJs(SgJsYsVO js);

    /**
     * 本科室待临床验收设备查询
     */
    PageInfo<SgYsListVO> sgWaitLcYsList(Integer pageNum, Integer pageSize, String ksid, String htid);

    /**
     * 插入临床验收情况
     */
    int insertLc(SgLcYsVO lc);

    /**
     * 本科室待验收汇总设备查询
     */
    PageInfo<SgYsListVO> sgWaitHzYsList(Integer pageNum, Integer pageSize, String ksid, String htid);

    /**
     * 插入验收情况汇总
     */
    int insertHz(SgHzYsVO hz);

    /*查看本科室所有商务验收记录*/
    PageInfo sgBenBmSwYsList(Integer pageNum, Integer pageSize,
                             String ksid,
                             String htid,
                             String xnsb);

    /**
     * 查看本科室所有技术验收记录
     */

    PageInfo sgBenBmJsYsList(Integer pageNum, Integer pageSize,
                             String ksid,
                             String htid,
                             String xnsb);

    /**
     * 查看本科室所有临床验收记录
     */
    PageInfo sgBenBmLcYsList(Integer pageNum, Integer pageSize,
                             String ksid,
                             String htid,
                             String xnsb);

    /**
     * 查看本科室所有汇总验收记录
     */
    PageInfo sgBenBmHzYsList(Integer pageNum, Integer pageSize,
                             String ksid,
                             String htid,
                             String xnsb);

    /*查看所有验收记录*/

    PageInfo selectAllYsJl(Integer pageNum, Integer pageSize,
                           String htid, String bmid);

    /**
     * 查询所有科室的部门id和部门名字
     */
    List<Map<String, String>> selectAllBmIdAndName();


}
