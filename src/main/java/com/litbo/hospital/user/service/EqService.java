package com.litbo.hospital.user.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchEqVO;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqFj;
import com.litbo.hospital.user.bean.EqInfo;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.bean.EqSyxz;
import com.litbo.hospital.user.vo.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EqService {


    List<EqVo> getAllEq();

    PageInfo listShowEqs(int pageNum, int pageSize);
    PageInfo listEqByX(int pageNum, int pageSize, SelectEqVo selectEqVo);
    int addEq(EqInfoVo eqInfo);

    Integer importEq(MultipartFile file) ;

    Integer setPm(SetPmVo setPmVo);

    Integer updateEq(EqInfoVo eqInfo);

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

    String uploadFile(MultipartFile multipartFile);

    Integer delEq(String eqId);

    List<EqPm> listPmTree();

    PageInfo listWFlEqByX(int pageNum, int pageSize, SelectFlEqVo selectFlEqVo);

    EqPm getPmById(String eqPmId);

    PageInfo listEqName(int pageNum, int pageSize);

    PageInfo listEqNameByX(int pageNum, int pageSize, String ccname);
    /**
     * 根据条件查询
     * @param searchVO
     * @return
     */
    PageInfo selectAllBy(Integer pageNum, Integer pageSize,
                         SearchEqVO searchVO);
    /**
     * 根据条件查询
     * @param searchVO
     * @return
     */
    PageInfo selectAllBy2(Integer pageNum, Integer pageSize,
                         SearchEqVO searchVO);
}
