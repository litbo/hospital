package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlAddSgInfoVO;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlToVO;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlVO;

import java.util.List;

/**
 * 科室讨论表Service接口
 */
public interface SgKstlService {
    /**
     * 添加科室讨论信息
     *
     * @param sgKstlVO 科室讨论实体对象
     * @return 添加是否成功
     */
    boolean insertSgKstl(SgKstlVO sgKstlVO);

    /**
     * 通过科室id查询讨论表的id
     *
     * @param bmId 科室ID
     * @return 科室所有的讨论表ID
     */
    List<String> selectSgKstlIdsByBmId(String bmId);

    /**
     * 通过科室id查询所有的品名ID
     *
     * @param bmId 科室ID
     * @return 科室讨论的所有需购买设备的品名列表
     */
    List<String> selectSgTlPmPmIdsByBmId(String bmId);

    /**
     * 通过品名id查询SgKstlVO
     *
     * @param pmId 品名id
     * @return SgKstlAddSgInfoVO
     */
    List<SgKstlAddSgInfoVO> selectSgKstlVOByPmIds(List<String> pmId);

    /**
     * 显示科室下的所有讨论的设备
     *
     * @param userId   登陆人id
     * @param eqPmName 设备名称
     * @param eqPmJc   设备简称
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgKstlAddSgInfoVO
     */
    PageInfo<SgKstlAddSgInfoVO> selectSgKstlSbs(String userId, String eqPmName, String eqPmJc, Integer pageNum, Integer pageSize);

    /**
     * 查询科室讨论表信息
     * @param kstlId 科室讨论表id
     * @return SgKstlToVO
     */
    SgKstlToVO selectSgKstl(String kstlId);
}
