package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.DossierDAO;
import com.litbo.hospital.metering.dao.DossierFileDAO;
import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.metering.pojo.DossierFile;
import com.litbo.hospital.metering.service.DossierService;
import com.litbo.hospital.metering.util.PropertiesUtil;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/11 17:23
 * @Version:
 * @Description:
 */
@Service
public class DossierServiceImpl implements DossierService {

    @Autowired
    private DossierDAO dossierDAO;

    @Autowired
    private DossierFileDAO dossierFileDAO;

    private String catagoryPath = "D:\\hospitalConfigFile\\";


    //                                                   卷宗管理     begin

    @Override
    public int addDossier(Dossier dossier,String dossierNumPrefix,String dossierNumSuffix) {

        // 检查卷宗编号是否重复
        Dossier dossierCheck = dossierDAO.selectByDossierNum(dossier.getDossierNum());
        if(dossierCheck != null){
            return 0;
        }

        // 得到卷宗编号
        String dossierNum = getPropertiesDossiesNum(dossierNumPrefix,dossierNumSuffix);
        dossier.setDossierNum(dossierNum);

        String nowtiem = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss a").format(new Date());

        dossier.setRecordTime(nowtiem);

        // 生成电子文件夹
        switch (dossier.getDossierType()){
            case 1:{
                dossier.setDescription(catagoryPath+"PurchaseFile\\"+dossierNum+"_"+dossier.getDossierName()+"\\");
            }break;
            case 2:{
                dossier.setDescription(catagoryPath+"Equipment_technology_file\\"+dossierNum+"_"+dossier.getDossierName()+"\\");
            }break;
            case 3 :{
                dossier.setDescription(catagoryPath+"management_file\\"+dossierNum+"_"+dossier.getDossierName()+"\\");
            }break;
            case 4:{
                dossier.setDescription(catagoryPath+"other_file\\"+dossierNum+"_"+dossier.getDossierName()+"\\");
            }break;
            default:{
                dossier.setDescription(catagoryPath+"other_file\\"+dossierNum+"_"+dossier.getDossierName()+"\\");
            }
        }
        return dossierDAO.insert(dossier);
    }


    /**
     * 拼接卷宗的编号
     * @param dossierNumPrefix 卷宗编号第一部分的内容
     * @param time 卷宗编号第二部分的内容
     * @return
     */
    private String getPropertiesDossiesNum(String dossierNumPrefix,String time){
        // 拼接卷宗编号
        String serial = PropertiesUtil.getPropertie("'"+time+"'");
        if(serial == null){
            // 这一年还没有流水记录，就创建这一年的流水记录
            serial = "001";
            PropertiesUtil.setPropertie("'"+time+"'","002");
        }else{
            int num = Integer.parseInt(serial);
            // 这一年有了流水记录，就把配置文件中得编号加1
            serial = new DecimalFormat("000").format(num);
            num++;
            PropertiesUtil.setPropertie("'"+time+"'", String.valueOf(num));
        }
        return dossierNumPrefix + "-" + time + serial;
    }

    @Override
    public int updateDossier(Dossier dossier) {
        // 检查卷宗编号是否重复
        Dossier dossierCheck = dossierDAO.selectByDossierNum(dossier.getDossierNum());
        if(dossierCheck != null){
            return 0;
        }

        // 查看数据库中原有信息
        Dossier dossierMessage = dossierDAO.selectByPrimaryKey(dossier.getId());
        if(dossierMessage == null){
            return 0;
        }

        //     有一些不允许修改的信息，必须按照原来的进行   begin
        dossier.setDossierNum(dossierMessage.getDossierNum());      // 卷宗编号
        dossier.setRecordTime(dossierMessage.getRecordTime());      // 卷宗创建时间
        dossier.setRecordPerson(dossierMessage.getRecordPerson());  // 卷宗创建人
        //     有一些不允许修改的信息，必须按照原来的进行   begin
        return dossierDAO.updateByPrimaryKey(dossier);
    }

    @Override
    public int deleterDossierById(int dossierId) {
        Dossier dossier = dossierDAO.selectByPrimaryKey(dossierId);
        // 如果卷宗内还有文件则删除失败
        List<DossierFile> dossierFiles = dossierFileDAO.selectAllDossierFile(dossier.getDossierNum());
        if(dossierFiles.isEmpty()){
            // 删除文件夹
            // 将文件的路径拼接成程序可以识别的路径   begin
            String[] paths = dossier.getDescription().split("\\\\");
            StringBuffer filePath = new StringBuffer();
            for(int i = 0 ; i < paths.length-1 ; i++){
                filePath.append(paths[i]).append("\\\\");
            }
            filePath.append(paths[paths.length-1]);


            // 将文件的路径拼接成程序可以识别的路径   end


            // 删除文件
            File file = new File(filePath.toString());
            if (!file.exists()) {
                return dossierDAO.deleteByPrimaryKey(dossierId);
            } else {
                if(!file.delete()){
                    return 0;
                }
                return dossierDAO.deleteByPrimaryKey(dossierId);
            }
        }
        return 0;
    }

