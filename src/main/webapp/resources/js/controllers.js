
var loginCtrl = angular.module('loginCtrl',[]);

loginCtrl.controller('loginFormCtrl',function ($scope,$http) {
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

var map;

var clientCtrl = angular.module('clientCtrl',[]);

clientCtrl.controller('clientViewCtrl',function ($scope,clientFty) {
    $(document).ready(function(){
        map = new BMap.Map("myMap");
        map.enableScrollWheelZoom(true);
        map.centerAndZoom("北京",10);
        map.centerAndZoom(clientFty.addressInfo[0].address,18);
        var marker = new BMap.Marker(new BMap.Point(clientFty.addressInfo[0].point.lng, clientFty.addressInfo[0].point.lat),{icon:new BMap.Icon("../resources/images/myicon_order.jpg", new BMap.Size(50,42))});
        marker.addEventListener('click',startOrder);
        for (var i=0;i<clientFty.ordersAroundInfo.length;i++){
            map.addOverlay(new BMap.Marker(new BMap.Point(clientFty.ordersAroundInfo[i].lng, clientFty.ordersAroundInfo[i].lat),{icon:new BMap.Icon("..//images/neiborIcon.png", new BMap.Size(30,24))}));
        }
        map.addOverlay(marker);
    });
    $scope.gotoMyOrders = function () {
        window.location.href = "#!/myOrders";
    };
    $scope.gotoMyAddress = function () {
        window.location.href = "#!/myAddress";
    };
    $scope.gotoOrderManage = function () {
        window.location.href = "#!/orderManage";
    };
    $scope.gotoSearchScrap = function () {
        window.location.href = "#!/searchScrap";
    };
    function startOrder() {
        window.location.href = "#!/myOrders";
    }
});

clientCtrl.controller('orderManageCtrl',function ($scope,clientFty) {
    $scope.scoreTable = true;
    $scope.pages = [];
    $scope.orders = clientFty.orderInfo;
    $scope.ordersNum = $scope.orders.length;
    $scope.len = parseInt(($scope.ordersNum+4)/5);  //每页放5个订单时的订单页数
    for(var i=0;i<$scope.len;i++){
        $scope.pages[i] = i;
    }
    $scope.count = [0,1,2,3,4];
    $(document).ready(function(){
        var swiperV = new Swiper('.swiperV',{
            direction: 'vertical',
            slidesPerView: 3
        });
        var swiperOrders = new Swiper('.swiperOrders', {
            pagination: {
                el: '.swiper-pagination',
                type: 'progressbar'
            }
        });
    });
    var swiperScore = new Swiper('.swiperScore', {
        direction: 'vertical',
        slidesPerView: 3,
        loop:true
    });
    $scope.closeScore = function () {
        $scope.scoreTable = true;
    };
    $scope.scoreCol = function (index) {
        $scope.scoreTable = false;
        $scope.scoreIndex = index;
    };
    $scope.submitScore = function () {
        $scope.scoreTable = true;
        $scope.orders[$scope.scoreIndex].scoreType = 1;
        var score = parseInt($(".score.swiper-slide-active").text().substring(0,1));
        var data1 = {"orderId":$scope[$scope.scoreIndex].orderId,"colId":$scope[$scope.scoreIndex].server.id,"score":score};
        // clientFty
    }
});

clientCtrl.controller('myOrdersCtrl',function ($scope,clientFty) {
    $scope.date = "今天";
    var swiper1,swiper2,swiper3;
    var slides2 = {"s2_1":[],"s2_2":[]};
    var slides3 = {"s3_1":[],"s3_2":[]};
    function getTime() {
        var date = new Date();
        var nowHour = date.getHours();
        $scope.nowHour = nowHour+"点";
        var nowMin = date.getMinutes();
        for(var i=7;i<=21;i++){
            var temp = '<div class="swiper-slide">'+i+"点"+'</div>';
            slides2.s2_2.push(temp);
        }
        for(var i=0;i<=5;i++){
            var temp;
            if(i==0){
                temp =  '<div class="swiper-slide">'+'0'+i+"分"+'</div>';
            }
            else {
                temp = '<div class="swiper-slide">'+i+'0'+"分"+'</div>';
            }
            slides3.s3_2.push(temp);
        }
        if(nowMin>=50){
            for(var i=nowHour+1;i<=21;i++){
                var temp = '<div class="swiper-slide">'+i+"点"+'</div>';
                slides2.s2_1.push(temp);
            }
            slides3.s3_1 = slides3.s3_2;
        }
        else{
            for(var i=nowHour;i<=21;i++){
                var temp = '<div class="swiper-slide">'+i+"点"+'</div>';
                slides2.s2_1.push(temp);
            }
            var tempMin = nowMin-nowMin%10+10;
            for(var i=tempMin;i<60;i+=10){
                var temp = '<div class="swiper-slide">'+i+"分"+'</div>';
                slides3.s3_1.push(temp);
            }
        }
    }
    getTime();
    swiper3 = new Swiper('.swiper3', {
        direction: 'vertical',
        slidesPerView: 3,
        loop:true
    });
    swiper2 = new Swiper('.swiper2', {
        direction: 'vertical',
        slidesPerView: 3,
        loop:true,
        on:{
            slideChange:function () {
                if($scope.date=="今天"&&$(this.slides[this.activeIndex]).text()==$scope.nowHour){
                    swiper3.removeAllSlides();
                    swiper3.appendSlide(slides3.s3_1);
                    swiper3.slideToLoop(0);
                }
                else {
                    swiper3.removeAllSlides();
                    swiper3.appendSlide(slides3.s3_2);
                    swiper3.slideToLoop(0);
                }
            }
        }
    });
    swiper1 = new Swiper('.swiper1', {
        direction: 'vertical',
        slidesPerView: 3,
        loop:true,
        on:{
            slideChange:function () {
                if($(this.slides[this.activeIndex]).text()=="今天"){
                    swiper2.removeAllSlides();
                    swiper2.appendSlide(slides2.s2_1);
                    swiper2.slideToLoop(0);
                    $scope.date = "今天";
                }
                else{
                    swiper2.removeAllSlides();
                    swiper2.appendSlide(slides2.s2_2);
                    swiper2.slideToLoop(0);
                    $scope.date = "明天";
                }
            }
        }
    });
    $scope.addressIndex = "0";
    $scope.time = "请选择时间";
    $scope.myAddress = clientFty.addressInfo;
    $scope.haveAddress = $scope.myAddress.length>0;
    if(!$scope.haveAddress){
        $("#address").css({"display":"none"});
    }
    $scope.timeTable = true;
    $scope.weight = "<0.5kg";
    $scope.animationCount = 0;
    $scope.$watch('addressIndex',function () {
        map.clearOverlays();
        $scope.aroundNum = clientFty.ordersAroundInfo.length;
        for (var i=0;i<$scope.aroundNum;i++){
            map.addOverlay(new BMap.Marker(new BMap.Point(clientFty.ordersAroundInfo[i].lng, clientFty.ordersAroundInfo[i].lat),{icon:new BMap.Icon("../resources/images/neiborIcon.png", new BMap.Size(30,24))}));
        }
        var temp = $scope.myAddress[parseInt($scope.addressIndex)];
        map.centerAndZoom(temp.address,18);
        map.addOverlay(new BMap.Marker(new BMap.Point(temp.point.lng, temp.point.lat),{icon:new BMap.Icon("../resources/images/myicon.png", new BMap.Size(80,67))}));
    });
    $scope.submitOrder = function () {
        var data = $scope.myAddress[parseInt($scope.addressIndex)];
        data.weight = {"约重":$scope.weight};
        getDateStr();
        data.time = $scope.realTime;
        data.type = "待接单";
        if($scope.time == "请选择时间"){
            $(".message").text("请填写时间");
            if($scope.animationCount==0){
                $(".message").css({"animation":"msgFade 3s"});
                $scope.animationCount = 1;
            }
            else {
                $(".message").css({"animation":"msgFade1 3s"});
                $scope.animationCount = 0;
            }
        }
        else{
            clientFty.submitOrder(data);
            window.location.href = "#!/orderManage";
        }
    };

    $scope.closeTime = function () {
        $scope.timeTable = true;
    };
    $scope.confirmTime = function () {
        $scope.time = $(".swiper-slide-active").text();
        $scope.timeTable = true;
    };
    $scope.openTimeTable = function () {
        $scope.timeTable = !$scope.timeTable;
    };
    function getDateStr() {
        var dd = new Date();
        var count;
        if($scope.time.substring(0,2)=="今天"){
            count = 0;
        }
        else if($scope.time.substring(0,2)=="明天"){
            count = 1;
        }
        else {
            count = 2;       //后天
        }
        dd.setDate(dd.getDate()+count);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth()+1)<10?"0"+(dd.getMonth()+1):(dd.getMonth()+1);//获取当前月份的日期，不足10补0
        var d = dd.getDate()<10?"0"+dd.getDate():dd.getDate();//获取当前几号，不足10补0
        $scope.realTime = y+"-"+m+"-"+d;
        if($scope.time.length==7){
            $scope.realTime = $scope.realTime + ' '+$scope.time.substring(2,3)+":"+$scope.time.substring(4,6);
        }
        else {
            $scope.realTime = $scope.realTime + ' '+$scope.time.substring(2,4)+":"+$scope.time.substring(5,7);
        }
    }
});
clientCtrl.controller('searchScrapCtrl',function ($scope) {
    $scope.scrapName = "2";
    $scope.noEdit = true;
    $scope.oneScrap = {};
    var count = 1;
    $scope.$watch('scrapName',function () {
        if(count == 1){
            $scope.oneScrap.typeName = "金属";
            $scope.oneScrap.name = "铁板";
            $scope.oneScrap.unitPrice = 1.3;
            $scope.scrapImageUrl = '../resources/images/scrap2.png';
            count = 2;
        }
        else{
            $scope.oneScrap.typeName = "金属";
            $scope.oneScrap.name = "铁片";
            $scope.oneScrap.unitPrice = 0.9;
            $scope.scrapImageUrl = '../resources/images/scrap1.png';
            count = 1;
        }
    })
});

clientCtrl.controller('myAddressCtrl',function ($scope,clientFty) {
    $scope.myAddress = clientFty.addressInfo;
    $scope.reviseAddress = function (index) {
        clientFty.editAddressData = clientFty.addressInfo[index];
        clientFty.editAddressData.index = index;
        clientFty.editAddressData.editType = "revise";
        window.location.href = "#!/addAddress";
    };
    $scope.add = function () {
        clientFty.editAddressData = {"address":"请选择地址信息"};
        clientFty.editAddressData.editType = "add";
        window.location.href = "#!/addAddress";
    };
});

clientCtrl.controller('addAddressCtrl',function ($scope,clientFty) {
    $(document).ready(function(){
        function G(id) {
            return document.getElementById(id);
        }
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
                $scope.addressLng = pp.lng;
                $scope.addressLat = pp.lat;
                map.centerAndZoom(pp, 18);
                map.addOverlay(new BMap.Marker(pp));    //添加标注
            }
            var local = new BMap.LocalSearch(map, { //智能搜索
                onSearchComplete: myFun
            });
            local.search(myValue);
        }
    });
    $scope.edit = false;
    $scope.search = false;
    $scope.name = clientFty.editAddressData.name;
    $scope.phoneNumber = clientFty.editAddressData.phoneNumber;
    $scope.address = clientFty.editAddressData.address;
    $scope.specificAddress = clientFty.editAddressData.specificAddress;
    $scope.editType = clientFty.editAddressData.editType;
    $scope.index = clientFty.editAddressData.index;
    $scope.searchAddress = function () {
        $scope.edit = true;
        $scope.search = true;
    };
    $scope.confirmAddress = function () {
        $scope.search = false;
        $scope.edit = false;
    };
    $scope.submitAddress = function () {
        var data = {"name":$scope.name,"phoneNumber":$scope.phoneNumber,"address":$scope.address,"specificAddress":$scope.specificAddress,"point":{"lng":$scope.addressLng,"lat":$scope.addressLat}};
        if($scope.editType=="revise"){
            clientFty.reviseAddress($scope.index,data);
            window.location.href = "#!/myAddress";
        }
        else{
            clientFty.addAddress(data);
            window.location.href = "#!/myOrders";
        }
    }
});

