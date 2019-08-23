package com.litbo.hospital.security.inspectionplan.service.serviceimpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqStandard;
import com.litbo.hospital.security.inspectionplan.bean.example.InspEqStandardExample;
import com.litbo.hospital.security.inspectionplan.dao.InspPlStandardDao;
import com.litbo.hospital.security.inspectionplan.service.InspPlStandardService;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 巡检计划标准ServiceImpl
 *
 * @author Administrator on 2019-07-31
 */
@Service
public class InspPlStandardServiceImpl implements InspPlStandardService {


    @Autowired
    private InspPlStandardDao
            inspPlStandardDao;


    public InspEqStandard selectStandardById(String inspPlStandardId){
        return inspPlStandardDao.selectStandardById(inspPlStandardId);
    }
    /**
     * 添加巡检计划标准
     * @param inspEqStandard
     * @return int
     */
    public int insertInspStandard(InspEqStandard inspEqStandard){
        String inspPlStandardId = inspEqStandard.getInspPlStandardId();
        if(!StringUtils.isNotBlank(inspPlStandardId)){
            inspEqStandard.setInspPlStandardId(GenerateId
                    .getIdByIDAndTime("z_insp_pl_standard","insp_pl_standard_id"));
        }
        return inspPlStandardDao.insertInspStandard(inspEqStandard.getInspPlStandardId(),inspEqStandard.getInspPlStandardName(),inspEqStandard.getInspPlStandardDescription());
    }

    /**
     * 功能描述: 删除巡检计划标准
     *
     * @Param: inspPlStandardIds
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 9:51
     */
    public int deleteInspStandard(String[] inspPlStandardIds){
        for (String inspPlStandardId : inspPlStandardIds) {
            inspPlStandardDao.deleteInspStandard(inspPlStandardId);
        }
        return 1;
    }

    /**
     * 功能描述: 修改巡检计划标准
     *
     * @Param: inspEqStandard
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/1 0001 10:06
     */
    public int updateInspStandard(InspEqStandard inspEqStandard){

        return inspPlStandardDao.updateInspStandard(inspEqStandard.getInspPlStandardName(), inspEqStandard.getInspPlStandardDescription(), inspEqStandard.getInspPlStandardId());
    }


    /**
     * 查询所有巡检计划标准
     *
     * @param pageNum 当前页面数
     * @param pageSize 页面记录数
     * @return PageInfo<InspEqStandard>
     */
    public PageInfo<InspEqStandard> selectInspEqStandard(int pageNum, int pageSize,
                                                         String inspPlStandardName){
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(inspPlStandardDao.selectInspEqStandard(inspPlStandardName));
    }
    public PageInfo<InspEqStandard> selectAllInspEqStandard(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(inspPlStandardDao.selectAllInspEqStandard());
    }



}
