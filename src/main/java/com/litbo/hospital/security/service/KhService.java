package com.litbo.hospital.security.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface KhService {

    PageInfo kh(int pageNum,int pageSize,String id);

    boolean khBc(KhZxinxiVo ks);

    List<ListJhVos> findInfo(int pageNum,int pageSize);

    List<RenYuanVo> getYdRen(int pageNum, int pageSize, String id);

    List<RenYuanVo> getSdRen(int pageNum, int pageSize, String id);

    List<RenYuanVo> getWdRen(int pageNum, int pageSize, String id);

    List<RenYuanVo> getHgRen(int pageNum, int pageSize, String id);

    ListCanJiaVo findByPxjgIs(String id);

    ListJiGeVo findByKhjgJg(String id);

    ListSumRenVo findsumRen(String id);

    LvJcVos getPxlAndKhl(String jh_id);

    void insertLv(@Param("hgl") String khhgl,@Param("pxl") String pxl, String jh_id);

    void updateLv(@Param("pxl") String pxl,@Param("hgl") String khhgl,@Param("jh_id") String jh_id);

}
