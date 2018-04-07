<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/31
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="clientApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../../resources/css/client.css" rel="stylesheet">
    <link href="../../resources/css/swiper.min.css" rel="stylesheet">

    <script src="../../resources/js/swiper.min.js"></script>
    <script src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
    <script src="../../resources/js/bootstrap-select.min.js"></script>
    <script src="../../resources/js/angular.min.js"></script>
    <script src="../../resources/js/angular-route.min.js"></script>
    <script src="../../resources/js/angular-animate.min.js"></script>
    <script src="../../resources/js/angular-sanitize.min.js"></script>
    <script src="../../resources/js/app.js"></script>
    <script src="../../resources/js/controllers.js"></script>
    <script src="../../resources/js/service.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=1bskosXE4iAXX6BSVt5X5XFn90530zyU"></script>

    <title>用户</title>
    <style type="text/css">
        body, html,#myMap {width: 100%;height: 100%}
    </style>
</head>
<body>
<div id="myMap" ></div>
<div class="container" style="position:absolute;z-index: 15;top:0;left: 0;width: 100%;padding: 0">
    <div class="col-xs-12 head">
        <div class="col-xs-2" style="height: 35px;padding-top: 3px;"><span class="glyphicon glyphicon-th-list navIcon" data-toggle="modal" data-target="#menu"></span></div>
        <div class="col-xs-8 title">资源回收</div>
    </div>
</div>
<div class="container" style="position:absolute;z-index: 15;top:10%;width: 100%;padding: 0">
    <div ng-view=""></div>
</div>
<div class="modal fade" id="menu" role="dialog" aria-hidden="true" ng-controller="clientViewCtrl">
    <div class="modal-dialog" style="margin: 0;height: 100%;width: 0">
        <div class="modal-content" style="position:fixed;z-index: 20;top: 0;left:0;background: black;height: 100%">
            <div class="info">
                <p><span class="glyphicon glyphicon-user menuIcon" ></span>137581582743</p>
            </div>
            <div class="menu">
                <p><a href="#!/myOrders" data-dismiss="modal" ng-click="gotoMyOrders()"><span class="glyphicon glyphicon-pencil"></span>开始订单</a> </p>
                <p><a href="#!/orderManage" data-dismiss="modal" ng-click="gotoOrderManage()"><span class="glyphicon glyphicon-file"></span>我的订单</a></p>
                <p><a href="#!/myAddress" data-dismiss="modal" ng-click="gotoMyAddress()"><span class="glyphicon glyphicon-home"></span>地址管理</a></p>
            </div>
        </div>

    </div>

</div>

</body>
</html>



