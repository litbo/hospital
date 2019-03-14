package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBlsj;
import com.litbo.hospital.security.vo.SelectFwBlsjById;

import java.util.List;

public interface FwBlsjService {
    int insertFwBlsj(FwBlsj blsj);
    PageInfo listFwBlsj(int pageNum, int pageSize,String sjxz,String bmName,String sbcsName,String bgmc);

    SelectFwBlsjById selectFwBlsjById(Integer id);
}
