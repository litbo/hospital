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
        maintenanceMessage.setEqCatagory("1");
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
        List<List<MaintenanceProject>> projectsList = new ArrayList<>();
        projectsList.add(projects);
        List<Consumables> consumables = new ArrayList<>();
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
                cell = new PdfPCell(new Paragraph("外观\n及附件",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setColspan(1);  // 设置列数
                cell.setRowspan(1);  // 设置行数
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
                cell.setFixedHeight(30f); // 设置高度
                table.addCell(cell);
            }

            cell = new PdfPCell(new Paragraph("外观\n及附件",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
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

            cell = new PdfPCell(new Paragraph("检查维护结果\n（1）合格 （2）修复 （3）待修",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);
//                                                功能及附件     end





//                                                功能检查     begin

            cell = new PdfPCell(new Paragraph("功能\n检查",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(1);  // 设置列数
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

            cell = new PdfPCell(new Paragraph("检查维护结果\n（1）合格 （2）修复 （3）待修",font));//
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(3);  // 设置列数
            cell.setRowspan(1);  // 设置行数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
            cell.setFixedHeight(30f); // 设置高度
            table.addCell(cell);

//                                                功能检查    end






//            //以下代码的作用是创建100行数据,其中每行有四列,列依次为 编号 姓名 性别 备注
//            for (int i = 1; i <=10; i++) {
//                //设置编号单元格
//                PdfPCell cell11=new PdfPCell(new Paragraph("aa名媛",font));
//                PdfPCell cell22=new PdfPCell(new Paragraph("bb女",font));
//                PdfPCell cell33=new PdfPCell(new Paragraph("cc花姑娘",font));
//
//                //单元格水平对齐方式
//                cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
//                //单元格垂直对齐方式
//                cell11.setVerticalAlignment(Element.ALIGN_CENTER);
//
//                cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell22.setVerticalAlignment(Element.ALIGN_CENTER);
//
//                cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell33.setVerticalAlignment(Element.ALIGN_CENTER);
//
//
//                table.addCell(cell11);
//                table.addCell(cell22);
//                table.addCell(cell33);
//
//            }
            document.add(table);

            document.close();
        } catch (Exception e) {
            System.out.println("file create exception");
        }

    }

}
