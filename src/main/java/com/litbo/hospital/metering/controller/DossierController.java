package com.litbo.hospital.metering.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.metering.pojo.Dossier;
import com.litbo.hospital.metering.pojo.DossierFile;
import com.litbo.hospital.metering.service.DossierService;
import com.litbo.hospital.metering.vo.PageVo;
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
            return Result.success("添加失败,请检查您添加的信息");
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
            return Result.success("删除失败！");
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
            return Result.success("信息修改失败");
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
            return Result.success("未找到您要查找的信息");
        }
        return Result.success(dossier);
    }



    /**
     * 通过卷宗名称查询卷宗信息,不传值的时候查询所有
     * @param name
     * @return
     */
    @RequestMapping("/selectDossierByName.do")
    public PageVo selectDossierByName(String name,String bmName,
                                      @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize){
        PageVo vo = new PageVo();
        PageHelper.startPage(pageNum,pageSize);
        List<Dossier> dossiers = dossierService.selectDossierByName(name,bmName);
        PageInfo info = new PageInfo(dossiers);
        if(!dossiers.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),dossiers));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),dossiers));
        return vo;
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

        // 得到文件归属的卷宗的信息
        Dossier dossier = dossierService.selectDossierByID(dossierId);
        // 得到卷宗电子版的路径
        String filePath = dossier.getDescription();

        String fileName = file.getOriginalFilename();
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        String time = "" + System.currentTimeMillis();

        File dest = new File(filePath + time + fileName);
        try {
            file.transferTo(dest);
            dossierFile.setFileName(fileName);  // 文件名
            int result = dossierService.addDossierFile(dossierFile,filePath + time + fileName,dossierId);
            if(result == 0){
                return Result.success("上传失败");
            }
            return Result.success();
        } catch (IOException e) {
        }
        return Result.success("上传失败");
    }


    /**
     * 查看所有卷宗文件信息
     * @return
     */
    @RequestMapping("/fidnAllDossierFile.do")
    public PageVo fidnAllDossierFile(int dossierId,
                                     @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                                     @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize) {
        PageVo vo = new PageVo();
        Dossier dossiers = dossierService.selectDossierByID(dossierId);

        if(dossiers == null){
            vo.setMsg("没有查询到设备信息");
            vo.setCode(0);
            vo.setData(vo.new DataEntity(0,null));
            return vo;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<DossierFile> dossierFiles = dossierService.findAllDossierFileByDossierName(dossiers.getDossierName());
        PageInfo info = new PageInfo(dossierFiles);
        if(!dossierFiles.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),dossierFiles));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),dossierFiles));
        return vo;
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
            // 删除数据库信息
            int result = dossierService.deleterDossierFile(dossierFileId);

            if (result == 0) {
                return Result.success("删除失败");
            }
            return Result.success();
        } else {
            if(!file.delete()){
                return Result.success("删除文件失败!");
            }
        }

        // 删除数据库信息
        int result = dossierService.deleterDossierFile(dossierFileId);

        if (result == 0) {
            return Result.success("删除失败");
        }
        return Result.success();
    }




    //                                              卷宗文件管理部分     end


}