var stationCtrl = angular.module('stationCtrl',[]);

stationCtrl.controller('stationViewCtrl',function ($scope) {
});

stationCtrl.controller('sOrderCtrl',function ($scope,stationFty) {
    $(".title").css('border','0');
    $("#orderManage").css('border-bottom','2px solid grey');
    var date = new Date();
    $scope.filDay = "-1";
    $scope.filType = "-1";
    $scope.dayPerMon = [31,28,31,30,31,30,31,31,30,31,30,31];
    $scope.year = date.getFullYear();
    $scope.page = 0;
    $scope.allOrders = [];
    $scope.index = [];
    $scope.pages = [];
    $scope.day = [];
    for(var i=0;i<2;i++){
        for(var t=0;t<18;t++){
            var tt = i*18+t;
            $scope.allOrders.push({"time":"2018-4-5 13:13","address":"杭州市西湖区北山路","clientName":"张花","scrap":"纸板1.3kg 铁片0.7kg","orderType":0,"price":"3.4元","colName":"张晔"+tt});
        }
    }
    for(var i=0;i<3;i++){
        for(var t=0;t<18;t++){
            var tt = i*18+t;
            $scope.allOrders.push({"time":"2018-4-12 13:13","address":"杭州市西湖区北山路","clientName":"张花","scrap":"纸板1.3kg 铁片0.7kg","orderType":1,"price":"3.4元","colName":"张晔"+tt});
        }
    }
    for(var i=0;i<2;i++){
        for(var t=0;t<18;t++){
            var tt = i*18+t;
            $scope.allOrders.push({"time":"2018-4-12 13:13","address":"杭州市西湖区北山路","clientName":"张花","scrap":"纸板1.3kg 铁片0.7kg","orderType":0,"price":"3.4元","colName":"张晔"+tt});
        }
    }
    for(var i=0;i<$scope.allOrders.length;i++){
        if($scope.allOrders[i].orderType==0){
            $scope.allOrders[i].orderType = "未完成";
            $scope.allOrders[i].orderColor = "color0";
        }
        else if($scope.allOrders[i].orderType==1){
            $scope.allOrders[i].orderType = "已完成";
            $scope.allOrders[i].orderColor = "color1";
        }
    }
    $scope.pageNum = parseInt(($scope.allOrders.length+17)/18);
    for(var i=0;i<$scope.pageNum;i++){
        $scope.pages[i] = i;
    }
    for(var i=0;i<18;i++){
        $scope.index[i] = i;
    }
    var swiperY = new Swiper('.swiperY', {
        pagination: {
            el: '.swiper-pagination',
            dynamicBullets: true
        }
        // on:{
        //     slideChange:function () {
        //         $scope.year = $(this.slides[this.activeIndex]).text();
        //     }
        // }
    });
    for(var i=0;i<3;i++){
        var temp = $scope.year - i;
        swiperY.appendSlide('<div class="swiper-slide">'+temp+'年</div>')
    }
    $scope.gotoPage = function (index) {
        $scope.page = index;
        $(".page").css('color','white');
        var idStr = "page"+index;
        $("#"+idStr).css('color','black');
    };
    $scope.filterData = function () {
        var data = {};
        if($scope.filDay!="-1"){
            data.time = $scope.year+"-"+$scope.month+"-"+$scope.filDay;
        }
        else data.time = $scope.year+"-"+$scope.month;
        if($scope.filType!="-1"){
            data.orderType = $scope.filType;
        }
        if($scope.filName!=""){
            data.colName = $scope.filName;
        }
        // $scope.allOrders = stationFty.orders;
        // $scope.allOrders.splice(0,36);
        // $scope.allOrders.splice(0,18);
    };
    $scope.chooseMon = function (event) {
        var tempM = $(event.target).attr('id');
        var tempY = $(".swiper-slide-active").text();
        $scope.year = parseInt(tempY.substring(0,tempY.length));
        $scope.month = parseInt(tempM.substring(1,tempM.length));
        $(".item").css({"color":"black","border-right":"2px solid grey"});
        $("#"+tempM).css({"color":"rgb(1,207,207)","border-right":"2px solid rgb(1,207,207)"});
        var day;
        if($scope.month==2&&($scope.year % 4 == 0) && ($scope.year % 100 != 0 || $scope.year % 400 == 0)){
            day = 29;
        }
        else{
            day = $scope.dayPerMon[$scope.month-1];
        }
        for(var i=0;i<day;i++){
            $scope.day[i] = i+1;
        }
    }
});

