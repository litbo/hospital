package com.litbo.hospital.efficiency.configratio.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.efficiency.configratio.bean.FunctionUsingBean;
import com.litbo.hospital.efficiency.configratio.vo.FunctionUsingRatioVO;

import java.util.List;

/**
 * description: 功能利用率
 * @author: sz
 * @date: 2019/8/29 11:09
 */
public interface FunctionUsingService {

    /**
     * 添加功能利用率的相关信息
     * @param usingBean 信息参数
     * @return 返回插入的条数
     */
    Integer addFunctionUsing(FunctionUsingBean usingBean);

    /**
     * 查询功能利用率
     * @param pageNum   页码
     * @param pageSize  大小
     * @return           功能利用率
     */
    PageInfo showUsing(int pageNum, int pageSize);

    /**
     * 根据设备Id查询设备的功能利用率
     * @param id 设备id
     * @return 返回设备信息
     */
    FunctionUsingRatioVO showUsingById(Integer id);

    /**
     * 更改功能利用率
     * @param usingRatioVO 功能利用率
     * @return 更改后的功能利用率
     */
    Integer updateUsing(FunctionUsingRatioVO usingRatioVO);

    /**
     * 批量删除功能完好率
     * @param list id
     * @return 共删除几条
     */
    Integer deleteUsing(List<Integer> list);

}
