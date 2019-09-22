package com.litbo.hospital.maintenance.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.litbo.hospital.common.utils.poi.InsertPDF;
import com.litbo.hospital.maintenance.pojo.Consumables;
import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import com.litbo.hospital.maintenance.vo.MaintenanceMessageVo;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: 樊小铭
 * Date: 2019/9/1 14:26
 * @Version:
 * @Description:
 */
public class PDFUtil extends InsertPDF {

    public static void main(String[] args) {
        MaintenanceMessageVo maintenanceMessage = new MaintenanceMessageVo();

        maintenanceMessage.setBaoYangShiJian("1");
        maintenanceMessage.setBeiZhu("1");
        maintenanceMessage.setChanDi("1");
        maintenanceMessage.setDanJia("1");
        maintenanceMessage.setEqCatagory("灭菌类");
        maintenanceMessage.setFenLeiBianMa("1");
        maintenanceMessage.setGuiGeXingHao("1");
        maintenanceMessage.setJianChaRiQi("1");
        maintenanceMessage.setKeShiQianShou("1");
        maintenanceMessage.setQiYongShiJian("1");
        maintenanceMessage.setSheBeiMingCheng("1");
        maintenanceMessage.setShengChanChangJia("1");
        maintenanceMessage.setShiYongKeShi("1");
        maintenanceMessage.setWanChengRiQi("1");
        maintenanceMessage.setWeiBaoRen("1");
        maintenanceMessage.setWeiBaoZeRenRen("set");
        maintenanceMessage.setWeiHuRenYuan("sdfs");
        maintenanceMessage.setXuLieHao("sdfsdf");
        maintenanceMessage.setYiQiXianZhuang("sdfsdf");


        List<MaintenanceProject> projects = new ArrayList<>();
        MaintenanceProject project = new MaintenanceProject();
        project.setProjectName("ssdfg");
        project.setProjectType("维护保养");
        project.setResult("(2) 完好");
        projects.add(project);

        MaintenanceProject project1 = new MaintenanceProject();
        project1.setProjectName("ssdfg");
        project1.setProjectType("维护保养");
        project1.setResult("(2) 完好");
        projects.add(project1);


        List<MaintenanceProject> projects1 = new ArrayList<>();
        MaintenanceProject project2 = new MaintenanceProject();
        project2.setProjectName("ssdfg");
        project2.setProjectType("维护保养ewr");
        project2.setResult("(2) 完好");
        projects1.add(project2);

        MaintenanceProject project3 = new MaintenanceProject();
        project3.setProjectName("ssdfg");
        project3.setProjectType("维护保养ewr");
        project3.setResult("(2) 完好");
        projects1.add(project3);


        List<List<MaintenanceProject>> projectsList = new ArrayList<>();
        projectsList.add(projects);
        projectsList.add(projects1);

        System.out.println("projectList:"+projectsList);
        System.out.println("projects:"+projects);
        System.out.println("projects1:"+projects1);


        List<Consumables> consumables = new ArrayList<>();
        Consumables consumables1 = new Consumables();
        consumables1.setChangeDate("1");
        consumables1.setCycle("sdf");
        consumables1.setDateOfActivation("sdf");
        consumables1.setExpired("sdf");
        consumables1.setNotExpired("sdgsdg");
        consumables1.setProductName("sdgsd");
        consumables.add(consumables1);
        createPDF(maintenanceMessage,projectsList,consumables);
    }

