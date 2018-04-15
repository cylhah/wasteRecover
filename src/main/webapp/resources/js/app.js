var loginApp = angular.module('loginApp',['loginCtrl']);

//列表显示页面-----------------------------------------------------------

var listApp = angular.module('listApp',['allListCtrl','ngRoute']);

// listApp.config(function($routeProvider){
//     $routeProvider.when('/list',{
//         templateUrl:'list.html',
//         controller:'listCtrl'
//     }).when('/history',{
//         templateUrl:'historyList.html',
//         controller:'historyCtrl'
//     }).otherwise({
//         redirect:'/history'
//     })
// });

var receiverApp = angular.module('receiverApp',['ngRoute','orderMsgCtrl']);

receiverApp.config(function ($routeProvider) {
    $routeProvider.when('/orderMsg',{
        templateUrl:'orderMsg.html',
        controller:'orderMsgOne'
    }).when('/checkOrderMsg',{
        templateUrl:'checkOrderMsg.html',
        controller:'checkOrderMsg'
    }).otherwise({
        redirect:'/'
    })
});

var checkScrapApp = angular.module('checkScrapApp',['ngRoute','checkScrapCtrl']);
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
