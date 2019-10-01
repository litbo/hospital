package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.vo.BmSelectLbVO;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.BmsTreeVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BmService {
    //返回所有科室
    PageInfo getBmList(int pageNum, int pageSize);
    //返回所有科室不分頁
    List<SBm> getBmList();
    //返回所有虚科室
    PageInfo getXBmList(int pageNum, int pageSize);
    //返回所有叶子科室
    PageInfo getYZBmList(int pageNum, int pageSize);
    //返回所有虚科室
    List<SBm> getXBmList();
    //返回所有叶子科室
    List<SBm> getYZBmList();
    //返回所有管理科室
    PageInfo getGLBmList(int pageNum, int pageSize);
    //返回所有维修科室
    List<SBm> getWxBmList();
    //保存科室
    void saveBm(SBm bm);

    void updateBm(SBm bm);
    //根据父节点查科室
    PageInfo getBmListByPid(int pageNum, int pageSize, String pid);
    //根据oid查科室
    SBm getBmByOid(String id);
    //根据id查科室
    SBm getBmByBmId(String bmid);
    //模糊查詢
    PageInfo getBmListByX(int pageNum, int pageSize, BmSelectVO selectVo);
    //通过科室id刪除
    void removeBmByOBmId(String oid);
    //判断科室是否为子节点
    boolean isZJD(String oid);
    //判断科室们是否为子节点
    boolean isAllZJD(String[] bm_ids);
    //设置科室归属
    void setBmsBeto(SetBmVO bmVO);
    void setBmBeto(String obm_id, String new_pbm_id );
    //设置为维修科室
    void setWxbm(String[] obmid, int wxFlag);
    //获取所有维修科室
    List<SBm> getWxBms();
    //获取所有非维修科室
    List<SBm> getFwxBms();
    //获取所有非维修科室
    PageInfo getFwxBms(int pageNum, int pageSize);
    //获取所有非维修科室通过科室名
    PageInfo listFWXBmByBmName(int pageNum, int pageSize, String bmName);

    PageInfo listBmsAsLbBms(int pageNum, int pageSize,int flag);

    PageInfo listBmsAsLbBmsBySelectVO(int pageNum, int pageSize, BmSelectVO selectVO);

    Integer batchImportBms(String fileName, MultipartFile file)  ;

    List<BmsTreeVO> listTreeBms();

    List<SBm> listBmsByBmName(int pageNum, int pageSize,String bmName);

    List<BmSelectLbVO> listKgsBm(int pageNum, int pageSize, String bmName,String iCode);

    void adjustBmIdForEq();

    PageInfo listInitBms(int pageNum, int pageSize);

    //通过父布门递归删除
//    void removeBmByPid(String pid);
}
