package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.FileUtil;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.common.utils.poi.ChangeFile;
import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.dao.GgxzDao;
import com.litbo.hospital.user.service.GgxzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        String url = filePath+ UUID.randomUUID().toString()+ggxz.getUrl().substring(ggxz.getUrl().lastIndexOf("."));
        try {
            if(!file.exists()){
                file.mkdirs();
            }
            ChangeFile.changeFile(ggxz.getUrl(),url);
            ChangeFile.deleteDir(path+"/tmp/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ggxz.setUrl(url);
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
    public PageInfo listWaits(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(ggxzDao.listWaits());
    }

    @Override
    public SysGgxz getGgxzById(Integer id) {

        return ggxzDao.getGgxzById(id);
    }
}