stationCtrl.controller('sColCtrl',function ($scope,$http,stationFty) {
    $(".title").css('border','0');
    $("#collectorManage").css('border-bottom','2px solid grey');
    // stationFty.getCollectors();
    $scope.noEdit = true;
    $scope.filType = "name";
    $scope.colTable = true;
    $scope.colInfo = true;
    $scope.menu = false;
    $scope.page = 0;
    $scope.orderPage = 0;
    $scope.orderPages = [];
    $scope.pages = [];
    $scope.index = [];
    $scope.oneCol = {};
    $scope.collectorInfo = [];
    $scope.collectorInfo = stationFty.collectors;
    for(var i=0;i<7;i++){
        for(var t=0;t<18;t++){
            var temp = i*18+t;
            $scope.collectorInfo.push({"name":"张晔"+t,"gender":"女","cId":temp,"idNumber":"330327199909093344","entryTime":"2018-4-11","dealNum":304,"community":"四季花苑","colColor":"color1"});
        }
    }
    $scope.pageNum = parseInt(($scope.collectorInfo.length+17)/18);
    for(var i=0;i<18;i++){
        $scope.index[i] = i;
    }
    for(var i=0;i<$scope.pageNum;i++){
        $scope.pages[i] = i;
    }
    $scope.query = function () {
        $scope.colTable = false;
        $scope.menu = true;
    };
    $scope.gotoPage = function (index) {
        $scope.page = index;
        $(".page").css('color','white');
        var idStr = "page"+index;
        $("#"+idStr).css('color','black');
    };
    $scope.gotoOrderPage = function (index) {
        $scope.orderPage = index;
        $(".page").css('color','white');
        var idStr = "orderPage"+index;
        $("#"+idStr).css('color','black');
    };
    $scope.filterData = function () {
        // $scope.collectorInfo.splice(1,9999);
        var data = {};
        data[$scope.filType] = $scope.filData;
        $scope.collectorInfo = stationFty.selectCollectors(data);
    };
    $scope.saveInfo = function () {
        var data = {"name":$scope.oneCol.name,"gender":$scope.oneCol.gender,"cId":$scope.oneCol.cId,"idNumber":$scope.oneCol.idNumber,"entryTime":$scope.oneCol.entryTime,"dealNum":$scope.oneCol.dealNum,"community":$scope.oneCol.community};
        $scope.noEdit = true;
    };
    $scope.getColInfo = function (index) {
        $scope.oneCol = $scope.collectorInfo[index];
        $scope.oneCol.orders = [];
        $scope.colInfo = false;
        $scope.colTable = true;
        // var data = {"cId":$scope.oneCol.cId};
        // stationFty.getOrderByCid(data);
        // $scope.oneCol.orders = stationFty.ordersOfOne;
        for(var i=0;i<5;i++){
            for(var t=0;t<18;t++){
                var tt = i*18+t;
                $scope.oneCol.orders.push({"time":"2018-4-12 13:13","address":"杭州市西湖区北山路","clientName":"张花"+tt,"scrap":"纸板1.3kg 铁片0.7kg","orderType":"已完成","price":"3.4元","colName":"张晔","orderColor":"color1"});
            }
        }
        var len = parseInt(($scope.oneCol.orders.length+17)/18);
        for(var i=0;i<len;i++){
            $scope.orderPages[i] = i;
        }
    };
});

