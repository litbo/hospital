package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.DossierFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DossierFileDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(DossierFile record);

    int insertSelective(DossierFile record);

    DossierFile selectByPrimaryKey(Integer id);

    DossierFile selectByDossierFileNum(String num);

    List<DossierFile> selectAllDossierFile(String dossierName);

    List<DossierFile> selectAllDossierFileByDossierNum(@Param("dossierNum") String dossierNum,@Param("dossiserFileType") Integer dossiserFileType,
                                                       @Param("fileName")String fileName);

    List<DossierFile> selectDossierFileByName(String dossierFileName);

    int updateByPrimaryKeySelective(DossierFile record);

    int updateByPrimaryKey(DossierFile record);
}