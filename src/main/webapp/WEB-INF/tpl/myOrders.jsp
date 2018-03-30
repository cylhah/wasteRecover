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
    <title>我的订单</title>
</head>
<body>
    <div class="container myOrder">
        <div class="col-md-12 formHeading">
            <p>
                变废为宝是环保，废品回收举手劳
            </p>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal" role="form" name="orderForm">
                <div class="form-group">
                    <label class="col-md-2 control-label">
                        选择地址
                    </label>
                    <div class="col-md-10">
                        <select class="form-control" ng-if="haveAddress" name="address" ng-model="address">
                            <option ng-repeat="adr in myAddress"  ng-bind="adr.address+adr.specificAddress+adr.name+adr.phoneNumber" value="{{$index}}"></option>
                        </select>
                        <div class="form-control" ng-if="!haveAddress">
                            <a href="#!/myAddress">新增地址</a>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">
                        废品约重
                    </label>
                    <div class="col-md-10">
                        <select class="form-control" ng-model="weight">
                            <option value="<0.5kg"><0.5kg</option>
                            <option value="0.5kg">0.5kg</option>
                            <option value="1.0kg">1.0kg</option>
                            <option value="1.5kg">1.5kg</option>
                            <option value="2.0kg">2.0kg</option>
                            <option value="2.5kg">2.5kg</option>
                            <option value="3.0kg">3.0kg</option>
                            <option value="3.5kg">3.5kg</option>
                            <option value="4.0kg">4.0kg</option>
                            <option value="4.5kg">4.5kg</option>
                            <option value="5.0kg">5.0kg</option>
                            <option value=">5.0kg">>5.0kg</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">
                        废品种类
                    </label>
                    <div class="col-md-10" id="mySelect">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">
                        选择日期
                    </label>
                    <div class="col-md-10">
                            <select ng-model="date" class="form-control">
                                <option value="0" selected="selected">今天</option>
                                <option value="1">明天</option>
                                <option value="2">后天</option>
                            </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">
                        选择时间
                    </label>
                    <div class="col-md-10">
                        <select class="form-control" ng-model="time">
                            <option ng-if="date=='0'" ng-repeat="tempTime in time1" ng-bind="tempTime" value="{{tempTime}}"></option>
                            <option ng-if="!(date=='0')" ng-repeat="tempTime in time2" ng-bind="tempTime" value="{{tempTime}}"></option>
                        </select>
                    </div>
                </div>
                <div class="submit">
                    <button class="myBtn" ng-click="submitOrder()">提交订单</button>
                </div>
            </form>
        </div>
    </div>

<script>
    document.getElementById("mySelect").appendChild(document.getElementById("weightSelect"));
</script>
</body>
</html>
