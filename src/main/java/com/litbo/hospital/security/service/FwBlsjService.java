package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.user.vo.LiveEmpVo;

import java.util.List;

public interface FwBlsjService {
    int insertFwBlsj(FwBlsj blsj, LiveEmpVo sEmp);
    PageInfo listFwBlsj(int pageNum, int pageSize, String cpmc, String bgrXm);

    FwBlsj selectFwBlsjById(Integer id);

    PageInfo listFwBlsjWaitExamine(int pageNum, int pageSize, String cpmc, String bgrXm);

    int updateFwBlsjStatus(Integer status, Integer id, Integer taskId);

    List listFwBlsjExport(String cpmc, String bgrXm);
}
