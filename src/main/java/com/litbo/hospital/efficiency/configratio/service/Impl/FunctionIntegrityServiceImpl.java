package com.litbo.hospital.efficiency.configratio.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.calculate.Efficiency;
import com.litbo.hospital.efficiency.configratio.bean.FunctionIntegrityBean;
import com.litbo.hospital.efficiency.configratio.dao.FunctionIntegrityDAO;
import com.litbo.hospital.efficiency.configratio.service.FunctionIntegrityService;
import com.litbo.hospital.efficiency.configratio.vo.FunctionIntegrityRatioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 功能完好率Service层
 * @author: sz
 * @date: 2019/8/29 11:20
 */
@Service
public class FunctionIntegrityServiceImpl implements FunctionIntegrityService {

    @Autowired
    private FunctionIntegrityDAO integrityDAO;

    /**
     * 功能完好率
     * @param integrityBean 信息参数
     * @return 返回插入的条数
     */
    @Override
    public Integer addFunctionIntegrity(FunctionIntegrityBean integrityBean) {
        integrityBean.setRatio(Double.valueOf(Efficiency.result(integrityBean.getIntegrityNum(),integrityBean.getExitNum())));
        Integer integer = integrityDAO.addFunctionIntegrity(integrityBean);
        return integer;
    }

    /**
     * 查询功能完好率
     * @param pageNum  页码
     * @param pageSize 大小
     * @return 返回查询功能完好率
     */
    @Override
    public PageInfo showIntegrity(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(integrityDAO.showIntegrity());
    }

    /**
     * 根据id查询功能完好率
     * @param id 查询id
     * @return 返回结果
     */
    @Override
    public FunctionIntegrityRatioVO showIntegrityById(Integer id) {
        return integrityDAO.showIntegrityById(id);
    }

    /**
     * 更改功能完好率
     * @param integrityRatioVO 功能完好率信息
     * @return 返回更改的条数
     */
    @Override
    public Integer updateIntegrity(FunctionIntegrityRatioVO integrityRatioVO) {
        if (integrityDAO.selectIntegrityByeqSbbh(integrityRatioVO.getEqSbbh())!=null){
            return 0;
        }else {
            return integrityDAO.updateIntegrity(integrityRatioVO);
        }
    }

    /**
     * 批量删除功能完好率
     * @param ids 功能完好率id
     * @return 批量删除的条数
     */
    @Override
    public Integer deleteIntegrity(Integer[] ids) {
        return integrityDAO.deleteIntegrity(ids);
    }
}
