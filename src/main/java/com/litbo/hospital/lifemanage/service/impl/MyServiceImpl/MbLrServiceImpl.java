package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.MyBean.MbLr;
import com.litbo.hospital.lifemanage.dao.MyMapper.MbLrMapper;
import com.litbo.hospital.lifemanage.service.MyService.MbLrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbLrServiceImpl implements MbLrService {
    @Autowired
    MbLrMapper mapper;

    @Override
    public int insertMbLr(MbLr mb) {
        String id = IDFormat.getIdByIDAndTime("mb_lr", "id");
        mb.setId(id);
        return mapper.insertMbLr(mb);
    }

    @Override
    public PageInfo<MbLr> selectAllMb(String mbmc) {
        List<MbLr> list = mapper.selectAllMb(mbmc);
        return new PageInfo<>(list);
    }

    @Override
    public MbLr selectOneMb(String id) {
        MbLr lr = mapper.selectOneMb(id);
        return lr;
    }

    @Override
    public int updateMb(MbLr mb) {
        MbLr oldlr = mapper.selectOneMb(mb.getId());

        BeanUtil.copyProperties(mb, oldlr, true,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        return mapper.updateMb(oldlr);
    }

    @Override
    public int deleteMbByid(String id) {
        return mapper.deleteMbByid(id);
    }
}
