package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.vo.DictVo;
import com.litbo.hospital.user.bean.*;

import java.util.List;

public interface DictService {

    List<EqZjly> listZjlys();

    List<EqJldw> listJldw();

    List<EqCxfl> listCxfl();

    List<EqQdfs> listQdfs();

    List<EqGzlb> listGzlb();

    PageInfo listJczd(int pageNum, int pageSize);

    PageInfo listDictByTName(int pageNum, int pageSize, String tName);

    PageInfo listZyzd(int pageNum, int pageSize);

    Integer addDictByTName(String tName, String dictName);
}
