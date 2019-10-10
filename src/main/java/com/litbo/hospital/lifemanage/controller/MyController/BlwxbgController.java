package com.litbo.hospital.lifemanage.controller.MyController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.Blwxbg;
import com.litbo.hospital.lifemanage.service.MyService.BlwxbgService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import com.litbo.hospital.security.dao.FwPjkDao;
import com.litbo.hospital.security.dao.FwPjzdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/lifeManage")
@Transactional
public class BlwxbgController {
    @Autowired
    private BlwxbgService service;
    @Autowired
    private FwPjkDao pjkDao;
    @Autowired
    private FwPjzdDao pjzdDao;

    @PostMapping("/insertBlwxbg")
    public Result insertBlwxbg(@RequestBody Blwxbg blwxbg) {
        String a = "";
        List<FwPjqlZjb> pjlist = blwxbg.getPjlist();
        blwxbg.setWxpj(JSON.toJSONString(pjlist));
        Map<String, Integer> map = new HashMap();
        Boolean flag = false;
        boolean reduce = true;
        for (FwPjqlZjb pjqlZjb : pjlist) {
            if (pjqlZjb.getPjsgCount() - pjkDao.selectpjslById(pjqlZjb.getPjzdId()) > 0) {
                reduce = false;
            }
            if (!reduce) {
                //如果数量不足，则回滚事务，并返回 审核失败
                String pjName = pjzdDao.selectFwPjzdName(pjqlZjb.getPjzdId());
                Integer num = pjkDao.selectpjslById(pjqlZjb.getPjzdId());
                if (num == null) {
                    num = 0;
                }
                int i = pjqlZjb.getPjsgCount() - num;
                if (i > 0) {
                    map.put(pjName, i);
                }

                flag = true;

            }

        }

        if (flag) {
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                a += next.getKey() + "缺少" + next.getValue() + "件";
            }
            return Result.error(a);

        }
        if (reduce) {
            for (FwPjqlZjb pjqlZjb : pjlist) {
                pjkDao.reduceFwPjkSl(pjqlZjb.getPjzdId(), pjqlZjb.getPjsgCount());
            }
        }

        int i = service.insertBlwxbg(blwxbg);
        if (i == 0) {
            return Result.error("添加失败");
        }
        return Result.success();
    }

    @RequestMapping("/selectAllBlwxbg")
    public Result selectAllBlwxbg(@RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Blwxbg> info = service.selectAllBlwxbg(pageNum, pageSize);
        return Result.success(info);
    }

    @RequestMapping("/selectOneBlwxbgByID")
    public Result selectOneBlwxbgByID(@RequestParam(name = "id") String id) {
        return Result.success(service.selectOneBlwxbg(id));
    }

}
