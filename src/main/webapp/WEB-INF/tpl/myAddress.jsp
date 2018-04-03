<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/18
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的地址</title>
</head>
<body>
  <div class="container">
    <div class="col-md-12" style="border-bottom: 2px solid grey">
      <p style="color:rgb(179, 175, 170)">
        当前地址
      </p>
      <p>
        <label id="location">
        </label>
        <label>
            <a href="#!/myAddress" ng-click="getLocationInf()">
                <span class="glyphicon glyphicon-map-marker"></span>重新定位
            </a>
        </label>
      </p>
    </div>
    <div class="col-md-12">
      <div style="color:rgb(179, 175, 170)">
        常用地址
      </div>
      <div ng-repeat="adr in myAddress" style="border-bottom: 2px solid grey">
        <div>
          <h3>
            <a href="#!/myOrders" ng-bind="adr.address"></a>
          </h3>
          <p>
            <label ng-bind="adr.specificAddress"></label>
            <a href="#!/myAddress" ng-click="reviseAddress($index)" style="float: right;font-size: 25px">
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
          <button class="btn btn-primary" ng-click="add()">新增地址</button>
      </div>
        <div class="container" style="padding: 0">
            <div class="col-md-12" ng-hide="edit">
                <form class="form-horizontal" role="form" name="addressForm">
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            联系人
                        </label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" placeholder="姓名" ng-model="name" name="name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            电话
                        </label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" placeholder="手机号码" ng-model="phoneNumber" name="phoneNumber" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            地址
                        </label>
                        <div class="col-md-10">
                            <label class="control-label" id="address" ng-bind="address">
                            </label>
                            <label class="control-label">
                                <a href="#!/myAddress" ng-click="searchAddress()">
                                    <span class="glyphicon glyphicon-search"></span>
                                </a>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            备注
                        </label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" placeholder="详细地址" ng-model="specificAddress" name="specificAddress" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-6">
                            <button class="btn btn-success" ng-click="submitAddress()" ng-disabled="addressForm.name.$invalid||addressForm.phoneNumber.$invalid||addressForm.specificAddress.$invalid">保存</button>
                        </label>
                    </div>
                </form>
            </div>
            <div class="col-md-12" ng-hide="search" style="padding: 0">
                <div id="l-map" style="height: 300px;width: 100%;" ></div>
                <div id="r-result"><input type="text" id="suggestId" size="20" placeholder="搜索地址" style="width:100%;" /></div>
                <div id="searchResultPanel" style="border:1px solid #C0C0C0;height:auto;display: none"></div>
                <div><button class="btn btn-info" ng-click="confirmAddress()">保存</button></div>
            </div>
        </div>
        <%--<div class="modal fade" id="adr" role="dialog" aria-hidden="true">--%>
            <%--<div class="modal-dialog">--%>
                <%--<div class="modal-content">--%>
                    <%--<div class="col-md-12" style="margin: 10px">--%>
                        <%--<form class="form-horizontal" role="form">--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-md-2 control-label">--%>
                                    <%--联系人--%>
                                <%--</label>--%>
                                <%--<div class="col-md-10">--%>
                                    <%--<input type="text" class="form-control" placeholder="姓名" ng-model="name">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-md-2 control-label">--%>
                                    <%--电话--%>
                                <%--</label>--%>
                                <%--<div class="col-md-10">--%>
                                    <%--<input type="text" class="form-control" placeholder="手机号码" ng-model="phoneNumber">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-md-2 control-label">--%>
                                    <%--地址--%>
                                <%--</label>--%>
                                <%--<div class="col-md-10">--%>
                                    <%--<label class="control-label" id="address" ng-bind="address">--%>
                                    <%--</label>--%>
                                    <%--<label class="control-label">--%>
                                        <%--<a href="#" ng-click="search">--%>
                                            <%--<span class="glyphicon glyphicon-search"></span>--%>
                                        <%--</a>--%>
                                    <%--</label>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="col-md-2 control-label">--%>
                                    <%--备注--%>
                                <%--</label>--%>
                                <%--<div class="col-md-10">--%>
                                    <%--<input type="text" class="form-control" placeholder="详细地址" ng-model="specificAddress">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group" style="text-align: center">--%>
                                    <%--<button class="btn btn-success" ng-click="submitAddress()" data-dismiss="modal" style="padding: 10px 30px 10px 30px">保存</button>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>


    </div>
  </div>
</body>


</html>
