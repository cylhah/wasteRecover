<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .orders{
            padding: 0;
        }
        .oneOrder{
            background: rgba(255,255,255,0.8);
            border: 1px solid rgb(243,243,243);
            line-height: 30px;
            height: 100%;
        }
        .typeInfo{
            margin-left: 5px;
            padding: 5px;
        }
        .moneyInfo{
            position: absolute;
            right: 5%;
            bottom: 5%;
            color: rgb(255,186,111);
            font-size: 20px;
        }
        .orderType{
            position: absolute;
            right: 5%;
            top:9%;
        }
        .serverInfo{
            margin: 0;
        }
        .clientInfo{
            margin-top: 5px;
        }
        .clientInfo label{
            margin: 0;
        }
        .time{
            color: rgb(175,175,175);
            margin: 0;
        }
        .swiper-container{
            height: 384px;
        }
        .swiper-slide{
            height: 128px;
        }
    </style>
    <title>订单管理</title>
</head>
<body>
<div class="container orders">
    <div class="swiper-container swiperOrders">
        <div class="swiper-wrapper" id="swiperOrders">
            <div class="swiper-slide" ng-repeat="page in pages">
                <div class="swiper-container swiperV">
                    <div class="swiper-wrapper" id="oneOrder">
                        <div class="swiper-slide" ng-repeat="x in count">
                            <div class="col-md-12 oneOrder" ng-init="tempOrder=orders[page*5+x]" ng-if="page*5+x<ordersNum">
                                <p class="clientInfo"><label ng-bind="tempOrder.address+' '+tempOrder.name"></label></p>
                                <p class="orderType"><span class="label label-success" ng-bind="tempOrder.type"></span></p>
                                <p><label class="moneyInfo" ng-bind="tempOrder.money"></label></p>
                                <p ng-init="tempWeight=tempOrder.weight"><span class="label label-info typeInfo" ng-repeat="(i,j) in tempWeight">{{i+' '+j}}</span></p>
                                <p class="serverInfo"><span class="glyphicon glyphicon-user"></span> 回收员：{{tempOrder.server.name}} {{tempOrder.server.phone}}</p>
                                <p class="time" ng-bind="tempOrder.time"></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
</div>

</body>
</html>
