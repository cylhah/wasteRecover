var clientApp = angular.module('clientApp',['ngRoute','ngAnimate','clientCtrl','clientService','clientDirective']);

clientApp.config(function ($routeProvider) {
    $routeProvider.when('/myOrders',{
        templateUrl:'../tpl/myOrders.jsp',
        controller:'myOrdersCtrl'
    }).when('/myAddress',{
        templateUrl:'../tpl/myAddress.jsp',
        controller:'myAddressCtrl'
    }).when('/orderManage',{
        templateUrl:'../tpl/orderManage.jsp',
        controller:'orderManageCtrl'
    }).otherwise({
        redirectTo:'/myOrders'
    })
});

var loginApp = angular.module('loginApp',['loginCtrl']);

var testApp = angular.module('testApp',['testCtrl','ngRoute']);

testApp.config(function($routeProvider){
    $routeProvider.when('/list',{
        templateUrl:'list.html',
        controller:'listCtrl'
    }).when('/history',{
        templateUrl:'history.html',
        controller:'historyCtrl'
    }).otherwise({
        redirect:'/list'
    })
});
