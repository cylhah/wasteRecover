var loginApp = angular.module('loginApp',['loginCtrl']);

<<<<<<< HEAD
=======
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
>>>>>>> 7c1b81c26b6ac12d4ae2a0899a4a81a632641908
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
<<<<<<< HEAD

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
=======
>>>>>>> 7c1b81c26b6ac12d4ae2a0899a4a81a632641908
