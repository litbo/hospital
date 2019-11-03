package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.dao.KaoqinMapper;
import com.litbo.hospital.supervise.service.KaoqinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaoqinServiceImp implements KaoqinService {

    @Autowired
     KaoqinMapper kaoqinMapper;
    public Result insertKaoqin(KaoqinVO kaoqinVO) {
        kaoqinMapper.insertKaoqin(kaoqinVO);
        return Result.success();
    }

    @Override
    public PageInfo<KaoqinVO> listKaoqin(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo<>(kaoqinMapper.listKaoqin());
    }
}
