<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/11
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .myCon{
            width: 100%;
        }
        .menu{
            text-align: center;
        }
        .item{
            padding: 10px 20px;
            font-size: 25px;
            border-right: 2px solid grey;
            cursor: pointer;
            margin: 5px;
        }
        .item:hover{
            color: rgb(1,207,207) !important;
            border-right: 2px solid rgb(1,207,207) !important;
        }
        .filter{
            height: 60px;
            padding: 10px 0 0 10px;
        }
        .daySelect{
            margin: 5px;
            height: 30px;
        }
        .daySelect option{
            font-size: 20px;
        }
        .typeSelect{
            margin: 5px;
            height: 30px;
        }
        .swiperY{
            height: 100px;
        }
        .swiper-slide{
            font-size: 20px;
            padding-top: 30px;
        }
        .color0{
            background: rgb(242,222,222);
        }
        .color1{
            background: rgb(222,234,217);
        }
        .pagination{
            text-align: center;
            /*padding-left: 300px;*/
            margin-top: 0;
        }
        .page{
            cursor: pointer;
            margin: 5px;
            text-align: center;
            background: rgb(1,207,207);
            width: 20px;
            height: 20px;
            color: white;
            font-size: 15px;
            border-radius: 50%;
        }
        .comInput{
            margin: 4px;
            padding: 10px ;
        }
        .intro{
            margin: 5px;
            height: 30px;
            font-size: 20px;
            font-weight: bold;
            line-height: 30px;
            text-align: center;
        }
        .confirm{
            margin: 4px;
        }
    </style>
    <title>订单管理</title>
</head>
<body>
<div class="container myCon">
    <div class="col-xs-12">
        <div class="col-xs-2 menu">
            <div class="swiper-container swiperY">
                <div class="swiper-wrapper">
                </div>
                <div class="swiper-pagination"></div>
            </div>
            <div class="item" id="m12" ng-click="chooseMon($event)">
                12月
            </div>
            <div class="item" id="m11" ng-click="chooseMon($event)">
                11月
            </div>
            <div class="item" id="m10" ng-click="chooseMon($event)">
                10月
            </div>
            <div class="item" id="m9" ng-click="chooseMon($event)">
                9月
            </div>
            <div class="item" id="m8" ng-click="chooseMon($event)">
                8月
            </div>
            <div class="item" id="m7" ng-click="chooseMon($event)">
                7月
            </div>
            <div class="item" id="m6" ng-click="chooseMon($event)">
                6月
            </div>
            <div class="item" id="m5" ng-click="chooseMon($event)">
                5月
            </div>
            <div class="item" id="m4" ng-click="chooseMon($event)">
                4月
            </div>
            <div class="item" id="m3" ng-click="chooseMon($event)">
                3月
            </div>
            <div class="item" id="m2" ng-click="chooseMon($event)">
                2月
            </div>
            <div class="item" id="m1" ng-click="chooseMon($event)">
                1月
            </div>
        </div>
        <div class="col-xs-10">
            <div class="filter">
                <div class="col-xs-2 intro">
                    选择筛选：
                </div>
                <select class="col-xs-2 daySelect" ng-model="filDay">
                    <option value="-1">全部</option>
                    <option ng-repeat="d in day" ng-bind="d+'日'" value="{{d}}"></option>
                </select>
                <select class="col-xs-2 typeSelect" ng-model="filType">
                    <option value="-1">
                        全部
                    </option>
                    <option value="0">
                        未完成
                    </option>
                    <option value="1">
                        已完成
                    </option>
                </select>
                <div class="col-xs-2">
                    <input type="text" placeholder="请输入小区名" ng-model="filName" class="form-control comInput" >
                </div>
                <button class="col-xs-1 btn btn-success confirm" ng-click="filterData()">确定</button>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>时间</th>
                        <th>地址</th>
                        <th>联系人</th>
                        <th>废品种类</th>
                        <th>状态</th>
                        <th>价格</th>
                        <th>回收员</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="x in index" class="{{allOrders[page*18+x].orderColor}}">
                        <td ng-bind="allOrders[page*18+x].time"></td>
                        <td ng-bind="allOrders[page*18+x].address"></td>
                        <td ng-bind="allOrders[page*18+x].clientName"></td>
                        <td ng-bind="allOrders[page*18+x].scrap"></td>
                        <td ng-bind="allOrders[page*18+x].orderType" style="color: red"></td>
                        <td ng-bind="allOrders[page*18+x].price"></td>
                        <td ng-bind="allOrders[page*18+x].colName"></td>
                    </tr>
                </tbody>
            </table>
            <div class="pagination">
                <label class="page" ng-repeat="temp in pages" ng-bind="temp" ng-click="gotoPage(temp)" id="page{{temp}}"></label>
            </div>
        </div>
    </div>
</div>
</body>
</html>
