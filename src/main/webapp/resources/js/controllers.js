
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
$(document).ready(function(){
    map = new BMap.Map("myMap");
    map.enableScrollWheelZoom(true);
    map.centerAndZoom("浙江科技学院",17);
});

var clientCtrl = angular.module('clientCtrl',[]);

clientCtrl.controller('clientViewCtrl',function ($scope) {
    $scope.gotoMyOrders = function () {
        window.location.href = "#!/myOrders";
    };
    $scope.gotoMyAddress = function () {
        window.location.href = "#!/myAddress";
    };
    $scope.gotoOrderManage = function () {
        window.location.href = "#!/orderManage";
    };
});

clientCtrl.controller('orderManageCtrl',function ($scope,clientFty) {
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
});

clientCtrl.controller('myOrdersCtrl',function ($scope,clientFty) {
    map.clearOverlays();
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
    $scope.time = "请选择时间";
    $scope.myAddress = clientFty.addressInfo;
    $scope.haveAddress = $scope.myAddress.length>0;
    $scope.timeTable = true;
    $scope.weight = "<0.5kg";
    $scope.submitOrder = function () {
        var data = $scope.myAddress[parseInt($("#address").val())];
        data.weight = {"约重":$scope.weight};
        getDateStr();
        data.time = $scope.realTime;
        data.type = "待接单";
        if($scope.time == "请选择时间"){
            $("#message").text("请填写时间");
        }
        else{
            clientFty.submitOrder(data);
            window.location.href = "#!/orderManage";
        }
    };

    // $scope.showLocation = function (index) {
    //     map.centerAndZoom($scope.myAddress[index].address,17);
    // };
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
        var data = {"name":$scope.name,"phoneNumber":$scope.phoneNumber,"address":$scope.address,"specificAddress":$scope.specificAddress};
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

