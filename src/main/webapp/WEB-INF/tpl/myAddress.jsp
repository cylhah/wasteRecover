<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/1
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" style="background: rgba(242,242,242,0.8);padding-top: 15px;left: 5%;width: 95%">
    <div style="color:rgb(179, 175, 170)">
        常用地址
    </div>
    <div ng-repeat="adr in myAddress" style="border-bottom: 2px solid grey">
        <div>
            <h3>
                <a href="#!/myOrders" ng-bind="adr.address" style="color: black"></a>
            </h3>
            <p>
                <label ng-bind="adr.specificAddress"></label>
                <a href="#!/addAddress" ng-click="reviseAddress($index)" style="float: right;font-size: 25px">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
            </p>
            <p>
                <label ng-bind="adr.name" style="color:rgb(179, 175, 170)"></label>
                <label ng-bind="adr.phoneNumber" style="color:rgb(179, 175, 170)"></label>
            </p>
        </div>
    </div>
    <div style="margin: 10px">
        <button class="btn btn-success" ng-click="add()">新增地址</button>
    </div>
</div>
</body>
</html>
