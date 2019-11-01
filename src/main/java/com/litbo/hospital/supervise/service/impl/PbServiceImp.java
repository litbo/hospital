package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.dao.PbMapper;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import com.litbo.hospital.user.bean.EqFj;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

@Service
public class PbServiceImp implements PbService {

    @Autowired(required = false)
    private PbMapper pbMapper;

    @Override
    public List<RyVos> getPbPeople(int pageNum,int pageSize,String id) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.getPbPeople(id);
    }

    @Override
    public PageInfo<RyVos> getBmpeople(String bmId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(pbMapper.getBmpeople(bmId));
    }

    @Override
    public List<RyVos> ghPeople(int pageNum, int pageSize, String sid) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.ghPeople(sid);
    }

    @Override
    public List<getPbPlanVos> getPbPlan(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pbMapper.getPbPlanVos();
    }

    @Override
    public void addPbPlan(PbJhVO pbJhVO) {
        try{
            String pbJhid = UUID.randomUUID().toString();
            String ids[] = pbJhVO.getUserId().split(",");
            for(int i=0; i<ids.length; i++){
                pbJhVO.setUserId(ids[i]);
                pbJhVO.setPbJhid(pbJhid);
                System.out.println(pbJhVO);
                pbMapper.addPbPlan(pbJhVO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Result insertKaoqin(KaoqinVO kaoqinVO) {
        pbMapper.insertKaoqin(kaoqinVO);
        return Result.success();
    }

}
