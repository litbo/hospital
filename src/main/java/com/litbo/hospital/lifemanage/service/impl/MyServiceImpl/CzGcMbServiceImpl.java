package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.MyBean.CzGcMb;
import com.litbo.hospital.lifemanage.dao.MyMapper.CzGcMbMapper;
import com.litbo.hospital.lifemanage.service.MyService.CzGcMbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CzGcMbServiceImpl implements CzGcMbService {
    @Autowired
    private CzGcMbMapper mapper;

    @Override
    public int insertMb(CzGcMb mb) {
        mb.setMbId(IDFormat.getIdByIDAndTime("cz_gc_mb","mb_id"));
        return mapper.insertMb(mb);
    }

    @Override
    public CzGcMb selectOneMbByPrimaryKey(String id) {
        return mapper.selectOneMbByPrimaryKey(id);
    }

    @Override
    public PageInfo<CzGcMb> AllCzGzMb(Integer pageNum, Integer pageSize, String mbmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<CzGcMb> mbs = mapper.AllCzGzMb(mbmc);
        return new PageInfo<>(mbs);
    }
}
