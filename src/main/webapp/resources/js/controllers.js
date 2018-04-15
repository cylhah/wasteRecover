var clientCtrl = angular.module('clientCtrl',[]);

clientCtrl.controller('clientViewCtrl',function ($scope) {
    $scope.gotoMyAddress = function () {
        window.location.href = "#!/myAddress";
    };
    $scope.gotoMyOrders = function () {
        window.location.href = "#!/myOrders";
    };
    $scope.gotoOrderManage = function () {
        window.location.href = "#!/orderManage";
    }
});

clientCtrl.controller('myOrdersCtrl',function ($scope,$http,clientFty) {
    // clientFty.getAddress();
    $scope.address = '0';
    $scope.submitOrder = function () {
        var data = {"address":$scope.address,"weight":$scope.weight,"type":$scope.type,"time":GetDateStr(parseInt($scope.date))+" "+$scope.time};
        // alert(data.address+data.weight+data.type+data.time);
        clientFty.submitOrder(data);
    };
    $scope.myAddress = clientFty.addressInfo;
    $scope.myOrders = clientFty.orderInfo;
    $scope.weight = "<0.5kg";
    $scope.date = '0';
    if($scope.myAddress.length>0){
        $scope.haveAddress = true;
    }
    else $scope.haveAddress = false;
    $scope.time1 = [];
    getTime1();
    $scope.time = $scope.time1[0];
    $scope.time2 = ["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30"];

    function getTime1() {
        var date = new Date();
        var nowTime;
        if(date.getMinutes()<10)
        {
            nowTime = date.getHours()+":"+"0"+date.getMinutes();
        }
        else
        {
            nowTime = date.getHours()+":"+date.getMinutes();
        }
        $scope.time1.push(nowTime);
        if(date.getMinutes()<=30)
        {
            var tHour = date.getHours();
            var tMinute = ["00","30"];
            $scope.time1.push(tHour+":"+"30");
            tHour = tHour+1;
            var count = 0;
            while (tHour<21)
            {
                var tTime = tHour+":"+tMinute[count];
                $scope.time1.push(tTime);
                count = Math.abs(count-1);
                if(count==0)
                {
                    tHour = tHour+1;
                }
            }
        }
        else
        {
            var tHour = date.getHours();
            var tMinute = ["00","30"];
            tHour = tHour+1;
            var count = 0;
            while (tHour<21)
            {
                var tTime = tHour+":"+tMinute[count];
                $scope.time1.push(tTime);
                count = Math.abs(count-1);
                if(count==0)
                {
                    tHour = tHour+1;
                }
            }
        }
    }
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth()+1)<10?"0"+(dd.getMonth()+1):(dd.getMonth()+1);//获取当前月份的日期，不足10补0
        var d = dd.getDate()<10?"0"+dd.getDate():dd.getDate();//获取当前几号，不足10补0
        return y+"-"+m+"-"+d;
    }
});

