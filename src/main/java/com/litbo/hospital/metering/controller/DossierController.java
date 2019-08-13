package com.litbo.hospital.metering.controller;

import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.metering.pojo.DossierFile;
import com.litbo.hospital.metering.service.DossierService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/11 17:25
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/Dossier")
public class DossierController {

    @Autowired
    private DossierService dossierService;


    //                                              卷宗管理部分     begin


    /**
     * 添加卷宗
     * @param dossier
     * @param dossierPrefix
     * @param dossierSuffix
     * @return
     */
    @RequestMapping("/addDossier.do")
    public Result addDossier(Dossier dossier,String dossierPrefix,String dossierSuffix){
        int result = dossierService.addDossier(dossier,dossierPrefix,dossierSuffix);
        if(result == 0){
            return Result.error("添加失败,请检查您添加的信息");
        }
        return Result.success();
    }


    /**
     * 通过卷宗id删除卷宗
     * @param dossierId
     * @return
     */
    @RequestMapping("/deleteDossier.do")
    public Result deleteDossier(int dossierId){
        int result = dossierService.deleterDossierById(dossierId);
        if(result == 0){
            return Result.error("删除失败！");
        }
        return Result.success();
    }


    /**
     * 通过卷宗编号删除卷宗
     * @param dossierNum
     * @return
     */
    @RequestMapping("/deleteDossierByNum.do")
    public Result deleteDossierByNum(String dossierNum){
        int result = dossierService.deleterDossierByNum(dossierNum);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    /**
     * 修改卷宗信息
     * @param dossier
     * @return
     */
    @RequestMapping("/updateDossier.do")
    public Result updateDossier(Dossier dossier){
        int result = dossierService.updateDossier(dossier);
        if(result == 0){
            return Result.error("信息修改失败");
        }
        return Result.success();
    }


    /**
     * 通过id查询卷宗信息
     * @param dossierId
     * @return
     */
    @RequestMapping("/selectDossierById.do")
    public Result selectDossierById(int dossierId){
        Dossier dossier = dossierService.selectDossierByID(dossierId);
        if(dossier == null){
            return Result.error("未找到您要查找的信息");
        }
        return Result.success(dossier);
    }


    /**
     * 通过卷宗编号查询卷宗信息
     * @param dossierNum
     * @return
     */
    @RequestMapping("/selectDossierByDossierNum.do")
    public Result selectDossierByDossierNum(String dossierNum){
        Dossier dossier = dossierService.selectDossierByDossierNum(dossierNum);
        if(dossier == null){
            return Result.error("未找到您要查找的信息");
        }
        return Result.success(dossier);
    }


    /**
     * 通过卷宗名称查询卷宗信息
     * @param name
     * @return
     */
    @RequestMapping("/selectDossierByName.do")
    public Result selectDossierByName(String name){
        List<Dossier> dossiers = dossierService.selectDossierByName(name);
        if(dossiers.isEmpty()){
            return Result.error("未查询到该设备的信息");
        }
        return Result.success(dossiers);
    }


    /**
     * 查询所有卷宗的信息
     * @return
     */
    @RequestMapping("/fidnAllDossier.do")
    public Result fidnAllDossier(){
        List<Dossier> dossiers = dossierService.findAllDossier();
        if(dossiers.isEmpty()){
            return Result.error("未查询到信息");
        }
        return Result.success(dossiers);
    }


    //                                              卷宗管理部分     begin



    //                                              卷宗文件管理部分     begin

    /**
     * 上传卷宗文件信息以及卷宗文件
     * @return
     */
    @PostMapping("/uploadDossierFile.do")
    public Result uploadDossierFile(@RequestParam("file") MultipartFile file, DossierFile dossierFile , int dossierId) {
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }

        Dossier dossier = dossierService.selectDossierByID(dossierId);
        String filePath = dossier.getDescription();

        String fileName = file.getOriginalFilename();
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File dest = new File(filePath + System.currentTimeMillis() + fileName);
        try {
            file.transferTo(dest);
            dossierFile.setFileName(fileName);  // 文件名
            int result = dossierService.addDossierFile(dossierFile,filePath + System.currentTimeMillis() + fileName,dossierId);
            if(result == 0){
                return Result.error("上传失败");
            }
            return Result.success();
        } catch (IOException e) {
        }
        return Result.error("上传失败");
    }


    /**
     * 查看所有卷宗文件信息
     * @return
     */
    @RequestMapping("/fidnAllDossierFile.do")
    public Result fidnAllDossierFile(int dossierId) {
        Dossier dossiers = dossierService.selectDossierByID(dossierId);
        List<DossierFile> dossierFiles = dossierService.findAllDossierFileByDossierName(dossiers.getDossierName());
        if (dossierFiles.isEmpty()) {
            return Result.error("未查询到信息");
        }
        return Result.success(dossierFiles);
    }

    /**
     * 下载电子版卷宗文件
     * @return
     */
    @RequestMapping("/downloadDossierFile.do")
    public HttpServletResponse downloadDossierFile(int dossierFileId, HttpServletResponse response) {

        DossierFile dossierFile = dossierService.selectDossierFile(dossierFileId);
        String downloadPath = dossierFile.getDescription();

        // 将文件的路径拼接成程序可以识别的路径   begin
        String[] paths = dossierFile.getDescription().split("\\\\");
        StringBuffer filePath = new StringBuffer();
        for(int i = 0 ; i < paths.length-1 ; i++){
            filePath.append(paths[i]).append("\\\\");
        }
        filePath.append(paths[paths.length-1]);

        System.out.println("下载路径是："+filePath.toString());

        // 将文件的路径拼接成程序可以识别的路径   end


//        下载
        try {
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(filePath.toString()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(dossierFile.getFileName().getBytes("utf-8"),"ISO8859-1"));

            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();    // 在这里就已经将数据返回，不需要再返回response
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {

        }
        return null;
    }


    /**
     * 删除卷宗文件信息
     * @return
     */
    @RequestMapping("/deleteDossierFile.do")
    public Result deleteDossierFile(int dossierFileId) {
        DossierFile dossierFile = dossierService.selectDossierFile(dossierFileId);
        String downloadPath = dossierFile.getDescription();

        // 将文件的路径拼接成程序可以识别的路径   begin
        String[] paths = dossierFile.getDescription().split("\\\\");
        StringBuffer filePath = new StringBuffer();
        for(int i = 0 ; i < paths.length-1 ; i++){
            filePath.append(paths[i]).append("\\\\");
        }
        filePath.append(paths[paths.length-1]);

        System.out.println("下载路径是："+filePath.toString());

        // 将文件的路径拼接成程序可以识别的路径   end


        // 删除文件
        File file = new File(filePath.toString());
        if (!file.exists()) {
            return Result.error("删除文件失败:" + filePath + "不存在！");
        } else {
            if(!file.delete()){
                return Result.error("删除文件失败!");
            }
        }

        // 删除数据库信息
        int result = dossierService.deleterDossierFile(dossierFileId);

        if (result == 0) {
            return Result.error("删除失败");
        }
        return Result.success();
    }




    //                                              卷宗文件管理部分     end


}
