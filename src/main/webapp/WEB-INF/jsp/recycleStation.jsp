<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/8
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="stationApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/swiper.min.css" rel="stylesheet">
    <link href="../../resources/css/recycleStation.css" rel="stylesheet">

    <script src="../../resources/js/swiper.min.js"></script>
    <script src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
    <script src="../../resources/js/angular.min.js"></script>
    <script src="../../resources/js/angular-route.min.js"></script>
    <script src="../../resources/js/angular-animate.min.js"></script>
    <script src="../../resources/js/app.js"></script>
    <script src="../../resources/js/controllers.js"></script>
    <script src="../../resources/js/service.js"></script>
    <title>中转站</title>
</head>
<body ng-controller="stationViewCtrl">
<div class="container topNav">
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar" style="background: white"></span>
                <span class="icon-bar" style="background: white"></span>
                <span class="icon-bar" style="background: white"></span>
            </button>
            <a href="##" class="navbar-brand">蓝鸥e家</a>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#" id="homepage">首页</a></li>
                <li><a href="#!/orderManage" id="orderManage" ng-click="orderMng()" class="title">订单管理</a></li>
                <li><a href="#!/collectorManage" id="collectorManage" class="title">回收员管理</a></li>
                <li><a href="#!/scrapManage" id="scrapMange" class="title">废品管理</a></li>
                <li><a href="#!/communityManage" id="community" class="title">社区管理</a></li>
            </ul>
        </div>
    </div>
</div>
<div ng-view=""></div>

</body>
</html>
