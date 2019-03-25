package com.litbo.hospital.user.dao;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqPm;
import com.litbo.hospital.user.vo.RightTreeVo;
import com.litbo.hospital.user.vo.TreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeDao {

    @Select("select eq_pm_id as id , eq_pm_name as name from eq_pm where pid=#{pid}")
   List<TreeVo> listNoteByPid(String pid);

    @Select("select right_id as id , bz as name from a_right where pid=#{pid}")
    List<TreeVo> listRightByPid(String pid);

    @Select("select right_id ,bz as rightName ,pid from a_right")
    List<RightTreeVo> listRight();
}
