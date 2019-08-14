package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.Dossier;

import java.util.List;

public interface DossierDAO {
    int deleteByPrimaryKey(Integer id);

    int deleteByDossierNum(String dossierNum);

    int insert(Dossier record);

    int insertSelective(Dossier record);

    Dossier selectByPrimaryKey(Integer id);

    Dossier selectByDossierNum(String dossernum);

    List<Dossier> selectAllDossier();

    List<Dossier> selectAllDossierByName(String dossierName);

    int updateByPrimaryKeySelective(Dossier record);

    int updateByPrimaryKey(Dossier record);
}