clientCtrl.controller('myAddressCtrl',function ($scope,$http,clientFty) {
    $scope.edit = true;
    $scope.search = true;
    $scope.myAddress = clientFty.addressInfo;
    $scope.reviseAddress = function (index) {
        $scope.edit = false;
        $scope.editType = "revise";
        $scope.name = clientFty.addressInfo[index].name;
        $scope.phoneNumber = clientFty.addressInfo[index].phoneNumber;
        $scope.address = clientFty.addressInfo[index].address;
        $scope.specificAddress = clientFty.addressInfo[index].specificAddress;
        $scope.index = index;
    };
    $scope.searchAddress = function () {
      $scope.edit = true;
      $scope.search = false;
    };
    $scope.add = function () {
        $scope.wipeData();
        $scope.editType = "add";
        $scope.edit = !$scope.edit;
        $scope.search = true;
        $scope.address = $("#location").text();
    };
    $scope.confirmAddress = function () {
      $scope.search = true;
      $scope.edit = false;
    };

    baiduSearch();
    locationInf();
    $scope.getLocationInf = function () {
        locationInf();
    };
    $scope.wipeData = function () {
        $scope.name = null;
        $scope.phoneNumber = null;
        $scope.specificAddress = null;
    };

    $scope.submitAddress = function () {
        var data = {"name":$scope.name,"phoneNumber":$scope.phoneNumber,"address":$scope.address,"specificAddress":$scope.specificAddress};
        if($scope.editType=="add"){
            clientFty.addAddress(data);
            $scope.edit =true;
            $scope.wipeData();
        }
        else if($scope.editType=="revise"){
            clientFty.reviseAddress($scope.index,data);
            $scope.edit =true;
            $scope.wipeData();
        }
    };

    function baiduSearch() {
        function G(id) {
            return document.getElementById(id);
        }

        var map = new BMap.Map("l-map");
        map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。

        var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
            {"input" : "suggestId"
                ,"location" : map
            });

        ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
            var str = "";
            var _value = e.fromitem.value;
            var value = "";
            if (e.fromitem.index > -1) {
                value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            }
            str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

            value = "";
            if (e.toitem.index > -1) {
                _value = e.toitem.value;
                value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            }
            str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
            G("searchResultPanel").innerHTML = str;
        });

        var myValue;
        ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            $scope.address = myValue;
            G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

            setPlace();
        });

        function setPlace(){
            map.clearOverlays();    //清除地图上所有覆盖物
            function myFun(){
                var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                map.centerAndZoom(pp, 18);
                map.addOverlay(new BMap.Marker(pp));    //添加标注
            }
            var local = new BMap.LocalSearch(map, { //智能搜索
                onSearchComplete: myFun
            });
            local.search(myValue);
        }
    }

    function locationInf() {
        $("#location").html("正在获取位置......");
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                //以指定的经度与纬度创建一个坐标点
                var pt = new BMap.Point(r.point.lng,r.point.lat);
                //创建一个地理位置解析器
                var geoc = new BMap.Geocoder();
                geoc.getLocation(pt, function(rs){//解析格式：城市，区县，街道
                    var addComp = rs.addressComponents;
                    $("#location").html(addComp.city + ", " + addComp.district + ", " + addComp.street);
                    $("#address").html(addComp.city + ", " + addComp.district + ", " + addComp.street);
                });
            }
            else {
                $("#location").html("定位失败");
            }
        },{enableHighAccuracy: true});
    }
});

clientCtrl.controller('orderManageCtrl',function ($scope) {

});
// ----------------------------------------------------------------------------
// ----------------------------------------------------------------------------
var loginCtrl = angular.module('loginCtrl',[]);

loginCtrl.controller('loginCtrl',function ($scope,$http) {
    $scope.loginType = "client";
    $scope.login = function () {
        var data = {"loginType":$scope.loginType,"account":$scope.account,"password":$scope.password};
        $http({
            method:"post",
            url:"login",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data:$.param(data)
        }).success(function (result) {
            if(result=="false")
            {
                $("#message").html('<span class="glyphicon glyphicon-remove-sign""></span>'+"用户名或密码错误");
            }
            else
            {
                $("#message").html("");
                if($scope.loginType=="client"){
                    window.location.href = "client.jsp";
                }
                else if($scope.loginType=="server"){
                    window.location.href = "server.jsp";
                }
                else if($scope.loginType=="corporation"){
                    window.location.href = "corporation.jsp";
                }
            }
        });
    }
});
// ----------------------------------------------------------------------------
//商贩部分
// ----------------------------------------------------------------------------

var allListCtrl = angular.module('allListCtrl',[]);

