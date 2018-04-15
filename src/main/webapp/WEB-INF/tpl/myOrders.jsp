<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/1
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .swiper-slide{
            font-weight: bold;
            color: black;
            opacity: 0.4;
        }
        .swiper-slide-next,.swiper-slide-prev{
            opacity: 0.7;
        }
        .swiper-slide-active{
            color: white;
            opacity: 1;
        }
        .formTime{
            cursor: pointer;
        }
        .timeTable{
            transition: all linear 0.5s;
            height: 200px;
            text-align: center;
            background: rgba(48,48,48,0.8);
            position: fixed;
            bottom: 0;
            width: 100%;
            padding: 0
        }
        .timeTable.ng-hide{
            height: 0;
        }
    </style>
    <title>开始订单</title>
</head>
<body>

<div class="container" style="background: rgba(242,242,242,0.8);padding-top: 15px;">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-md-12">
                    <div ng-if="haveAddress">
                    <select class="form-control" id="address">
                        <option ng-repeat="adr in myAddress"  ng-bind="adr.address+adr.specificAddress+adr.name+adr.phoneNumber" value="{{$index}}"></option>
                    </select>
                        </div>
                    <div class="form-control" ng-if="!haveAddress">
                        <a href="#!/addAddress" style="color: rgb(153,153,153)">新增地址</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
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
                <div class="col-md-12">
                    <div class="form-control formTime" ng-click="openTimeTable()">
                        <span class="glyphicon glyphicon-time" style="color: rgb(153,153,153);padding-right: 5px"></span><span ng-bind="time"></span>
                    </div>
                </div>
            </div>
            <div class="form-group" style="text-align: center">
                <button class="myBtn" ng-click="submitOrder()">提交订单</button>
                <p id="message"></p>
            </div>
        </form>
</div>

<div class="container timeTable" ng-hide="timeTable">
    <div class="col-xs-12">
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="color:grey;font-size: 15px;font-weight: bold" ng-click="closeTime()">取消</a>
        </div>
        <div class="col-xs-6">
            <p style="color: white;font-size: 25px;">选择时间</p>
        </div>
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="font-size: 15px;color: red;font-weight: bold" ng-click="confirmTime()">确定</a>
        </div>
    </div>
    <div style="width: 100%;height: 30px;background: rgba(98, 206, 98,0.9);position: absolute;top: 42px;">

    </div>
    <div class="col-xs-12">
        <div class="swiper-container swiper1 col-xs-4">
            <div class="swiper-wrapper">
                <div class="swiper-slide">今天</div>
                <div class="swiper-slide">明天</div>
                <div class="swiper-slide">后天</div>
            </div>
        </div>
        <div class="swiper-container swiper2 col-xs-4">
            <div class="swiper-wrapper">
                    <div class="swiper-slide">7点</div>
                    <div class="swiper-slide">8点</div>
                    <div class="swiper-slide">9点</div>
                    <div class="swiper-slide">10点</div>
                    <div class="swiper-slide">11点</div>
                    <div class="swiper-slide">12点</div>
                    <div class="swiper-slide">13点</div>
                    <div class="swiper-slide">14点</div>
            </div>
        </div>
        <div class="swiper-container swiper3 col-xs-4">
            <div class="swiper-wrapper">
                <div class="swiper-slide" ng-repeat="minute in minutes" ng-bind="minute"></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
