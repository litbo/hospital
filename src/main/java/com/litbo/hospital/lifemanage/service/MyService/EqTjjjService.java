package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjShowVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqTjjjVO;

public interface EqTjjjService {

     int insertTjjj(EqTjjjVO tjjj);

     PageInfo<EqTjjjShowVO> selectByExample(Integer pageNum, Integer pageSize, EqTjjjShowVO vo);

     EqTjjjVO selectByPrimaryKey(String id);

}
