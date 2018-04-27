var clientService = angular.module('clientService',[]);

clientService.factory('clientFty',function ($http) {
    var service = {
        editAddressData:{"address":"请选择地址信息"},
        ordersAroundInfo:[{"lng":120.156084,"lat":30.265202},{"lng":120.158013,"lat":30.265706},{"lng":120.15542,"lat":30.26681}],
        addressInfo:[
            {"address":"杭州市西湖区北山路","name":"张三","phoneNumber":"13758158273","specificAddress":"北山路173号","point":{"lng":120.156911,"lat":30.265529}},
            {"address":"杭州市西湖区北山路小区","name":"李四","phoneNumber":"13758158279","specificAddress":"12幢609单元","point":{"lng":120.156084,"lat":30.265202}}
        ],
        orderInfo:[
            {"address":"杭州市西湖区北山路","type":"待接单","time":"2018-4-6 15:15","name":"张三","server":{"name":"李四","phone":"13758158273","id":134},"weight":{"塑料":"1.2kg","纸板":"0.9kg"},"scoreType":0,"orderId":17},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 15:15","name":"张三","server":{"name":"李四","phone":"13758158273","id":134},"weight":{"塑料":"1.2kg","纸板":"0.9kg"},"scoreType":0,"orderId":18},
            {"address":"杭州市西湖区北山路","type":"已完成","time":"2018-4-6 15:15","name":"张三","server":{"name":"李四","phone":"13758158273","id":134},"weight":{"塑料":"1.2kg","纸板":"0.9kg"},"scoreType":1,"orderId":19,"price":"3.4元"},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
            {"address":"杭州市西湖区北山路","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}}
        ],
        submitOrder:function (data) {
            service.orderInfo.unshift(data);
            // $http({
            //     method:"post",
            //     url:"submitOrder",
            //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            //     data:$.param(data)
            // }).success(function () {
            //
            // });
        },
        reviseAddress:function (index,data) {
            service.addressInfo[index] = data;
            // $http({
            //     method:"post",
            //     url:"reviseAddress",
            //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            //     data:$.param(data)
            // }).success(function () {
            //
            // });
        },
        getLocation:function () {
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function(r){
                if(this.getStatus() == BMAP_STATUS_SUCCESS){
                    var pt = new BMap.Point(r.point.lng,r.point.lat);
                    var geoc = new BMap.Geocoder();
                    geoc.getLocation(pt, function(rs){
                        var addComp = rs.addressComponents;
                        service.currentLocation = addComp.city + ", " + addComp.district + ", " + addComp.street;
                        alert(service.currentLocation);
                        return service.currentLocation;
                    });
                }
                else {
                    return "定位失败";
                }
            },{enableHighAccuracy: true});
        },
        getAddress:function () {
            $http({
                method:"post",
                url:"getAddress"
            }).success(function (result) {
                if(result=="false")
                {
                    haveAddress = false;
                }
                else
                {
                    service.haveAddress = true;
                    service.addressInfo = JSON.parse(result);
                }
            });
        },
        addAddress:function (data) {
            service.addressInfo.push(data);
            // $http({
            //     method:"post",
            //     url:"addAddress",
            //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            //     data:$.param(data)
            // }).success(function () {
            //
            // });
        }
    };
    return service;
});

var stationService = angular.module('stationService',[]);

stationService.factory('stationFty',function ($http) {
    var service = {
        ordersOfOne:[],
        collectors:[],
        orders:[],
        getOrders:function (data) {
            $http({
                method:"post",
                url:"getOrders",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data:$.param(data)
            }).success(function (result) {
                service.orders = JSON.parse(result);
            });
        },
        getOrderByCid:function (data) {
            $http({
                method:"post",
                url:"getOrderByCid",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data:$.param(data)
            }).success(function (result) {
                service.ordersOfOne = JSON.parse(result);
            });
        },
        getCollectors:function () {
            $http({
                method:"post",
                url:"getCollectors"
            }).success(function (result) {
                service.collectors = JSON.parse(result);
            });
        },
        selectCollectors:function (data) {
            $http({
                method:"post",
                url:"selectCollectors",
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data:$.param(data)
            }).success(function (result) {
                return JSON.parse(result);
            });
        }
    } ;
    return service;
});
   var service = {
       editAddressData:{"address":"请选择地址信息"},
       haveAddress:false,
       addressInfo:[],
       orderInfo:[
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院西和公寓","type":"待接单","time":"2018-4-6 15:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}},
           {"address":"浙江科技学院东和","type":"待回收","time":"2018-4-6 16:15","name":"江铮","server":{"name":"王宇超","phone":"13758158273"},"weight":{"塑料":"1.2kg","纸板":"0.9kg"}}
       ],
       submitOrder:function (data) {
           service.orderInfo.unshift(data);
           // $http({
           //     method:"post",
           //     url:"submitOrder",
           //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
           //     data:$.param(data)
           // }).success(function () {
           //
           // });
       },
       reviseAddress:function (index,data) {
           service.addressInfo[index] = data;
           // $http({
           //     method:"post",
           //     url:"reviseAddress",
           //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
           //     data:$.param(data)
           // }).success(function () {
           //
           // });
       },
       getLocation:function () {
           var geolocation = new BMap.Geolocation();
           geolocation.getCurrentPosition(function(r){
               if(this.getStatus() == BMAP_STATUS_SUCCESS){
                   var pt = new BMap.Point(r.point.lng,r.point.lat);
                   var geoc = new BMap.Geocoder();
                   geoc.getLocation(pt, function(rs){
                       var addComp = rs.addressComponents;
                       service.currentLocation = addComp.city + ", " + addComp.district + ", " + addComp.street;
                       alert(service.currentLocation);
                       return service.currentLocation;
                   });
               }
               else {
                   return "定位失败";
               }
           },{enableHighAccuracy: true});
       },
       getAddress:function () {
           $http({
               method:"post",
               url:"getAddress"
           }).success(function (result) {
               if(result=="false")
               {
                   haveAddress = false;
               }
               else
               {
                   service.haveAddress = true;
                   service.addressInfo = JSON.parse(result);
               }
           });
       },
       addAddress:function (data) {
           service.addressInfo.push(data);
           // $http({
           //     method:"post",
           //     url:"addAddress",
           //     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
           //     data:$.param(data)
           // }).success(function () {
           //
           // });
       }
   };
   return service;
});
