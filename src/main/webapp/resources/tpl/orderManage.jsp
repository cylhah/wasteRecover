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
        .swiperOrders{
            height: 384px;
        }
        /*.swiper-slide{*/
            /*height: 128px;*/
        /*}*/
        .score.swiper-slide{
            font-weight: bold;
            color: black;
            opacity: 0.4;
        }
        .score.swiper-slide-next,.swiper-slide-prev{
            opacity: 0.7;
        }
        .score.swiper-slide-active{
            color: white;
            opacity: 1;
        }
        .score{
            font-size: 13px;
            padding: 0 3px;
        }
        .swiperScore{
            height: 200px;
        }
        .scoreTable{
            z-index: 16;
            transition: all linear 0.3s;
            height: 200px;
            text-align: center;
            background: rgba(48,48,48,0.8);
            position: fixed;
            bottom: 0;
            width: 100%;
            padding: 0;
        }
        .scoreTable.ng-hide{
            height: 0;
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
                                <p><label class="moneyInfo" ng-bind="tempOrder.price"></label></p>
                                <p ng-init="tempWeight=tempOrder.weight"><span class="label label-info typeInfo" ng-repeat="(i,j) in tempWeight">{{i+' '+j}}</span></p>
                                <p class="serverInfo"><span class="glyphicon glyphicon-user"></span> 回收员：{{tempOrder.server.name}} {{tempOrder.server.phone}}
                                    <button class="btn btn-success score" ng-if="tempOrder.scoreType==0" ng-click="scoreCol(page*5+x)">评价</button>
                                    <span class="label label-warning" ng-if="tempOrder.scoreType==1">已评价</span>
                                </p>
                                <p class="time" ng-bind="tempOrder.time">
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
</div>


<div class="container scoreTable" ng-hide="scoreTable">
    <div class="col-xs-12">
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="color:grey;font-size: 15px;font-weight: bold" ng-click="closeScore()">取消</a>
        </div>
        <div class="col-xs-6">
            <p style="color: white;font-size: 25px;">选择分数</p>
        </div>
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="font-size: 15px;color: rgb(98,206,98);font-weight: bold" ng-click="submitScore()">确定</a>
        </div>
    </div>
    <div style="width: 100%;height: 30px;background: rgba(98, 206, 98,0.9);position: absolute;top: 42px;">

    </div>
    <div class="col-xs-12">
        <div class="swiper-container swiperScore">
            <div class="swiper-wrapper">
                <div class="swiper-slide score">1分</div>
                <div class="swiper-slide score">2分</div>
                <div class="swiper-slide score">3分</div>
                <div class="swiper-slide score">4分</div>
                <div class="swiper-slide score">5分</div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