allListCtrl.controller('listCtrl',function ($scope) {
    $scope.typeList=["塑料","废铁","废纸板","废铜片","塑料纸箱","废铁片","废铜板"];
    $scope.chooseType="";
    $scope.minCost=0;
    $scope.maxCost=999;
    $scope.waitList=[
        {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"待回收",color:"alert-success"},
        {address:"漫威街道",time:"1:30~2:30",weight:"3kg",type:"待回收",color:"alert-success"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待回收",color:"alert-success"}
    ];
    $scope.receivedList=[
        {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"已回收",color:"text-success"},
        {address:"漫威街道",time:"1:30~2:30",weight:"3kg",type:"已回收",color:"text-success"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"已回收",color:"text-success"}
    ]
})

// allListCtrl.controller('historyCtrl',function ($scope) {
//
//

//
// })

var orderMsgCtrl = angular.module('orderMsgCtrl',[]);

orderMsgCtrl.controller('orderMsgOne',function ($scope) {
    // $scope.detailed = function ($scope) {
    // 从内置对象中取得详细数据
    // }
    // $scope.metal= "0";
    // $scope.plastic= "0";
    // $scope.cardboard= "0";
    // $scope.battery="0";
    $scope.orderList = {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"待接单",color:"text-danger",userName:"陈某某",telephone:"1234567",receiverName:"江某某"}

    $scope.receiveOrder=function ($scope) {
        window.location.href='receiveOrder.html';
    }
})

orderMsgCtrl.controller('checkOrderMsg',function ($scope) {
    //
    $scope.orderList = {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"待接单",color:"text-danger",userName:"陈某某",telephone:"1234567"}

    $scope.checkOrder=function ($scope) {
        window.location.href='checkOrderMsgSuc.html';
    }
})

orderMsgCtrl.controller('ready',function ($scope) {
    var pointList =[{lng:"120.11937542",lat:"30.25924446",id:"1",type:"1"},{lng:"120.04937542",lat:"30.20924446",id:"2",type:"1"},{lng:"120.05937542",lat:"30.30924446",id:"3",type:"0"}];
    $scope.orderList =[
        {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"1:30~2:30",weight:"3kg",type:"已接单",color:"text-info",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"已接单",color:"text-info",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待取消",color:"text-secondary",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待取消",color:"text-secondary",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"}
    ];
    $scope.receivedList=[{address:"漫威街道",time:"1:30~2:30",weight:"3kg",type:"已接单",color:"text-info",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"已接单",color:"text-info",name:"陈某某",telephone:"1234567"}
    ];
    $scope.waitList=[
        {address:"漫威街道",time:"12:30~1:30",weight:"5kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待接单",color:"text-danger",name:"陈某某",telephone:"1234567"}
    ]
    $scope.cancelList=[
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待取消",color:"text-secondary",name:"陈某某",telephone:"1234567"},
        {address:"漫威街道",time:"2:30~4:30",weight:"7kg",type:"待取消",color:"text-secondary",name:"陈某某",telephone:"1234567"}
    ]
    $scope.listType=$scope.orderList;
    $scope.changeTypeWait = function () {
        $scope.listType = $scope.waitList;
    }
    $scope.changeTypeReceived = function () {
        $scope.listType = $scope.receivedList;
    }
    $scope.changeTypeOrder = function () {
        $scope.listType = $scope.orderList;
    }
    $scope.changeTypeCancel = function () {
        $scope.listType = $scope.cancelList;
    }
    $scope.unReceive=0;
    $scope.unCheck=0;
    $scope.allOrder=0;
    $scope.refresh=function () {
        location.reload();
    }
    // $http({
    //     method: 'POST',
    //     url: '/servlet'
    // }).then(function successCallback(response) {
    //     // 若返回null，跳转到绑定页面
    //     若返回了回收员的信息则继续执行ready（）
    // }, function errorCallback(response) {
    //     // 请求失败执行代码
    // });
    $(document).ready(function () {

        var map = new BMap.Map("allmap");
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        map.centerAndZoom("杭州市江干区", 10);
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
                    offset: new BMap.Size(10, 25), // 指定定位位置
                    imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移
                });
                var mk = new BMap.Marker(r.point,{icon:myIcon});
                map.addOverlay(mk);
                map.panTo(r.point);
            }
            else {
                alert('failed'+this.getStatus());
            }
        },{enableHighAccuracy: true})
        //初始化回收员点
        //----------------------
        //上传回收员当前位置
        // $http({
        //     method: 'POST',
        //     url: '/servlet'
        // }).then(function successCallback(response) {
        //     // 请求成功执行代码
        // }, function errorCallback(response) {
        //     // 请求失败执行代码
        // });
        //----------------------
        //初始化用户点
        //----------------------
        var list = [];

        for(var i=0;i<pointList.length;i++){
            if(pointList[i].type == "1"){
                list[i]= new BMap.Marker(new BMap.Point(parseFloat(pointList[i].lng),parseFloat(pointList[i].lat)));
                list[i].setTitle(pointList[i].id);
                list[i].addEventListener("click",getMsg);
                map.addOverlay(list[i]);
            }
            else{
                var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
                    offset: new BMap.Size(10, 25), // 指定定位位置
                    imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移
                });
                list[i]= new BMap.Marker(new BMap.Point(parseFloat(pointList[i].lng),parseFloat(pointList[i].lat)),{icon:myIcon});
                list[i].setTitle(pointList[i].id);
                list[i].addEventListener("click",checkMsg);
                map.addOverlay(list[i]);
            }
        }
    })
    for(var j=0;j<pointList.length;j++){
        if(pointList[j].type == "1"){
           $scope.unReceive++;
        }
        else{
            $scope.unCheck++;
        }
        $scope.allOrder++;
    }
})


