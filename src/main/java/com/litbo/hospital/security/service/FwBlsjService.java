package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.vo.SelectFwBlsjById;
import com.litbo.hospital.user.vo.LiveEmpVo;

public interface FwBlsjService {
    int insertFwBlsj(FwBlsj blsj, LiveEmpVo sEmp);
    PageInfo listFwBlsj(int pageNum, int pageSize,String sjxz,String bmName,String sbcsName,String bgmc);

    SelectFwBlsjById selectFwBlsjById(Integer id);

    PageInfo listFwBlsjWaitExamine(int pageNum, int pageSize, String sjxz, String bmName, String sbcsName, String bgmc);

    int updateFwBlsjStatus(Integer status, Integer id, Integer taskId);
}
