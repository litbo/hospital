package com.litbo.hospital.beneficial.dao;

import com.litbo.hospital.beneficial.dao.provider.AccountProvider;
import com.litbo.hospital.beneficial.vo.KmVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface BAccountDao {

    @SelectProvider(type = AccountProvider.class , method = "listCbAccount")
    List<KmVo> listCbAccount();

    @SelectProvider(type = AccountProvider.class , method = "listSrAccount")
    List<KmVo> listsrAccount();
}
