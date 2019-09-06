package com.litbo.hospital.check_before_use.dao;

import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseDict;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckBeforeUseDictDAO {
    long countByExample(CheckBeforeUseDictExample example);

    int deleteByExample(CheckBeforeUseDictExample example);

    int insert(CheckBeforeUseDict record);

    int insertSelective(CheckBeforeUseDict record);

    List<CheckBeforeUseDict> selectByExample(CheckBeforeUseDictExample example);

    int updateByExampleSelective(@Param("record") CheckBeforeUseDict record, @Param("example") CheckBeforeUseDictExample example);

    int updateByExample(@Param("record") CheckBeforeUseDict record, @Param("example") CheckBeforeUseDictExample example);

    List<String> seeAllType(String type);

    int selectValueByKey(@Param("key") String key,@Param("value") String value);


}