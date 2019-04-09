package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.dao.GgDao;
import com.litbo.hospital.user.service.GgService;
import com.litbo.hospital.user.vo.SysGgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GgServiceImpl implements GgService {

    @Autowired
    private GgDao ggDao;
    @Autowired
    HttpServletRequest request;
    @Override
    public int addGg(SysGg gg) {
        return ggDao.addGg(gg);
    }

    @Override
    public PageInfo listShowGgs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo(ggDao.listShowGgs());
    }

    @Override
    public int checkGg(Integer id) {
        return ggDao.checkGg(id);
    }

    @Override
    public SysGgVo getGgById(Integer id) {

        return ggDao.getGgById(id);
    }

    @Override
    public PageInfo listWaits(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(ggDao.listWaits());
    }

    @Override
    public Integer addGglb(String gglxName) {
        Integer gglxId = ggDao.getLastId()+1;
        return ggDao.addGglb(gglxName,gglxId);
    }

    @Override
    public PageInfo listGgDesc(int pageNum, int pageSize) {
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+"/";
        PageHelper.startPage(pageNum, pageSize);
        List<SysGgVo> sysGgs= ggDao.listGgDesc();
        for (SysGgVo sysGg : sysGgs) {
            sysGg.setUrl(basePath + "admin/index/system/portal-management/child/ggShow.html?ggId="+sysGg.getId());
        }
        return new PageInfo(sysGgs);
    }
}