function getMsg() {
    // $http({
    //     method: 'POST',
    //     url: '/servlet'
    // }).then(function successCallback(response) {
    //     // 请求成功执行代码从数据库取得数据之后放进内置对象之后转向control
        window.location.href="#!/orderMsg";
    // }, function errorCallback(response) {
    //     // 请求失败执行代码
    // });
}

// orderMsgCtrl.controller('orderMsgList',function ($scope) {
//
// })

function checkMsg() {
    window.location.href="#!/checkOrderMsg";
}

var checkScrapCtrl = angular.module('checkScrapCtrl',[]);

checkScrapCtrl.controller('checkScrap',function ($scope){
    $scope.list = [];
    $scope.orderValue = 0;
    $scope.btnList=[{scrap:"塑料",scrapValue:2.2},{scrap:"废铁",scrapValue:2.1},{scrap:"废铜",scrapValue:2.3},{scrap:"塑料纸箱",scrapValue:2.0},{scrap:"废铁片",scrapValue:1.2},{scrap:"废铜板",scrapValue:3.2},{scrap:"铜板",scrapValue:2.5},{scrap:"废铁板",scrapValue:4.2}];
    $scope.add = function () {
        var type;
        var index;
        var oneValue;
        var weight =parseFloat($scope.scrapWeight);
        for(index=0;index<$scope.btnList.length;index++){
            if($scope.btnList[index].scrap==$scope.scrapName){
                oneValue=$scope.btnList[index].scrapValue;
            }
        }
        if(weight<200.0){
            type = "";
        }
        else if(weight<400.0){
            type = "list-group-item-warning";
        }
        else{
            type = "list-group-item-danger";
        }
        var allValue = weight*oneValue/1000.0;
        allValue = allValue.toFixed(2);
        $scope.list.push({name:$scope.scrapName,weight:$scope.scrapWeight,type:type,value:allValue});
        $scope.orderValue = $scope.orderValue + parseFloat(allValue);//????
    }
    $scope.reduce=function (index) {
        if($scope.list.length==1){
            $scope.orderValue = 0;
            $scope.list.splice(index,1);
        }
        else{
            $scope.orderValue = $scope.orderValue - $scope.list[index].value;
            $scope.list.splice(index,1);
        }
    }
    $scope.msg = function (index) {
        $scope.scrapName=$scope.btnList[index].scrap;
    }
    $scope.placeOrder = function () {
        // $http({
        //     method: 'POST',
        //     url: '/servlet'
        // }).then(function successCallback(response) {
        //     // 提交订单成功后弹至成功页面（只有一个成功图标以及返回主页）
        window.location.href="orderMsgSuc.html";
        // }, function errorCallback(response) {
        //     // 请求失败执行代码
        // });
    }

})