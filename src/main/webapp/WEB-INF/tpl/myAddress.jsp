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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/angular.min.js"></script>
    <script src="../js/myAddress.js"></script>
    <title>我的地址</title>
</head>
<body ng-app="myAddress">
  <div class="container" ng-controller="addressCtrl">
    <div class="col-md-12">
      <p>
        当前地址
      </p>
      <p>
        <label>
          浙江科技学院西和公寓
        </label>
        <label>
            <a href="#">
                <span class="glyphicon glyphicon-map-marker"></span>重新定位
            </a>
        </label>
      </p>
    </div>
    <div class="col-md-12">
      <div>
        常用地址
      </div>
      <div>
        <h1>
          浙江科技学院西和公寓
        </h1>
        <p>
          <label>
            12幢609寝室            
          </label>
          <a href="#">
              <span class="glyphicon glyphicon-pencil"></span>
            </a>
        </p>
        <p>
          <label>
            陈永雷
          </label>
          <label>
            137582728271
          </label>
        </p>
      </div>
      <div>
          <h1>
            浙江科技学院西和公寓
          </h1>
          <p>
            <label>
              12幢609寝室            
            </label>
            <a href="#">
                <span class="glyphicon glyphicon-pencil"></span>
              </a>
          </p>
          <p>
            <label>
              陈永雷
            </label>
            <label>
              137582728271
            </label>
          </p>
        </div>
        <div>
            <a href="#" ng-click="add()">
                新增地址
            </a>
        </div>
      </div>
      <div class="col-md-12" ng-hide="edit">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-md-2 control-label">
              联系人
            </label>
            <div class="col-md-10">
              <input type="text" class="form-control" placeholder="姓名">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-2 control-label">
              电话
            </label>
            <div class="col-md-10">
              <input type="text" class="form-control" placeholder="手机号码">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-2 control-label">
              地址
            </label>
            <div class="col-md-10">
              <label class="control-label">
                浙江科技学院西和公寓
              </label>
              <label class="control-label">
                <a href="#">
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
              <input type="text" class="form-control" placeholder="详细地址">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-6">
                <button class="btn btn-success">保存</button>
            </label>
          </div>
        </form>        
      </div>
    </div>
  </div>
</body>
</html>
