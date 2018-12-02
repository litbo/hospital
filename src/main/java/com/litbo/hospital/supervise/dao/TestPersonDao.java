package com.litbo.hospital.supervise.dao;

import com.litbo.hospital.supervise.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface TestPersonDao {
    @Select("select * from person")
    public List<Person> listPerson();

}
