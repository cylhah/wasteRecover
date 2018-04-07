<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/1
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        @keyframes myChange {
            from {
                height: 100px;
            } to {
                  height: 0;
              }
        }
        .searchDiv{
            text-align:center;
            width: 100%;
            height: 100%;
            background: rgba(242,242,242,0.8);
            padding:0
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container" style="background: rgba(242,242,242,0.8);padding-top: 15px;" ng-hide="edit">
    <div class="col-md-12">
        <form class="form-horizontal" role="form" name="addressForm">
            <div class="form-group">
                <div class="col-md-12">
                    <input type="text" class="form-control" placeholder="请输入姓名" ng-model="name" name="name" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <input type="text" class="form-control" placeholder="请输入手机号码" ng-model="phoneNumber" name="phoneNumber" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <label class="control-label" id="address" ng-bind="address">
                    </label>
                    <label class="control-label">
                        <a href="" ng-click="searchAddress()">
                            <span class="glyphicon glyphicon-search"></span>
                        </a>
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <input type="text" class="form-control" placeholder="请输入详细地址" ng-model="specificAddress" name="specificAddress" required>
                </div>
            </div>
            <div class="form-group" style="text-align: center">
                    <button class="btn btn-success" ng-click="submitAddress()" ng-disabled="addressForm.name.$invalid||addressForm.phoneNumber.$invalid||addressForm.specificAddress.$invalid">保存</button>
            </div>
        </form>
    </div>
</div>
<div class="container searchDiv" ng-show="search">
    <div class="col-xs-12">
        <div class="col-xs-9" style="padding: 0;"><input type="text" id="suggestId" size="20"  style="font-size:20px;width:100%;padding: 10px;border-radius: 8px;border: 1px solid rgb(242,242,242)" placeholder="请搜索地址(尽量详细)"></div>
        <div class="col-xs-3" style="padding: 10px 0 0 10px;"><a href="" style="font-size: 18px;font-weight: bold;text-decoration: none" ng-click="confirmAddress()">确定</a></div>
    </div>
    <div id="searchResultPanel" style="display:none;"></div>
</div>
</body>
</html>
