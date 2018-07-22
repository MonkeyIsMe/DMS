    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查询房间信息</title>
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
        <body>
        <div style="width:100%;height:100%">
        <table class="gridtable" style="width:100%;height:100%">
    <tr>
        <th>寝室号</th><th>空余寝室数</th><th>选择</th>
    </tr>
    <c:forEach var="room"   items="${list}">
    <tr>
        <td>${room.room_id}</td>
        <td>${room.room_num}</td>
        <td><input type="button" name="" value="更新" onclick="choose('${room.room_id}')"/></td>
    </tr>
    </c:forEach>
</table>
        </div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="js/js.cookie.js"></script>
<script src="js/chooseroom.js"></script>
        </body>
        </html>
	