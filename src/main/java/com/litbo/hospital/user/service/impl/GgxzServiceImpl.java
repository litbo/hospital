package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.FileUtil;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.poi.ChangeFile;
import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.dao.GgxzDao;
import com.litbo.hospital.user.service.GgxzService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class GgxzServiceImpl implements GgxzService {
    @Autowired
    private GgxzDao ggxzDao;
    @Override
    public int addGgxz(SysGgxz ggxz) {

        String path = System.getProperty("user.dir");
        String filePath = path+"/wjxz/";
        java.io.File file = new java.io.File(filePath);
        String name =  UUID.randomUUID().toString()+ggxz.getUrl().substring(ggxz.getUrl().lastIndexOf("."));
        String url = filePath+ name;
        try {
            if(!file.exists()){
                file.mkdirs();
            }
            ChangeFile.changeFile(ggxz.getUrl(),url);
            ChangeFile.deleteDir(path+"/tmp/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ggxz.setUrl("/"+name);
        ggxz.setStatus(0);

        return ggxzDao.addGgxz(ggxz);

    }

    @Override
    public PageInfo listGgxzs(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(ggxzDao.listGgxzs());
    }

    @Override
    public int ggxzPass(Integer id) {
        return ggxzDao.ggxzPass(id);
    }

    @Override
    public int ggxzFail(Integer id) {
        return ggxzDao.ggxzFail(id);
    }

    @Override
    public PageInfo listWaits(int pageNum, int pageSize,String wjmc) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysGgxz> list = ggxzDao.listWaits();
        if(StringUtils.isNotBlank(wjmc)){
            list.removeIf(sysGgxz -> !sysGgxz.getWjmc().contains(wjmc));
        }
        return new PageInfo(list);
    }

    @Override
    public SysGgxz getGgxzById(Integer id) {
        SysGgxz ggxz = ggxzDao.getGgxzById(id);
        return ggxz;
    }

    @Override
    public Integer delGgxz(Integer[] ggxzids) {
       return ggxzDao.delGgxz(ggxzids);
    }
}
