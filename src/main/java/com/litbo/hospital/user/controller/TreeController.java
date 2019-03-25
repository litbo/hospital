package com.litbo.hospital.user.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.dao.TreeDao;
import com.litbo.hospital.user.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
  * 树形结构 返回值
  * @version :
  * @author : ljl
**/
@RestController
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeDao treeDao;

/*   @RequestMapping("/wbfl")
    public Result listNoteByPid(String pid){
        List<TreeVo> T1 = treeDao.listNoteByPid("68");

        for (TreeVo t1 : T1) {
            List<TreeVo> T2 = treeDao.listNoteByPid(t1.getId());
            t1.setChildren(T2);
            for (TreeVo t2 : T2) {
                List<TreeVo> T3 = treeDao.listNoteByPid(t2.getId());
                t2.setChildren(T3);
                for (TreeVo t3 : T3) {
                    List<TreeVo> T4 = treeDao.listNoteByPid(t3.getId());
                    t3.setChildren(T4);
                }
            }
        }
        return Result.success(T1);
    }*/
    @RequestMapping("/wb")
    public Result listNoteByPid(String pid){
        List<TreeVo>  treeVos = treeDao.listNoteByPid(pid);
        return Result.success(treeVos);

    }

    @RequestMapping("/right")
    public  Result listRightByPid(String pid){

        List<TreeVo> T1 = treeDao.listRightByPid("");

        for (TreeVo t1 : T1) {
            List<TreeVo> T2 = treeDao.listRightByPid(t1.getId());
            t1.setChildren(T2);
            for (TreeVo t2 : T2) {
                List<TreeVo> T3 = treeDao.listRightByPid(t2.getId());
                t2.setChildren(T3);
                for (TreeVo t3 : T3) {
                    List<TreeVo> T4 = treeDao.listRightByPid(t3.getId());
                    t3.setChildren(T4);
                    for (TreeVo t4 : T4) {
                        List<TreeVo> T5 = treeDao.listRightByPid(t4.getId());
                        t4.setChildren(T5);
                    }
                }
            }
        }
       return Result.success(T1);
    }


    @RequestMapping("/right1")
    public Result listNoteByPid1(String pid){
        List<TreeVo>  treeVos = treeDao.listRightByPid(pid);
        for (TreeVo treeVo : treeVos) {
            if(treeVo.getChildren()==null){
                List<TreeVo> t = new  ArrayList<>();
                treeVo.setChildren(t);
            }

        }
        return Result.success(treeVos);

    }

    @RequestMapping("right3")
    public Result listRight(){
        return  Result.success(treeDao.listRight()) ;
    }





}
