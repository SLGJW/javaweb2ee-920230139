<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*,entity.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1" cellpadding="0">
        <h1 align="center">学生信息</h1>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>学号</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <%
        	StudentDao dao=new StudentDao();
        List<Student> emps=dao.findAll();
        for(int i=0;i<emps.size();i++){
          	Student emp=emps.get(i);
         %>
        <tr>
            <td><%=emp.getId() %></td>
            <td><%=emp.getName() %></td>
            <td><%=emp.getSnumber() %></td>
            <td><%=emp.getAge() %></td>
            <td><%=emp.getSsex() %></td>
            <td>
            </td>
        </tr>
        <%} %>
    </table>
     <p align="center"><a href="servlet2">注销，退出登录</a></p>
</body>
</html>