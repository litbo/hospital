package com.litbo.hospital.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.dao.JhRyLrDao;
import com.litbo.hospital.security.dao.JhZdDao;
import com.litbo.hospital.security.service.JhZdService;
import com.litbo.hospital.security.vo.JhZdVo;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.supervise.vo.JhEmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjc
 * @create 2018-11-29 14:52
 * 计划service层
 */
@Service
public class JhZdServiceImpl implements JhZdService {

    @Autowired
    private JhZdDao jhZdDao;

    @Autowired
    private JhRyLrDao jhRyLrDao;

    @Autowired
    private EmpDao empDao;

    @Override
    public PageInfo<JhEmpVo> jhryList(Integer pageNum,Integer pageSize, String userId, String userXm) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<JhEmpVo> pageInfo = new PageInfo<>(empDao.getJhEmpVo(userId,userXm));
        return pageInfo;
    }

    /**
     * 计划添加
     * @param jhZd
     * @return
     */
    @Override
    @Transactional
    public Result addJhZd(JhZd jhZd) {
        int i = jhZdDao.addJhZd(jhZd);
        if(i>0){
            return Result.success();
        }
        return Result.error("添加失败");
    }

    /**
     * 条件分页查询
     * @return
     */
    public Result listJhZd(int pageNum, int pageSize, String createdate,String jhName){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<JhZdVo> pageInfo = new PageInfo<>(jhZdDao.jhzdList(createdate,jhName));
        return Result.success(pageInfo);
    }

    @Override
    public Result jhrylrListIndex(int pageNum, int pageSize, String createdate, String jhName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<JhZdVo> pageInfo = new PageInfo<>(jhZdDao.jhrylrListIndex(createdate,jhName));
        return Result.success(pageInfo);
    }

    @Override
    public Result jhryKhListIndex(int pageNum, int pageSize, String createdate, String jhName) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<JhZdVo> pageInfo = new PageInfo<>(jhZdDao.jhryKhListIndex(createdate,jhName));
        return Result.success(pageInfo);
    }

    @Override
    public JhZd jhrylrIndex(Integer id) {
        return jhZdDao.getJhzdById(id);
    }

}
