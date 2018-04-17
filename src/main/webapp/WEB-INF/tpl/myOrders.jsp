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
        .timeTable.ng-hide{
            height: 0;
        }
        @keyframes msgFade1 {
            0% {
                opacity: 0;
            }
            50% {
                opacity: 100;
            }
            100%{
                opacity: 0;
            }
        }
        @keyframes msgFade {
            0% {
                opacity: 0;
            }
            50% {
                opacity: 100;
            }
            100%{
                opacity: 0;
            }
        }
        @keyframes aroundFade{
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }
        .message{
            opacity: 0;
            position: absolute;
            top: 100%;
            left: 50%;
            margin: 0 0 0 -65px;
            z-index: 15;
            background: black;
            color: white;
            border-radius: 6px;
            padding: 10px 20px;
            font-size: 20px;
        }
        .around{
            color: white;
            height: 40px;
            text-align: center;
            background: rgba(98,206,98,0.8);
            font-size: 20px;
            line-height: 40px;
            position: fixed;
            bottom: 0;
            width: 100%;
            padding: 0;
            animation: aroundFade 3s;
            animation-timing-function:ease-in;
        }
    </style>
    <title>开始订单</title>
</head>
<body>

<div class="container" style="background: rgba(242,242,242,0.8);padding-top: 15px;">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-md-12">
                    <select class="form-control" id="address" ng-model="addressIndex">
                        <option ng-repeat="adr in myAddress"  ng-bind="adr.address+adr.specificAddress+adr.name+adr.phoneNumber" value="{{$index}}"></option>
                    </select>
                    <div class="form-control" ng-if="!haveAddress">
                        <a href="#!/addAddress" style="color: rgb(153,153,153)">新增地址</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <select class="form-control" ng-model="weight" data-live-search="true">
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
            </div>
        </form>
</div>

<div class="message">请填写时间</div>

<div class="container timeTable" ng-hide="timeTable">
    <div class="col-xs-12">
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="color:grey;font-size: 15px;font-weight: bold" ng-click="closeTime()">取消</a>
        </div>
        <div class="col-xs-6">
            <p style="color: white;font-size: 25px;">选择时间</p>
        </div>
        <div class="col-xs-3" style="padding: 8px 0 0 5px;text-align: center">
            <a href="" style="font-size: 15px;color: rgb(98,206,98);font-weight: bold" ng-click="confirmTime()">确定</a>
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
            </div>
        </div>
        <div class="swiper-container swiper3 col-xs-4">
            <div class="swiper-wrapper">
            </div>
        </div>
    </div>
</div>

<div class="around">您周围有<span ng-bind="aroundNum"></span>个用户也下了单</div>
</body>
</html>
