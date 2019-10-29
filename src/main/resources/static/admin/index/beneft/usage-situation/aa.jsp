<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<%@ page import="java.util.*" %>

<%@ page import="java.io.*" %>

<%@ page import="java.sql.*" %>

<%

String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<%

 //报表生成之后编译生成的.jasper文件位置

 File jasperFile=new File("D:/Workspaces/zwjxSystem/WebRoot/jasper/report1.jasper");

 String url ="jdbc:oracle:thin:@192.168.1.104:1521:orcl";

 Class.forName("oracle.jdbc.driver.OracleDriver");

 Connection conn = DriverManager.getConnection(url,"zwjx","zwjx");

 String projectapproid = request.getParameter("projectapproid");

 System.out.println(projectapproid);

 Map map = new HashMap();

 map.put("projectapproid",projectapproid);

//打印

 JasperPrint print = JasperFillManager.fillReport(jasperFile.getPath(), map,conn);

 OutputStream os=response.getOutputStream();

 //生成文件名

String fileNames="项目立项";

JRAbstractExporter exporter = new JRHtmlExporter();

response.reset();

response.setContentType("text/html");

response.setHeader("Content-Disposition","attachment;filename="+new String(fileNames.getBytes("gbk"),"iso8859-1")+".html");

JasperReportsUtils.render(exporter, print,os);

os.flush();
os.close();

%> 