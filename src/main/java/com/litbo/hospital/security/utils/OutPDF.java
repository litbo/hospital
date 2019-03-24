package com.litbo.hospital.security.utils;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OutPDF {
    private static final String TEMPLATE_PATH="E:\\IDEA_workpace\\hospital\\src\\main\\resources\\static/admin/index/safe/medical-incident/pdf/可疑医疗器械不良事件报告表.pdf";
    private static final String out_PATH="E:\\IDEA_workpace\\hospital\\src\\main\\resources\\static/admin/index/safe/medical-incident/pdf/new.pdf";

    public static void main(String[] args)throws Exception{
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath());

        Map map=new HashMap<String,String>();
        map.put("userXm", "张三");
        try {
            new OutPDF().convertTransData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }

    /**
     * 将数据转换为输入字节流
     * */
    protected InputStream convertTransData(Map map)
            throws Exception {
        if (map == null || map.isEmpty())
            return null;
        try {
            InputStream in =new FileInputStream(TEMPLATE_PATH);
            ByteArrayOutputStream out =
                    (ByteArrayOutputStream)generate(
                            new PdfReader(in),
                            map);

            ByteArrayInputStream ret =
                    new ByteArrayInputStream(out.toByteArray());
            //将pdf字节流输出到文件流
            OutputStream fos = new FileOutputStream(out_PATH);
            fos.write(out.toByteArray());
            fos.close();
            out.close();
            return ret;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     *  将数据，填入pdf表单域
     *
     * */
    public static OutputStream generate(PdfReader template, Map data)
            throws Exception {

        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);


        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfStamper stamp = new PdfStamper(template, out);
            AcroFields form = stamp.getAcroFields();
            // set the field values in the pdf form
            for (Iterator it = data.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                String value = (String) data.get(key);
                form.setFieldProperty(key, "textfont", bfChinese, null);
                form.setField(key, value);
            }
            stamp.setFormFlattening(true);
            stamp.close();
            template.close();
            return out;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
//                File path = new File(ResourceUtils.getURL("classpath:").getPath());
//                if(!path.exists()) path = new File("");
//                File upload = new File(path.getAbsolutePath());
//                PdfReader reader = new PdfReader("/static/admin/index/safe/medical-incident/pdf/可疑医疗器械不良事件报告表.pdf");
//                PdfStamper ps = new PdfStamper(reader,new FileOutputStream(upload+"static/admin/index/safe/medical-incident/pdf/new.pdf"));
//                AcroFields s = ps.getAcroFields();
//                Map fieldMap = s.getFields();
//                Set set = fieldMap.entrySet();
//                Iterator iterator = set.iterator();
//                Map paraMap = ObjectToMap.convertBeanToMap(fwBlsjById);
//                while(iterator.hasNext()){
//                    Map.Entry entry = (Map.Entry) iterator.next();
//                    String key = (String)entry.getKey();
//                    if(paraMap.get(key)!=null){
//                        s.setField(key, ""+paraMap.get(key.toUpperCase()));
//                    }
//                }
//                ps.setFormFlattening(true); // 这句不能少
//                ps.flush();
//                ps.close();
//                reader.close();