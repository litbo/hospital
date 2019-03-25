package com.litbo.hospital.user.dao;

import com.litbo.hospital.user.bean.SysTxcl;
import com.litbo.hospital.user.bean.SysTxlb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface XttxDao {

    @Insert("insert into eq_txlb(lbmc,roleId,txxx) values(#{lbmc},#{roleId},#{txxx})")
    Integer addTxlb(SysTxlb sysTxlb);

    @Insert("insert into eq_txcl(eq_txlb,eq_txts,eq_txcs,eq_jgsj) values(eqTxlb,eqTxts,eqTxcs,eqJgsj)")
    Integer addTxcl(SysTxcl sysTxcl);

    @Select("select * from eq_txlb")
    List<SysTxlb> listTxlb();


    @Select("select * from eq_txcl")
    List<SysTxlb> listTxcl();
}
