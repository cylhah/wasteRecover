<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/17
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .searchDiv{
            text-align:center;
            width: 100%;
            height: 100%;
            background: rgba(242,242,242,0.8);
            padding:0
        }
        .dropdown-menu{
            height: 300px;
        }
        .scrapInfo{
            padding: 0;
        }
        .scrapImage{
            height: 100px;
        }
        .scrapSelect{
            padding: 0;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container searchDiv">
    <div class="col-md-12 scrapSelect">
        <select class="selectpicker show-tick form-control"  id="scrapSelect" data-width="98%" data-first-option="false" title='请输入废品名' required data-live-search="true" ng-model="scrapName">
            <option value="1">铁片</option>
            <option value="2">铁板</option>
            <option value="3">纸板</option>
            <option value="4">纸箱</option>
            <option value="5">铜片</option>
            <option value="6">铜线</option>
            <option value="7">铜网</option>
            <option value="8">塑料</option>
            <option value="9">塑料瓶</option>
            <option value="10">塑料箱</option>
            <option value="11">塑料盖</option>
            <option value="12">塑料杯</option>
        </select>
    </div>
    <div class="col-xs-12">
        <div class="col-xs-9 scrapInfo">
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
        </div>
        <div class="col-xs-3 scrapImage" style="background: url({{scrapImageUrl}}) no-repeat">
        </div>
    </div>
</div>

<script>
    $('#scrapSelect').selectpicker('refresh');
    $('#scrapSelect').selectpicker('render');
</script>
</body>
</html>
