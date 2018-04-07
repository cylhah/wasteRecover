var clientService = angular.module('clientService',[]);

clientService.factory('clientFty',function ($http) {
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