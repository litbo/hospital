package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.Cszj;
import com.litbo.hospital.supervise.bean.CsZjDeleteVO;
import com.litbo.hospital.supervise.bean.EqCszjVO;
import com.litbo.hospital.supervise.vo.CsDeleteVO;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.supervise.vo.EqCsVO;
import com.litbo.hospital.user.bean.EqCs;
import java.util.List;

public interface EqCsService {
    //获得所有厂商
    List<EqCs> listEqCs(int pageNum, int pageSize);
    List<EqCsVO> listEqCsVO(EqCsSelectVO selectVo,int pageNum, int pageSize);
    //添加数据前准备数据
    EqCsInsertReadyVO readyResource();
    //添加厂商
    void insertEqCs(EqCs eqCs);
    // 模糊级联查询
    PageInfo listEqcsByX(int pageNum, int pageSize, EqCsSelectVO selectVo);

    PageInfo listEqcsByX1(int pageNum, int pageSize, EqCsSelectVO selectVo);

    PageInfo listEqcsByX2(int pageNum, int pageSize, EqCsSelectVO selectVo);

    PageInfo listEqcsByX3(int pageNum, int pageSize, EqCsSelectVO selectVo);

    void deleteEqCs(CsDeleteVO deleteVO);

    EqCs getEqCsById(String sbcsId);

    void updateEqCs(EqCs eqCs);

    void insertCszj(Cszj cszj);

    List<EqCszjVO> listEqCszjVOByX(EqCsSelectVO selectVo, int pageNum, int pageSize);

    void deleteEqCsZj(CsZjDeleteVO deleteVO);

    EqCszjVO getCszjByCszjId(String cszjId);

    void upDateCszj(Cszj cszj);
}
