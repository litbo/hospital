package com.litbo.hospital.lifemanage.service.impl.MyServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.lifemanage.bean.MyBean.Blwxbg;
import com.litbo.hospital.lifemanage.dao.MyMapper.BlwxbgMapper;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.lifemanage.service.MyService.BlwxbgService;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import com.litbo.hospital.security.bean.FwPjzd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlwxbgServiceImpl implements BlwxbgService {
    @Autowired
    private BlwxbgMapper mapper;
    @Autowired
    private EqTjsqMapper tjsqMapper;
    @Override
    public int insertBlwxbg(Blwxbg blwxbg) {
        blwxbg.setId(IDFormat.getIdByIDAndTime("blwxbg", "id"));
        return mapper.insertBlwxbg(blwxbg);
    }

    @Override
    public PageInfo<Blwxbg> selectAllBlwxbg(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blwxbg> list = mapper.selectAllBlwxbg();
        list.forEach(item->{ List<FwPjqlZjb> array = JSONArray.parseArray(item.getWxpj(), FwPjqlZjb.class);
           if(array!=null&&array.size()>0)
           {
               List<FwPjzd> pjzdList=new ArrayList<>();

               for (int i = 0; i < array.size(); i++) {
                   pjzdList.add(mapper.selectpjzdById(array.get(i).getPjzdId()));
               }
               for (int i = 0; i < pjzdList.size(); i++) {
                   pjzdList.get(i).setPjcount(array.get(i).getPjsgCount());
               }

               item.setPjlist(array);
               item.setFwpjzdlist(pjzdList);
           }
            item.setBxksName(tjsqMapper.selectBmNameByBmid(item.getBxksId()));
        });

        return new PageInfo<>(list);
    }

    @Override
    public Blwxbg selectOneBlwxbg(String id) {
        Blwxbg blwxbg = mapper.selectOneBlwxbg(id);
        List<FwPjzd> pjzdList=new ArrayList<>();
        blwxbg.setPjlist(JSONArray.parseArray(blwxbg.getWxpj(), FwPjqlZjb.class));
        if(blwxbg.getPjlist()!=null && blwxbg.getPjlist().size()>0){
            int size = blwxbg.getPjlist().size();
            for (int i = 0; i < size; i++) {
                pjzdList.add(mapper.selectpjzdById(blwxbg.getPjlist().get(i).getPjzdId()));
                pjzdList.get(i).setPjcount(blwxbg.getPjlist().get(i).getPjsgCount());

            }
            blwxbg.setFwpjzdlist(pjzdList);
        }
        blwxbg.setBxksName(tjsqMapper.selectBmNameByBmid(blwxbg.getBxksId()));
        return mapper.selectOneBlwxbg(id);
    }
}
