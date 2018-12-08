package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.bean.vo.SgKstlVO;

import java.util.List;

/**
 * 科室讨论表Service接口
 */
public interface SgKstlService {
    /**
     * 添加科室讨论信息
     *
     * @param sgKstl  科室讨论实体对象
     * @param usersId 参加讨论的人员集合
     * @param pmId    设备品名ID
     * @return 添加是否成功
     */
    boolean insertSgKstl(SgKstl sgKstl, List<String> usersId, List<Integer> pmId);

    /**
     * 通过部门id查询讨论表的id
     *
     * @param bmId 部门ID
     * @return 部门所有的讨论表ID
     */
    List<String> selectSgKstlIdsByBmId(String bmId);

    /**
     * 通过部门id查询所有的品名ID
     *
     * @param bmId 部门ID
     * @return 部门讨论的所有需购买设备的品名列表
     */
    List<Integer> selectSgTlPmPmIdsByBmId(String bmId);

    List<SgKstlVO> selectSgKstlVOByPmIds(List<Integer> pmId);
    /**
     * 显示部门下的所有讨论的设备
     *
     * @param userId     登陆人id
     * @param eqPmName 设备名称
     * @param eqPmJc   设备简称
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgKstlVO
     */
    PageInfo<SgKstlVO> selectSgKstlSbs(String userId,String eqPmName,String eqPmJc,Integer pageNum,Integer pageSize);
}
