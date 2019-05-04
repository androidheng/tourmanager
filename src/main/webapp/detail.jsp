<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
   
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
    <style>
          html,body{
           width:100%;
          }
         .layui-content:{box-sizing:border-box;}
         .layui-content img:{width:100%;}
    </style>
</head>
<body class="layui-view-body">
   <div class="layui-content" style="text-align:center;" id="box" >
       ${strategy.content}
   </div>
   
</body>
</html>