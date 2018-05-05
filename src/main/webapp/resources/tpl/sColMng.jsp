<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        @keyframes slideInRight {
            from     {
                opacity: 0;
                transform:translateY(100%);
            }
            to         {
                opacity: 1;
                transform: translateY(0);
            }
        }
        .colContainer{
            background: rgb(243,243,243);
            width: 100%;
        }
        .introduction{
            text-align: center;
            font-size: 25px;
            font-weight: bold;
            height: 140px;
        }
        .introduction p{
            position: relative;
            top: 30%;
        }
        .item{
            position: relative;
            left: 10%;
            height: 300px;
            border-radius: 8px;
            text-align: center;
            background: white;
            margin: 15px;
            cursor: pointer;
            opacity: 0;
        }
        .myIcon{
            position: absolute;
            top:10%;
            left: 50%;
            margin-left: -50px;
            padding-top: 20px;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            text-align: center;
            border: 3px solid rgb(1,207,207);
            font-size: 50px;
            color: rgb(1,207,207);
        }
        .intro{
            position: relative;
            top: 55%;
            padding-top: 20px;
            width: 100%;
            font-size: 20px;
            color: rgb(169,169,169);
            border-top: 2px solid rgb(169,169,169);
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
        .delete{
            animation: slideInRight 1s;
            animation-delay: 0s;
            animation-fill-mode: forwards;
        }
        .query{
            animation: slideInRight 1s;
            animation-delay: 0.5s;
            animation-fill-mode: forwards;
        }
        .add{
            animation: slideInRight 1s;
            animation-delay: 1s;
            animation-fill-mode: forwards;
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
        tr{
            cursor: pointer;
        }
        .colImage{
            width: 100%;
            height: 100%;
        }
        .info{
            padding: 0;
        }
        .myBtn{
            font-size: 20px;
            margin: 10px 0 10px 0;
            padding: 5px 100px 5px 100px;
            background: rgb(74, 76, 91);
            color:white;
            border-radius: 5px;
        }
    </style>
    <title>回收员管理</title>
</head>
<body>
<div class="container colContainer">
    <div ng-hide="menu">
        <div class="col-md-12 introduction">
            <p>开始回收者管理</p>
            <%--<p>Start your management</p>--%>
        </div>
        <div class="col-xs-12 menu">
            <div class="col-xs-3 item delete">
                <div class="myIcon">
                    <span class="glyphicon glyphicon-minus"></span>
                </div>
                <div class="intro">
                    删除回收者信息
                </div>
            </div>
            <div class="col-xs-3 item query" ng-click="query()">
                <div class="myIcon">
                    <span class="glyphicon glyphicon-user"></span>
                </div>
                <div class="intro">
                    开始查询/修改回收者数据
                </div>
            </div>
            <div class="col-xs-3 item add">
                <div class="myIcon">
                    <span class="glyphicon glyphicon-plus"></span>
                </div>
                <div class="intro">
                    添加回收者信息
                </div>
            </div>
        </div>
    </div>

    <div class="col-xs-12" ng-hide="colInfo">
        <div class="col-xs-5">
            <div class="col-xs-7 info">
                <div class="input-group">
                    <span class="input-group-addon" id="name">姓名</span>
                    <input type="text" class="form-control" placeholder="请输入姓名" aria-describedby="name" ng-model="oneCol.name" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="gender">性别</span>
                    <input type="text" class="form-control" placeholder="请输入性别" aria-describedby="gender" ng-model="oneCol.gender" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="cId">员工号</span>
                    <input type="text" class="form-control" placeholder="请输入员工号" aria-describedby="cId" ng-model="oneCol.cId" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="entryTime">入职时间</span>
                    <input type="text" class="form-control" placeholder="请输入员工号" aria-describedby="entryTime" ng-model="oneCol.entryTime" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="dealNum">成交量</span>
                    <input type="text" class="form-control" placeholder="请输入员工号" aria-describedby="dealNum" ng-model="oneCol.dealNum" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="community">负责小区</span>
                    <input type="text" class="form-control" placeholder="请输入员工号" aria-describedby="community" ng-model="oneCol.community" ng-disabled="noEdit">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="idNumber">身份证号</span>
                    <input type="text" class="form-control" placeholder="请输入身份证号" aria-describedby="idNumber" ng-model="oneCol.idNumber" ng-disabled="noEdit">
                </div>
                <button class="myBtn" ng-click="noEdit=false">修改信息</button>
                <button class="myBtn" ng-click="saveInfo()" style="background: #5cb85c">保存信息</button>
            </div>
            <div class="col-xs-5" >
                <div class="colImage" style="background: url('../images/col2.png') no-repeat">
                </div>
            </div>
        </div>
        <div class="col-xs-7">
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
                <tr ng-repeat="x in index" class="{{oneCol.orders[orderPage*18+x].orderColor}}">
                    <td ng-bind="oneCol.orders[orderPage*18+x].time"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].address"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].clientName"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].scrap"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].orderType"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].price"></td>
                    <td ng-bind="oneCol.orders[orderPage*18+x].colName"></td>
                </tr>
                </tbody>
            </table>
            <div class="pagination">
                <label class="page" ng-repeat="temp in orderPages" ng-bind="temp" ng-click="gotoOrderPage(temp)" id="orderPage{{temp}}"></label>
            </div>
        </div>
    </div>

    <div class="col-md-12" ng-hide="colTable">
        <div class="col-xs-12 filter">
            <div class="col-xs-2 state">
                选择筛选
            </div>
            <select class="col-xs-2 filType" ng-model="filType">
                <option value="name">姓名</option>
                <option value="cId">员工号</option>
                <option value="idNum">身份证号</option>
            </select>
            <div class="col-xs-2">
                <input type="text" placeholder="请输入筛选信息" ng-model="filData" class="form-control comInput" >
            </div>
            <button class="col-xs-1 btn btn-success" ng-click="filterData()">确定</button>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>员工号</th>
                <th>身份证号</th>
                <th>入职时间</th>
                <th>成交量</th>
                <th>负责小区</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="x in index" class="{{collectorInfo[page*18+x].colColor}}" ng-click="getColInfo(page*18+x)">
                <td ng-bind="collectorInfo[page*18+x].name"></td>
                <td ng-bind="collectorInfo[page*18+x].gender"></td>
                <td ng-bind="collectorInfo[page*18+x].cId"></td>
                <td ng-bind="collectorInfo[page*18+x].idNumber"></td>
                <td ng-bind="collectorInfo[page*18+x].entryTime"></td>
                <td ng-bind="collectorInfo[page*18+x].dealNum"></td>
                <td ng-bind="collectorInfo[page*18+x].community"></td>
            </tr>
            </tbody>
        </table>
        <div class="pagination">
            <label class="page" ng-repeat="temp in pages" ng-bind="temp" ng-click="gotoPage(temp)" id="page{{temp}}"></label>
        </div>
    </div>

</div>

</body>
</html>
