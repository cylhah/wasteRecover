<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/11
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=1bskosXE4iAXX6BSVt5X5XFn90530zyU"></script>
</head>
<body>
<div id="getLocation">
    点击获取地理位置
</div>
</body>
</html>

<script type="text/javascript">
    $(function(){
        $("#getLocation").click(function(ev){
            $(ev.currentTarget).text("正在获取位置......");
            //创建百度地图控件
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function(r){
                if(this.getStatus() == BMAP_STATUS_SUCCESS){
                    //以指定的经度与纬度创建一个坐标点
                    var pt = new BMap.Point(r.point.lng,r.point.lat);
                    //创建一个地理位置解析器
                    var geoc = new BMap.Geocoder();
                    geoc.getLocation(pt, function(rs){//解析格式：城市，区县，街道
                        var addComp = rs.addressComponents;
                        $(ev.currentTarget).text(addComp.city + ", " + addComp.district + ", " + addComp.street);
                    });
                }
                else {
                    $(ev.currentTarget).text('定位失败');
                }
            },{enableHighAccuracy: true})//指示浏览器获取高精度的位置，默认false
        });
    });
</script>
