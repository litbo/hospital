package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SetPmVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EqService {


    List<EqVo> getAllEq();

    PageInfo listShowEqs(int pageNum, int pageSize);

    int addEq(EqInfo eqInfo, MultipartFile sbzp, MultipartFile mpzp);

    PageInfo listEqByX(int pageNum, int pageSize, SelectEqVo selectEqVo);

    Integer importEq(MultipartFile file) ;

    Integer setPm(SetPmVo setPmVo);
}
