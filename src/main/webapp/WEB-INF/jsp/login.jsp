<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="loginApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../../resources/css/login.css" rel="stylesheet">
    <script src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
    <script src="../../resources/js/angular.min.js"></script>
    <script src="../../resources/js/angular-route.min.js"></script>
    <script src="../../resources/js/angular-animate.min.js"></script>
    <script src="../../resources/js/app.js"></script>
    <script src="../../resources/js/controllers.js"></script>
    <title>登录</title>
</head>
<body ng-controller="loginCtrl">
<div class="wrapper">
    <div class="container loginForm">
        <div class="col-md-8 formHeading">
            <h1>欢迎您的登录</h1>
            <h3>资源回收</h3>
        </div>
        <div class="col-md-8">
            <form class="form-horizontal" role="form" name="loginForm" novalidate>
                <div class="form-group">
                    <select class="mySelect" ng-model="loginType">
                        <option value="client">用户登录</option>
                        <option value="server">回收员登录</option>
                        <option value="corporation">企业登录</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" placeholder="用户名" ng-model="account" name="account" required>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="密码" ng-model="password" name="password" required>
                </div>
                <div class="form-group">
                    <button class="loginBtn" ng-click="login()" ng-disabled="loginForm.account.$invalid ||loginForm.password.$invalid">登录</button>
                </div>
                <div class="form-group">
                    <label id="message"></label>
                </div>
            </form>
        </div>
    </div>
    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</body>
</html>
