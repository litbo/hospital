package com.litbo.hospital.efficiency.configratio.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.configratio.bean.FunctionUsingBean;
import com.litbo.hospital.efficiency.configratio.dao.FunctionUsingDAO;
import com.litbo.hospital.efficiency.configratio.service.FunctionUsingService;
import com.litbo.hospital.efficiency.configratio.vo.FunctionUsingRatioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 功能利用率Service层
 * @author: sz
 * @date: 2019/8/29 11:15
 */
@Service
public class FunctionUsingServiceImpl implements FunctionUsingService {

    @Autowired
    private FunctionUsingDAO usingDAO;

    /**
     * 添加功能利用率的相关信息
     * @param usingBean 信息参数
     * @return 返回插入的条数
     */
    @Override
    public Integer addFunctionUsing(FunctionUsingBean usingBean) {
        if (usingDAO.selectUsingByEqBh(usingBean.getEqSbbh())==null){
            usingBean.setRatio(Double.valueOf(Efficiency.result(usingBean.getUsingNum(),usingBean.getExitNum())));
            return usingDAO.addFunctionUsing(usingBean);
        }else {
            return 0;
        }
    }

    /**
     * 查询功能利用率
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 功能利用率
     */
    @Override
    public PageInfo showUsing(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(usingDAO.showUsing());
    }

    /**
     * 根据设备Id查询设备的功能利用率
     * @param id 设备id
     * @return 返回设备信息
     */
    @Override
    public FunctionUsingRatioVO showUsingById(Integer id) {
        return usingDAO.showUsingUsingById(id);
    }

    /**
     * 更改功能利用率
     * @param usingRatioVO 功能利用率
     * @return 更改后的功能利用率
     */
    @Override
    public Integer updateUsing(FunctionUsingRatioVO usingRatioVO) {
        if (usingDAO.selectUsingByEqBh(usingRatioVO.getEqSbbh())==null||
                usingDAO.selectUsingByEqBh(usingRatioVO.getEqSbbh())==1){
            usingRatioVO.setRatio(Efficiency.result(usingRatioVO.getUsingNum(),usingRatioVO.getExitNum()));
            return usingDAO.updateUsing(usingRatioVO);
        }else {
            return 0;
        }
    }

    /**
     * 批量删除功能完好率
     * @param ids id
     * @return 共删除几条
     */
    @Override
    public Integer deleteUsing(Integer[] ids) {
        return usingDAO.deleteUsing(ids);
    }
}
