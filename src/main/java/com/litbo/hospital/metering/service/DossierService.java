package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.metering.pojo.DossierFile;
import com.litbo.hospital.user.bean.EqInfo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/11 17:23
 * @Version:
 * @Description:
 */
public interface DossierService {

    //     卷宗管理    begin
    // 查看还没有立卷宗的文件
    List<EqInfo> selectEqNeedDossier();
    int addDossier(Dossier dossier,String dossierNumPrefix,String DossierNumSuffix);
    int updateDossier(Dossier dossier);
    int deleterDossierById(int dossierId);
    Dossier selectDossierByID(int id);
    List<Dossier> selectDossierByName(String name,String bmName);

    //     卷宗管理    end

    //     文件管理    begin
    int addDossierFile(DossierFile dossierFile,String path,int dossierId);
    int deleterDossierFile(int dosserFileId,Dossier dossier);
    DossierFile selectDossierFile(int dossierFileId);
    Dossier selectDossierByBelongNum(String BelongNum);
    List<DossierFile> findAllDossierFileByDossierNum(String dossierNum,Integer dossiserFileType,String fileName);
    //     文件管理    end
}