    @Override
    public int deleterDossierByNum(String dossierNum) {
        Dossier dossier = dossierDAO.selectByDossierNum(dossierNum);
        // 如果卷宗内还有文件则删除失败
        List<DossierFile> dossierFiles = dossierFileDAO.selectAllDossierFile(dossier.getDossierNum());
        if(dossierFiles.isEmpty()){
            return 0;
        }
        return dossierDAO.deleteByDossierNum(dossierNum);
    }

    @Override
    public Dossier selectDossierByDossierNum(String dossierNum) {
        return dossierDAO.selectByDossierNum(dossierNum);
    }

    @Override
    public Dossier selectDossierByID(int id) {
        return dossierDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<Dossier> selectDossierByName(String name,String bmName) {
        if(name != null){
            name = "%"+name+"%";
        }
        if(bmName != null){
            bmName = "%"+bmName+"%";
        }
        return dossierDAO.selectAllDossierByNameOrBmName(name,bmName);
    }

    @Override
    public List<Dossier> findAllDossier() {
        return dossierDAO.selectAllDossier();
    }

    //                                                  卷宗管理           end



    //                                                 文件管理       begin

    @Override
    public int addDossierFile(DossierFile dossierFile,String path , int dossierId) {

        // 获得文件所属的卷宗的信息
        Dossier dossier = dossierDAO.selectByPrimaryKey(dossierId);
        if(dossier == null){
            return 0;
        }
        // 获得当前时间
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date());

        // 文件编号的前缀
        String prefix = dossier.getDossierNum().substring(9,12) + "-" + dossier.getDossierType() + "-";
        System.out.println("得到的卷宗文件编号的前缀是："+prefix);


        // 设置dossierFile的相关信息   begin
        dossierFile.setRecordTime(nowTime);   // 记录生成时间
        dossierFile.setDescription(path);    // 电子版文件下载路径
        dossierFile.setFileNum(getPropertiesDossiesFileNum(prefix));// 文件编号
        dossierFile.setBelongDossierName(dossier.getDossierName());  // 卷宗名称
        dossierFile.setBelongDossierNum(dossier.getDossierNum());   // 卷宗编号
        dossierFile.setBuyTime(dossier.getBuyTime());   // 购买时间
        dossierFile.setBmName(dossier.getBmName());   // 所属部门

        dossierFile.setAgent(dossier.getAgent());     // 代理商
        dossierFile.setSpecification(dossier.getSpecification());  // 规格型号
        dossierFile.setManufacturer(dossier.getManufacturer());   // 生产厂家
        // 设置dossierFile的相关信息   end

        return dossierFileDAO.insert(dossierFile);
    }


    /**
     * 拼接卷宗文件的编号
     * @param prefix 文件编号的前缀
     * @return
     */
    private String getPropertiesDossiesFileNum(String prefix){
        // 拼接卷宗编号
        String serial = PropertiesUtil.getPropertie("'"+prefix+"'");
        if(serial == null){
            // 这一年还没有流水记录，就创建这一年的流水记录
            serial = "001";
            PropertiesUtil.setPropertie("'"+prefix+"'","002");
        }else{
            int num = Integer.parseInt(serial);
            // 这一年有了流水记录，就把配置文件中得编号加1
            serial = new DecimalFormat("000").format(num);
            num++;
            PropertiesUtil.setPropertie("'"+prefix+"'", String.valueOf(num));
        }
        return prefix + serial;
    }

    @Override
    public int deleterDossierFile(int dosserFileId) {
        return dossierFileDAO.deleteByPrimaryKey(dosserFileId);
    }

    @Override
    public int updateDossierFile(DossierFile dossierFile) {
        return dossierFileDAO.updateByPrimaryKey(dossierFile);
    }

    @Override
    public DossierFile selectDossierFile(int dossierFileId) {
        return dossierFileDAO.selectByPrimaryKey(dossierFileId);
    }

    @Override
    public List<DossierFile> findAllDossierFileByDossierName(String dossierName) {
        return dossierFileDAO.selectAllDossierFile(dossierName);
    }

    @Override
    public List<DossierFile> findAlldossierFileByFileName(String dossierFileName) {
        return dossierFileDAO.selectDossierFileByName(dossierFileName);
    }


    //                                                   文件管理     end
}
