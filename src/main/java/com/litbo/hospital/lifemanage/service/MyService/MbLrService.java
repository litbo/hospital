package com.litbo.hospital.lifemanage.service.MyService;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.MyBean.MbLr;
import org.apache.ibatis.annotations.Delete;

public interface MbLrService {

    /*增加一条模板*/
    int insertMbLr(MbLr mb);

    /*查询或者根据模板名称查询模板*/
    PageInfo<MbLr> selectAllMb(String mbmc);

    /*查看一条模板详情*/
    MbLr selectOneMb(String id);

    /*修改一条模板*/
    int updateMb(MbLr mb);

    /*删除*/
    @Delete("delete from mb_lr where id=#{id}")
    int deleteMbByid(String id);
}
