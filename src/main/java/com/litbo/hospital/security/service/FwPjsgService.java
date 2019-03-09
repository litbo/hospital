package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjsg;
import com.litbo.hospital.security.vo.ExaminePjsgVO;
import com.litbo.hospital.security.vo.InsertFwPjsgVo;

public interface FwPjsgService {
    int insertFwPjsg(InsertFwPjsgVo insertFwPjsgVo);

    PageInfo listFwPjsg(FwPjsg pjsg,int pageNum,int pageSize);

    int updateFwPjsgStatus(int sgStatus, String currentUserId,int id);

    PageInfo listFwPjsgZjb(int pageNum, int pageSize, String pjRkTimeStart, String pjRkTimeEnd, String pjName);

    ExaminePjsgVO selectFwPjsgById(Integer id, Integer taskId);
}
