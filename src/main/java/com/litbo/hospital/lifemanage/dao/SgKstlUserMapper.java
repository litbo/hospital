package com.litbo.hospital.lifemanage.dao;

import com.litbo.hospital.lifemanage.dao.mapper.SgKstlUserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 科室讨论会议人员关联表Mapper接口
 */
@Mapper
public interface SgKstlUserMapper {
    /**
     * 添加科室讨论人员信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param usersId 参加讨论的人员集合
     * @return 插入条数
     */
    @InsertProvider(type = SgKstlUserProvider.class,method = "insertSgKstlUserSql")
    int insertSgKstlUser(@Param("kstlId") String kstlId,@Param("usersId") List<String> usersId);
    /*
    int countByExample(SgKstlUserExample example);

    int deleteByExample(SgKstlUserExample example);

    int deleteByPrimaryKey(SgKstlUserKey key);



    int insertSelective(SgKstlUserKey record);

    List<SgKstlUserKey> selectByExample(SgKstlUserExample example);

    int updateByExampleSelective(@Param("record") SgKstlUserKey record, @Param("example") SgKstlUserExample example);

    int updateByExample(@Param("record") SgKstlUserKey record, @Param("example") SgKstlUserExample example);
     */
}