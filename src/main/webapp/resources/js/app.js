var loginApp = angular.module('loginApp',['loginCtrl']);

var clientApp = angular.module('clientApp',['ngRoute','ngAnimate','clientCtrl','clientService']);

clientApp.config(function ($routeProvider) {
    $routeProvider.when('/myOrders',{
        templateUrl:'../tpl/myOrders.jsp',
        controller:'myOrdersCtrl'
    }).when('/myAddress',{
        templateUrl:'../tpl/myAddress.jsp',
        controller:'myAddressCtrl'
    }).when('/addAddress',{
        templateUrl:'../tpl/addAddress.jsp',
        controller:'addAddressCtrl'
    }).when('/orderManage',{
        templateUrl:'../tpl/orderManage.jsp',
        controller:'orderManageCtrl'
    }).otherwise({
        redirectTo:''
    })
});

var stationApp = angular.module('stationApp',['ngRoute','stationCtrl','stationService']);

stationApp.config(function ($routeProvider) {
    $routeProvider.when('/orderManage',{
        templateUrl:'../tpl/sOrderMng.jsp',
        controller:'sOrderCtrl'
    }).when('/collectorManage',{
        templateUrl:'../tpl/sColMng.jsp',
        controller:'sColCtrl'
    }).when('/scrapManage',{
        templateUrl:'../tpl/scrapMng.jsp',
        controller:'scrapCtrl'
    }).when('/communityManage',{
        templateUrl:'../tpl/communityMng.jsp',
        controller:'communityCtrl'
    }).otherwise({
        redirectTo:'/orderManage'
    })
});