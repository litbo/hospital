package com.litbo.hospital.security.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.bean.FwPjzd;

import java.util.List;

public interface FwPjzdService {
    List<FwPjzd> listPjzd();
    int insetFwPjzd(FwPjzd pjzd);
}
