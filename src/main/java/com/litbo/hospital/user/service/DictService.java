package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.vo.DictVo;
import com.litbo.hospital.user.bean.*;

import java.util.List;

public interface DictService {

    List<EqZjly> listZjlys();

    List<EqJldw> listJldw();

    List<EqCxfl> listCxfl();

    List<EqQdfs> listQdfs();

    List<EqGzlb> listGzlb();

    PageInfo<DictVo> listJczd(int pageNum, int pageSize);
}
