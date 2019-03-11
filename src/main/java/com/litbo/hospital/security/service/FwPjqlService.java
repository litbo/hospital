package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.ExaminePjqlVO;
import com.litbo.hospital.security.vo.InsertFwPjqlVo;

public interface FwPjqlService {
    int insertFwPjql(InsertFwPjqlVo insertFwPjqlVo);

    int updateFwPjqlSqStatus(Integer status, Integer id, String qrrId, String shyy, Integer taskId);

    PageInfo listFwPjqlZjb(int pageNum, int pageSize, String pjRkTimeStart, String pjRkTimeEnd, String pjName);

    ExaminePjqlVO selectFwPjqlById(Integer id);
}
