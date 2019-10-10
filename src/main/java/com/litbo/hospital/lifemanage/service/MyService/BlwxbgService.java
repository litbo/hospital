package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.Blwxbg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlwxbgService {
    /*增加*/
    int insertBlwxbg(Blwxbg blwxbg);

    PageInfo<Blwxbg> selectAllBlwxbg(Integer pageNum,Integer pageSize);

    Blwxbg selectOneBlwxbg(String id);
}
