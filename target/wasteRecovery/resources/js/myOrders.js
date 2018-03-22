var formModule = angular.module('myOrder',[]);
formModule.controller('formCtrl',function ($scope) {
    $scope.time1 = [];
    getTime1();
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
});