    public static void createPDF(MaintenanceMessageVo maintenanceMessage, List<List<MaintenanceProject>> projects, List<Consumables> consumables) {//生成pdf
        BaseFont bf;
        Font font = null;
        try {
            bf = BaseFont.createFont( "STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);//创建字体
            font = new Font(bf,12);//使用字体
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/wang/Desktop/图片或截图/测试.pdf"));
            document.open();

//            float[] widths = {30f,25f,25f };// 设置表格的列宽和列数 默认是4列
            PdfPTable table = new PdfPTable(7);// 建立一个pdf表格
            table.setSpacingBefore(30f);
            table.setWidthPercentage(100);// 设置表格宽度为100%

            PdfPCell cell = null;

            cell = new PdfPCell(new Paragraph("设备基本情况",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(7);  // 设置列数
            cell.setRowspan(2);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);  // 水平对齐
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);



            cell = new PdfPCell(new Paragraph("装备\n类别",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(2);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);



//                                  装备类别信息    begin
            String a1,a2,a3,a4,a5,a6;
            a1 = a2 = a3 = a4 = a5 = a6 = "□";
            switch (maintenanceMessage.getEqCatagory()){
                case "急救类":{
                    a1 = "√";
                }break;
                case "生命支持":{
                    a2 = "√";
                }break;
                case "辐射类":{
                    a3 = "√";
                }break;
                case "灭菌类":{
                    a4 = "√";
                }break;
                case "50万元以上":{
                    a5 = "√";
                }break;
                case "大型设备":{
                    a6 = "√";
                }break;
                default: {

                }
            }

            cell = new PdfPCell(new Paragraph("急救类"+a1,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("生命支持"+a2,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("辐射类"+a3,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("灭菌类"+a4,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("50万元以上"+a5,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("大型设备"+a6,font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);



//                                  装备类别信息    end



//                                  维保人和维保责任人信息    begin



            cell = new PdfPCell(new Paragraph("维保人",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getWeiBaoRen(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("维保责任人",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getWeiBaoZeRenRen(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);



 //                                  维保人和维保责任人信息    end

            cell = new PdfPCell(new Paragraph("设备分类编码",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getFenLeiBianMa(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("装备名称",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getSheBeiMingCheng(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("规格型号",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getGuiGeXingHao(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("序列号",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getXuLieHao(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("生产厂家",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getShengChanChangJia(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("产地",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getChanDi(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("使用科室",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getShiYongKeShi(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("启用时间",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getQiYongShiJian(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("单价",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(maintenanceMessage.getDanJia(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            cell = new PdfPCell(new Paragraph("保养时间",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getBaoYangShiJian(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


//                                                   检查维护表头    begin

            cell = new PdfPCell(new Paragraph("检查维护",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(7);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("项目",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("检查维护内容",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("检查维护结果\n（1）合格 （2）修复 （3）待修",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);
//                                                   检查维护表头    end


//                                                检查项目     begin

            for(List<MaintenanceProject> projectList : projects){
                //                               生成前面的项目名称          begin
                cell = new PdfPCell(new Paragraph(projectList.get(0).getProjectType(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(projectList.size());  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);
                //                               生成前面的项目名称          end


                //                               生成内容                 begin
                for(MaintenanceProject maintenanceProject : projectList){

                    //                  项目名称
                    cell = new PdfPCell(new Paragraph(maintenanceProject.getProjectName(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    cell.setColspan(3);  // 设置列数
                    cell.setRowspan(1);  // 设置行数
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                    cell.setFixedHeight(30f); // 设置高度
                    table.addCell(cell);

                    //                  检查维护结果
                    cell = new PdfPCell(new Paragraph(maintenanceProject.getResult(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    cell.setColspan(3);  // 设置列数
                    cell.setRowspan(1);  // 设置行数
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                    cell.setFixedHeight(30f); // 设置高度
                    table.addCell(cell);
                }
                //                               生成内容                 end

            }





//                                                 易耗品                begin
            cell = new PdfPCell(new Paragraph("易耗品",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(consumables.size()+1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("品名",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("更换周期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("过期、更换",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("未过期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("启用日期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("更换日期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            for(Consumables consumable : consumables){
                //       品名
                cell = new PdfPCell(new Paragraph(consumable.getProductName(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);


                //       更换周期
                cell = new PdfPCell(new Paragraph(consumable.getCycle(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);


                //       过期、更换
                cell = new PdfPCell(new Paragraph(consumable.getExpired(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);


                //       未过期
                cell = new PdfPCell(new Paragraph(consumable.getNotExpired(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);


                //       启用日期
                cell = new PdfPCell(new Paragraph(consumable.getDateOfActivation(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);


                //       更换日期
                cell = new PdfPCell(new Paragraph(consumable.getChangeDate(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);
            }
//                                                 易耗品                end

//                                                 表尾    begin
            //       仪器现状
            cell = new PdfPCell(new Paragraph("仪器现状",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getYiQiXianZhuang(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(6);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            //       备注
            cell = new PdfPCell(new Paragraph("备注",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getBeiZhu(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(6);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);


            //       维护人员
            cell = new PdfPCell(new Paragraph("维护人员",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getWeiHuRenYuan(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            //       检查日期
            cell = new PdfPCell(new Paragraph("检查日期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getJianChaRiQi(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            //       科室签收
            cell = new PdfPCell(new Paragraph("科室签收",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getKeShiQianShou(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(2);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            //       完成日期
            cell = new PdfPCell(new Paragraph("完成日期",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(maintenanceMessage.getWanChengRiQi(),font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);




//                                                 表尾    end

            document.add(table);

            document.close();
        } catch (Exception e) {
            System.out.println("file create exception");
        }

    }

}
