package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.YjyaZdVO;

import java.util.Date;
import java.util.List;

public interface YjyaZdService {

    /*应急预案制定*/
    int insertYjyaZd(YjyaZdVO vo);

    /*应急预案一般修改*/
    int updateYjyaZd(YjyaZdVO vo);
    /*应急预案试用时间修改*/
    int updateShYjyaZd(YjyaZdVO vo);

    /*查询或条件查询所有待普通审核预案*/
    List<YjyaZdVO> selectAllPtYa(String bh, String mc, String ngr, Date qssj, Date jssj);

    /*查询或条件查询所有再评价*/
    List<YjyaZdVO> selectAllZpjYa(String bh, String mc, String ngr, Date qssj, Date jssj);

    /*查询上面两个审核总和*/
    PageInfo<YjyaZdVO> selectAllSh(Integer pageNum, Integer pageSize, String bh, String mc, String ngr, Date qssj, Date jssj);
}
