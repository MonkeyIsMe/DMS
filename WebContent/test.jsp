    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:foreach 示例</title>
        </head>
        <body>
        <div style="margin: auto; width: 80%">
        <thead>
            <tr>
                <th>序号</th>&nbsp;&nbsp;
                <th>寝室</th>&nbsp;&nbsp;
                <th>学号</th>&nbsp;&nbsp;
                <th>名字</th>&nbsp;&nbsp;
                <th>床号</th>&nbsp;&nbsp;
                <th>理由</th>&nbsp;&nbsp;
                <th>时间</th>&nbsp;&nbsp;
                <br>
            </tr>
            </thead>
        <c:forEach var="fix"   items="${list}">
           	<td>${fix.fix_id}</td>&nbsp;&nbsp;
           	<td>${fix.fix_cnt}</td>&nbsp;&nbsp;
           	<td>${fix.fix_stu_id}</td>&nbsp;&nbsp;
           	<td>${fix.fix_stu_name}</td>&nbsp;&nbsp;
           	<td>${fix.fix_room_id}</td>&nbsp;&nbsp;
           	<td>${fix.fix_reason}</td>&nbsp;&nbsp;
           	<td>${fix.fix_time}</td>&nbsp;&nbsp;
           	<br>
        </c:forEach>
        </div>

        </body>
        </html>
	