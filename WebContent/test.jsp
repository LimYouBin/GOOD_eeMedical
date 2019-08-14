<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sql 연동하기</h1>
	
   <%
	  Connection con = null;
	  String url = "jdbc:mariadb://192.168.2.5:3306/gdproject";
	  String id = "goodee";
   	  String pwd = "1234";
   
      Class.forName("org.mariadb.jdbc.Driver");
      con = DriverManager.getConnection(url, id, pwd);
      if(con == null){
         throw new Exception("데이터베이스에 연결할 수 없습니다<br/>"); 
      }
      System.out.println(con);
      System.out.println("데이터베이스에 연결 되었습니다");
   %>
	
</body>
</html>