    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理者信息更新</title>
        <style type="text/css">
    table.gridtable {
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }
    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }
    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>
        </head>
        <body >
        <div style="width:100%;height:100%">
        <table class="gridtable" style="width:100%;height:100%">
    <tr>
        <th>序号</th><th>名称</th><th>详细描述</th><th>时间</th><th>更新</th>
    </tr>
    <c:forEach var="Infor"   items="${list}">
    <tr>
        <td>${Infor.infor_id}</td>
        <td>${Infor.infor_name}</td>
        <td>${Infor.infor_description}</td>
        <td>${Infor.infor_time}</td>
        <td><input type="button" name="" value="更新" onclick="update('${Infor.infor_id}');"/></td> 
    </tr>
    </c:forEach>
</table>
        </div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="js/updateinfor.js"></script>
        </body>
        </html>
	