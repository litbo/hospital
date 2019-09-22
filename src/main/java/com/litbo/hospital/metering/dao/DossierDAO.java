package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.user.bean.EqInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DossierDAO {
    int deleteByPrimaryKey(Integer id);

    int deleteByDossierNum(String dossierNum);

    int insert(Dossier record);

    int insertSelective(Dossier record);

    Dossier selectByPrimaryKey(Integer id);

    Dossier selectByDossierNum(String dossernum);

    List<Dossier> selectAllDossier();

    List<Dossier> selectAllDossierByNameOrBmName(@Param("dossierName") String dossierName,@Param("bmName") String bmName);

    int updateByPrimaryKeySelective(Dossier record);

    int updateByPrimaryKey(Dossier record);

    List<EqInfo> selectNeedDossierEq(@Param("eqName") String eqName);

    String getDepartment(String key);
}