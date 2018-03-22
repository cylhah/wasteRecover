var addressModule = angular.module('myAddress',[]);
addressModule.controller('addressCtrl',function ($scope) {
    $scope.edit = true;
    $scope.add = function () {
        $scope.edit = !$scope.edit;
    }
});