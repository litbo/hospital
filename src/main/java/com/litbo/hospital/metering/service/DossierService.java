package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.metering.pojo.DossierFile;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/11 17:23
 * @Version:
 * @Description:
 */
public interface DossierService {

    //     卷宗管理    begin
    int addDossier(Dossier dossier,String dossierNumPrefix,String DossierNumSuffix);

    int updateDossier(Dossier dossier);

    int deleterDossierById(int dossierId);
    int deleterDossierByNum(String dossierNum);

    Dossier selectDossierByDossierNum(String dossierNum);
    Dossier selectDossierByID(int id);
    List<Dossier> selectDossierByName(String name,String bmName);

    List<Dossier>  findAllDossier();

    //     卷宗管理    end

    //     文件管理    begin
    int addDossierFile(DossierFile dossierFile,String path,int dossierId);
    int deleterDossierFile(int dosserFileId);
    int updateDossierFile(DossierFile dossierFile);
    DossierFile selectDossierFile(int dossierFileId);
    List<DossierFile> findAllDossierFileByDossierName(String dossierName);
    List<DossierFile> findAlldossierFileByFileName(String dossierFileName);
    //     文件管理    end
}
