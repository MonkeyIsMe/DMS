    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="css/man-maincss.css" type="text/css">
    <link rel="stylesheet" href="css/stu_count_css.css" type="text/css">
        </head>
        <body>
        <div class="bar" id="bar">
            <nav class="navbar navbar-default nav-justified nav-style" role="navigation">
                <div>
                    <ul class="nav navbar-nav center-block" style="margin-left: 60px">
                        <li><a href="stu-main.html">主页</a></li>
                        <li><a href="to-choose.html">选宿舍</a></li>
                        <li><a href="QueryPay.jsp" >缴纳水电费</a></li>
                        <li><a href="to-change.html" >申请交换宿舍</a></li>
                        <li><a href="to-repair.html" >申请维修</a></li>
                        <li><a href="QueryInformation" >查看公告信息</a></li>
                        <li style="margin-left: 750px"><a href="UpdateMyinfo.html">更新信息</a></li>
                    </ul>
                    <input id="out" class="btn" type="submit" value="登出" style="margin-top: 6px;background-color: white">
                </div>
            </nav>
        </div>
    </div>
<div class="input">
<form action="Test" method="post">
          <div class="form-group change_input">
            <label>订单号</label>
            <input type="text" class="form-control" id="pay_id"  name="pay_id"  onfocus="this.blur()">
        </div>
        <div class="form-group change_input">
            <label>订单名称</label>
            <input type="text" class="form-control" id="pay_description"  name="pay_description" onfocus="this.blur()">
        </div>

        <div class="form-group change_input">
            <label>付款金额</label>
            <input type="text" class="form-control" id="pay_money"   name="pay_money" onfocus="this.blur()">
        </div>

        <div class="form-group change_input">
            <label>订单描述</label>
            <input type="text" class="form-control" id="pay_body"  name="pay_body" onfocus="this.blur()">
        </div>
                <div style="margin-left: 48%;margin-top: 20px">
            <input id="sub" class="btn btn-default" type="submit"  value="提交">
        </div>
</form>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/js.cookie.js"></script>
<script src="js/pay.js"></script>
        </body>
        </html>
	