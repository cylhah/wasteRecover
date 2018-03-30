<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/10
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="clientApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/myOrders.css" rel="stylesheet">
    <link href="../css/client.css" rel="stylesheet" >

    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap-select.min.js"></script>
    <script src="../js/angular.min.js"></script>
    <script src="../js/angular-route.min.js"></script>
    <script src="../js/angular-animate.min.js"></script>
    <script src="../js/angular-sanitize.min.js"></script>
    <script src="../js/app.js"></script>
    <script src="../js/controllers.js"></script>
    <script src="../js/service.js"></script>
    <script src="../js/directive.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=1bskosXE4iAXX6BSVt5X5XFn90530zyU"></script>

    <title>用户</title>
</head>
<body ng-controller="clientViewCtrl">
<div class="container">
    <ul class="nav nav-tabs">
        <li><a href="" data-toggle="modal" data-target="#info"><span class="glyphicon glyphicon-user" style="color: rgb(112, 112, 112);"></span></a></li>
        <li><a href="#!/myOrders">开始订单</a></li>
        <li><a href="#!/orderManage">我的订单</a> </li>
        <li><a href="#!/myAddress">地址管理</a> </li>
    </ul>
</div>
<div ng-view=""></div>

<div class="modal fade" id="info" role="dialog" aria-hidden="true" style="position: absolute;left: -9%;transform: translateX(-9%);">
    <div class="modal-dialog" style="width: 250px;">
        <div class="modal-content">
            <div class="container" style="height: 90%;width: 100%">
                <div class="col-md-6">
                    <div class="infoHeading">
                        <label>
                            <span class="glyphicon glyphicon-user" style="color: rgb(112, 112, 112);"></span>13758158277</label>
                    </div>
                    <div>
                        <ul>
                            <li>
                                <a href="#!/myOrders" ng-click="gotoMyOrders()" data-dismiss="modal">
                                    <span class="glyphicon glyphicon-pencil"></span>开始订单</a>
                            </li>
                            <li>
                                <a href="#/orderManage" ng-click="gotoOrderManage()" data-dismiss="modal" >
                                    <span class="glyphicon glyphicon-file"></span>我的订单</a>
                            </li>
                            <li>
                                <a href="#!/myAddress" ng-click="gotoMyAddress()" data-dismiss="modal">
                                    <span class="glyphicon glyphicon-home"></span>地址管理</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="data">

</div>
<div style="display: none">
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
    <div id="weightSelect">
        <select class="selectpicker form-control"  title="废品种类" multiple ng-model="type">
            <option value="塑料">塑料</option>
            <option value="纸板">纸板</option>
            <option value="金属">金属</option>
            <option value="电器">电器</option>
            <option value="电池">电池</option>
        </select>
    </div>
</div>
</body>
</html>
