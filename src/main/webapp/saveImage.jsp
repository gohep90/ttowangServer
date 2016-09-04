<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %> 
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %>
<%request.setCharacterEncoding("utf-8");	%>
<%
String savePath ="C:/Users/Park/workspace/ttowang/src/main/webapp/image";
	int sizeLimit =5*1024*1024; //파일업로드 용량제한 10MB
	String fileName="";
	
    String businessName ="";
	
	
	 try{ 
         MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit,
        		 "utf-8",new DefaultFileRenamePolicy()); 
         Enumeration<?> files =multi.getFileNames();
         String file1 =(String)files.nextElement();
         
         businessName =URLDecoder.decode(multi.getParameter("businessName"),"utf-8");;
         
         System.out.println(businessName);
         
         fileName= multi.getFilesystemName(file1); 
         String originFileName = multi.getOriginalFileName(file1);
         
           if(fileName == null) { 
                 System.out.print("파일이 업로드 되지 않았습니다!!"); 
           } else { 
                 System.out.println("getFilesystemName() : " + fileName); 
                 System.out.println("getOriginalFileName() : " + originFileName); 
            } // end if 
     } catch(Exception e) { 
           System.out.println(e.getMessage()); 
     } 
	
%>