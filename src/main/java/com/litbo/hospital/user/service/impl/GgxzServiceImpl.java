package com.litbo.hospital.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.FileUtil;
import com.litbo.hospital.common.utils.UploadFile;
import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.dao.GgxzDao;
import com.litbo.hospital.user.service.GgxzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class GgxzServiceImpl implements GgxzService {
    @Autowired
    private GgxzDao ggxzDao;
    @Override
    public int addGgxz(MultipartFile multipartFile, SysGgxz ggxz) {
        String filePath ="F:\\file\\";
       /* String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        UploadFile file = new UploadFile(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        try {

            multipartFile.transferTo(new UploadFile(filePath+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = filePath+newFileName;*/
        String url = UploadFile.upload(filePath,multipartFile);
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
