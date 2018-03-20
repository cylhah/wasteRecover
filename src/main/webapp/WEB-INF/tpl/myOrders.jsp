<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../../resources/css/myOrders.css" rel="stylesheet" type="text/css">
    <script src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
    <script src="../../resources/js/angular.min.js"></script>
    <script src="../../resources/js/bootstrap-select.min.js"></script>
    <script src="../../resources/js/angular-animate.min.js"></script>
    <script src="../../resources/js/myOrders.js"></script>
    <title>我的订单</title>
</head>
<body ng-app="myOrder">
  <div class="container" ng-controller="formCtrl">
    <div class="col-md-12 formHeading">
        <p>
            变废为宝是环保，废品回收举手劳
        </p>
    </div>
    <div class="col-md-12 orderForm">
        <div class="info">
            <select class="mySelect" ng-model="weight">
                <option value=""><0.5kg</option>
                <option>0.5kg</option>
                <option>1.0kg</option>
                <option>1.5kg</option>
                <option>2.0kg</option>
                <option>2.5kg</option>
                <option>3.0kg</option>
                <option>3.5kg</option>
                <option>4.0kg</option>
                <option>4.5kg</option>
                <option>5.0kg</option>
                <option>>5.0kg</option>
            </select>
        </div>
        <div class="info">
          <input type="checkbox">塑料
          <input type="checkbox">纸板
          <input type="checkbox">金属
          <input type="checkbox">电器
          <input type="checkbox">电池
        </div>
        <%--<div class="info" >--%>
            <%--<a href="#" ng-focus="showTime()" ng-blur="closeTime()">请选择时间</a>--%>
        <%--</div>--%>
        <div class="info" >
            <div class="col-md-12">
                <input type="radio" name="date1" value="today" ng-model="date" checked>今天
                <input type="radio" name="date1" value="tomorrow" ng-model="date">明天
                <input type="radio" name="date1" value="theDayAfterTomorrow" ng-model="date">后天
                <select class="mySelect">
                    <option ng-if="date=='today'" ng-repeat="time in time1" ng-bind="time"></option>
                    <option ng-if="!(date=='today')" ng-repeat="time in time2" ng-bind="time"></option>
                </select>
            </div>
            <%--<div class="dropdown">--%>
                <%--<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">--%>
                    <%--请选择时间--%>
                    <%--<span class="caret"></span>--%>
                <%--</button>--%>
                <%--<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">--%>
                    <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>--%>
                    <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>--%>
                    <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>--%>
                    <%--<li role="presentation"><a role="menuitem" tabindex="-1" href="#">下拉菜单项</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
        <div class="info">
          请选择地址
        </div>
        <div class="submit">
            <button class="btn btn-success myBtn" type="button">提交订单</button>
        </div>
    </div>
    <%--<div class="col-md-14" ng-hide="showTimeTable">--%>
        <%--<div class="col-md-12 formHeading">--%>
            <%--选择时间--%>
          <%--</div>--%>
          <%--<div class="col-md-14">--%>
              <%--<ul class="nav nav-tabs">--%>
                  <%--<li><a href="#">今天</a></li>--%>
                  <%--<li><a href="#">明天</a></li>--%>
                  <%--<li><a href="#">后天</a></li>--%>
              <%--</ul>--%>
          <%--</div>--%>
          <%--<div class="col-md-14">--%>
            <%--<p>8:00</p>--%>
            <%--<p>8:30</p>--%>
            <%--<p>9:00</p>--%>
            <%--<p>9:30</p>--%>
            <%--<p>10:00</p>--%>
            <%--<p>10:30</p>--%>
            <%--<p>11:00</p>--%>
            <%--<p>11:30</p>--%>
            <%--<p>12:00</p>--%>
            <%--<p>12:30</p>--%>
            <%--<p>13:00</p>--%>
            <%--<p>13:30</p>--%>
            <%--<p>14:00</p>--%>
            <%--<p>14:30</p>--%>
            <%--<p>15:00</p>--%>
            <%--<p>15:30</p>--%>
            <%--<p>16:00</p>--%>
            <%--<p>16:30</p>--%>
            <%--<p>17:00</p>--%>
            <%--<p>17:30</p>--%>
            <%--<p>18:00</p>--%>
            <%--<p>18:30</p>--%>
            <%--<p>19:00</p>--%>
            <%--<p>19:30</p>--%>
            <%--<p>20:00</p>--%>
            <%--<p>20:30</p>--%>
          <%--</div>--%>
    <%--</div>--%>
  </div>
</body>
</html>
