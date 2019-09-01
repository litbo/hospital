package com.litbo.hospital.efficiency.configratio.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.configratio.bean.FunctionIntegrityBean;
import com.litbo.hospital.efficiency.configratio.vo.FunctionIntegrityRatioVO;

import java.util.List;

/**
 * description: 功能完好率
 * @author: sz
 * @date: 2019/8/29 11:11
 */
public interface FunctionIntegrityService {

    /**
     * 功能完好率
     * @param integrityBean 信息参数
     * @return 返回插入的条数
     */
    Integer addFunctionIntegrity(FunctionIntegrityBean integrityBean);

    /**
     * 查询功能完好率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return  返回查询功能完好率
     */
    PageInfo showIntegrity(int pageNum, int pageSize);

    /**
     * 根据id查询功能完好率
     * @param id 查询id
     * @return  返回结果
     */
    FunctionIntegrityRatioVO showIntegrityById(Integer id);

    /**
     * 更改功能完好率
     * @param integrityRatioVO 功能完好率信息
     * @return 返回更改的条数
     */
    Integer updateIntegrity(FunctionIntegrityRatioVO integrityRatioVO);

    /**
     * 批量删除功能完好率
     * @param ids 功能完好率id
     * @return 批量删除的条数
     */
    Integer deleteIntegrity(Integer[] ids);

}
