<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/14
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
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
        .sel{
            background: rgb(217, 217, 217);
            color: white;
            cursor: pointer;
            width: 60px;
            height: 60px;
            padding-top: 10px;
            font-size: 30px;
            text-align: center;
            margin: 5px;
        }
        .sel:hover{
            color: rgb(1,207,207);
        }
        .choice{
            position: fixed;
            left: 20px;
            top: 30%;
        }
        .scrapCon{
            width: 100%;
            padding-left: 100px;
        }
        tr{
            cursor: pointer;
        }
        .filter{
            margin: 10px;
        }
        .filType{
            border-radius: 4px;
            height: 32px;
        }
        .state{
            font-weight: bold;
            text-align: center;
            padding-top: 5px;
        }
        .myBtn{
            font-size: 20px;
            margin: 10px 0 10px 0;
            padding: 5px 100px 5px 100px;
            background: rgb(74, 76, 91);
            color:white;
            border-radius: 5px;
        }
        .colImage{
            width: 100%;
            height: 100%;
        }
    </style>
    <title>废品管理</title>
</head>
<body>
<div class="choice">
    <div class="sel">
        <span class="glyphicon glyphicon-search" ng-click="search()"></span>
    </div>
    <div class="sel">
        <span class="glyphicon glyphicon-plus" ng-click="add()"></span>
    </div>
</div>
<div class="container scrapCon" >
    <div class="col-xs-12" ng-hide="scrapInfo">
        <div class="col-xs-7 info">
            <div class="input-group">
                <span class="input-group-addon" id="sId">废品ID</span>
                <input type="text" class="form-control" placeholder="请输入废品ID" aria-describedby="sId" ng-model="oneScrap.sId" ng-disabled="noEdit">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="typeName">种类名称</span>
                <input type="text" class="form-control" placeholder="请输入种类名称" aria-describedby="typeName" ng-model="oneScrap.typeName" ng-disabled="noEdit">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="name">废品名称</span>
                <input type="text" class="form-control" placeholder="请输入废品名称" aria-describedby="cId" ng-model="oneScrap.name" ng-disabled="noEdit">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="unitPrice">废品单价</span>
                <input type="text" class="form-control" placeholder="请输入废品单价" aria-describedby="unitPrice" ng-model="oneScrap.unitPrice" ng-disabled="noEdit">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="monthVolume">本月成交额</span>
                <input type="text" class="form-control" placeholder="请输入废品单价" aria-describedby="monthVolume" ng-model="oneScrap.monthVolume" ng-disabled="true">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="totalVolume">总成交额</span>
                <input type="text" class="form-control" placeholder="请输入废品单价" aria-describedby="totalVolume" ng-model="oneScrap.totalVolume" ng-disabled="true">
            </div>
            <button class="myBtn" ng-click="noEdit=false">修改信息</button>
            <button class="myBtn" ng-click="saveInfo()" style="background: #5cb85c">保存信息</button>
        </div>
        <div class="col-xs-5" >
            <div class="colImage" style="background: url('../images/scrap1.png') no-repeat">
            </div>
        </div>
    </div>
    <div class="col-md-12" ng-hide="scrapTable">
        <div class="col-xs-12 filter">
            <div class="col-xs-2 state">
                选择筛选
            </div>
            <select class="col-xs-2 filType" ng-model="filType">
                <option value="sId">废品ID</option>
                <option value="typeName">废品种类</option>
                <option value="name">废品名称</option>
                <option value="unitPrice">废品单价</option>
            </select>
            <div class="col-xs-2">
                <input type="text" placeholder="请输入筛选信息" ng-model="filData" class="form-control comInput" >
            </div>
            <button class="col-xs-1 btn btn-success" ng-click="filterData()">确定</button>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>废品ID</th>
                <th>废品种类</th>
                <th>废品名称</th>
                <th>废品单价</th>
                <th>本月成交额</th>
                <th>总成交额</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="x in index" class="{{scraps[page*18+x].colColor}}" ng-click="getScrapInfo(page*18+x)">
                <td ng-bind="scraps[page*18+x].sId"></td>
                <td ng-bind="scraps[page*18+x].typeName"></td>
                <td ng-bind="scraps[page*18+x].name"></td>
                <td ng-bind="scraps[page*18+x].unitPrice"></td>
                <td ng-bind="scraps[page*18+x].monthVolume"></td>
                <td ng-bind="scraps[page*18+x].totalVolume"></td>
            </tr>
            </tbody>
        </table>
        <div class="pagination">
            <label class="page" ng-repeat="temp in scrapPages" ng-bind="temp" ng-click="gotoScrapPage(temp)" id="scrapPage{{temp}}"></label>
        </div>
    </div>
</div>
</body>
</html>
