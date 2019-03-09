package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqSyxz;
import com.litbo.hospital.user.vo.EqVo;
import com.litbo.hospital.user.vo.SelectEqVo;
import com.litbo.hospital.user.vo.SelectFlEqVo;
import com.litbo.hospital.user.vo.SetPmVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EqService {


    List<EqVo> getAllEq();

    PageInfo listShowEqs(int pageNum, int pageSize);

    int addEq(EqInfo eqInfo, MultipartFile sbzp, MultipartFile mpzp);

    PageInfo listEqByX(int pageNum, int pageSize, SelectEqVo selectEqVo);

    Integer importEq(MultipartFile file) ;

    Integer setPm(SetPmVo setPmVo);

    Integer updateEq(EqInfo eqInfo);

    EqInfo getEqById(String eqId);

    PageInfo listPms(int pageNum, int pageSize);

    PageInfo listFlEq(int pageNum, int pageSize);

    PageInfo listWFlEq(int pageNum, int pageSize);

    Integer cancelFl(String eqId);

    PageInfo listPmsByPym(int pageNum, int pageSize, String pym);

    List<EqSyxz> listSyxz();

    Integer saveFj(EqFj eqFj);

    Integer importFj(MultipartFile file);

    PageInfo listFlEqByX(int pageNum, int pageSize, SelectFlEqVo selectFlEqVo);
}
