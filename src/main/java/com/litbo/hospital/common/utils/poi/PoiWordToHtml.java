package com.litbo.hospital.common.utils.poi;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
public class PoiWordToHtml {
    /**
     * word07版本(.docx)转html
     * poi:word07在线预览
     * */
//    HttpServletRequest request,
    public static String PoiWord07ToHtml (String url) throws IOException {
        url= url.replaceAll("/","\\\\") ;
        String pjpath = System.getProperty("user.dir");
        String path= pjpath+"\\zdhtml\\";
        String file = pjpath+"\\"+url;
        String hname = url.split("\\.")[0].split("\\\\")[1];
        String file2 =pjpath+"\\zdhtml\\"+hname+".html";
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("Sorry File does not Exists!");
        } else {
            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {
                //读取文档内容
                InputStream in = new FileInputStream(f);
                XWPFDocument document = new XWPFDocument(in);

                File imageFolderFile = new File(path);
                if(!imageFolderFile.exists()){
                    imageFolderFile.mkdir();
                }
                //加载html页面时图片路径
                XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("/"));
                //图片保存文件夹路径
                options.setExtractor(new FileImageExtractor(imageFolderFile));
                OutputStream out = new FileOutputStream(new File(file2));
                XHTMLConverter.getInstance().convert(document, out, options);
                out.close();
            } else {
                System.out.println("Enter only MS Office 2007+ files");
            }
        }
        return file2;
    }


    /**
     * 将word2003转换为html文件 2018-4-9
     * 
     * @param wordPath
     *            word文件路径
     * @param wordName
     *            word文件名称无后缀
     * @param suffix
     *            word文件后缀
     * @throws IOException
     * @throws TransformerException
     * @throws ParserConfigurationException
     */
    public static String Word2003ToHtml(String url) throws IOException, TransformerException,
            ParserConfigurationException {
        url= url.replaceAll("/","\\\\") ;
        String pjpath = System.getProperty("user.dir");
        String imagePath= pjpath+"\\zdhtml\\";
        String file = pjpath+"\\"+url;
        String hname = url.split("\\.")[0].split("\\\\")[1];
        String htmlPath =pjpath+"\\zdhtml\\"+hname+".html";




// 判断html文件是否存在
        File htmlFile = new File(htmlPath);



// 原word文档
        InputStream input = new FileInputStream(new File(file));


        HWPFDocument wordDocument = new HWPFDocument(input);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());
// 设置图片存放的位置
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType,
                                      String suggestedName, float widthInches, float heightInches) {
                File imgPath = new File(imagePath);
                if (!imgPath.exists()) {// 图片目录不存在则创建
                    imgPath.mkdirs();
                }
                File file = new File(imagePath + suggestedName);
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(content);
                    os.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
// 图片在html文件上的路径 相对路径
                return "image/" + suggestedName;
            }
        });


// 解析word文档
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();


// 生成html文件上级文件夹
        File folder = new File(htmlPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }


// 生成html文件地址
// 也可以使用字符数组流获取解析的内容
// ByteArrayOutputStream baos = new ByteArrayOutputStream();
// OutputStream outStream = new BufferedOutputStream(baos);


        OutputStream outStream = new FileOutputStream(htmlFile);


        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);


        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer serializer = factory.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");


        serializer.transform(domSource, streamResult);


        return htmlPath;
    }




}