stationCtrl.controller('scrapCtrl',function ($scope) {
    $scope.noEdit = true;
    $scope.scrapInfo = true;
    $scope.scrapTable = false;
    $scope.index = [];
    $scope.scraps = [];
    $scope.oneScrap = {};
    $scope.scrapPages = [];
    $scope.page = 0;
    for(var i=0;i<18;i++){
        $scope.index[i] = i;
    }
    for(var i=0;i<6;i++){
        for(var t=0;t<18;t++){
            var tt = i*18+t;
            $scope.scraps.push({"sId":tt,"typeName":"金属","name":"铁片"+tt,"unitPrice":1.2,"monthVolume":345,"totalVolume":4473});
        }
    }
    for(var i=0;i<parseInt(($scope.scraps.length+17)/18);i++){
        $scope.scrapPages[i] = i;
    }
    $scope.filterData = function () {
        // $scope.scraps.splice(1,999);
    };
    $scope.search = function () {
        $scope.scrapInfo = true;
        $scope.scrapTable = false;
    };
    $scope.add = function () {
        $scope.scrapInfo = false;
        $scope.scrapTable = true;
        $scope.noEdit = false;
        $scope.oneScrap = {};
    };
    $scope.gotoScrapPage = function (index) {
        $scope.page = index;
        $(".page").css('color','white');
        $("#"+"scrapPage"+index).css('color','black');
    };
    $scope.getScrapInfo = function (index) {
        $scope.oneScrap = $scope.scraps[index];
        $scope.scrapTable = true;
        $scope.scrapInfo = false
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
