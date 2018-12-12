package com.litbo.hospital.security.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjk;
import org.apache.ibatis.annotations.Select;

public interface FwPjkService {
    PageInfo listFwPjk(int pageNum,int pageSize);

}
