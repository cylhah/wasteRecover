<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>
<div class="container" style="background: rgb(243,243,243);padding: 0;height: 90%">
    <div class="col-md-12" style="color:rgb(179, 175, 170)">
        订单管理
    </div>
    <div ng-repeat="order in myOrders" class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p ng-bind="order.time"></p>
        <p><label ng-bind="order.address+' '+order.name"></label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px" ng-bind="order.money"></label></p>
        <p ng-bind="order.type"></p>
        <p ng-bind="order.collector"></p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 江铮</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
    <div class="col-md-12" style="background: white;border: 3px solid rgb(243,243,243)">
        <p>2018.3.28 8:50</p>
        <p><label>浙江科技学院西和公寓12幢 王宇超</label></p>
        <p><label style="float:right;color: rgb(255,186,111);font-size: 20px">5.6元</label></p>
        <p>纸板1kg 电器2kg</p>
        <p>回收员：陈XX 13758158243</p>
    </div>
</div>
</body>
</html>
