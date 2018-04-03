var geolocation = new BMap.Geolocation();
geolocation.getCurrentPosition(function(r){
    if(this.getStatus() == BMAP_STATUS_SUCCESS){
        //以指定的经度与纬度创建一个坐标点
        var pt = new BMap.Point(r.point.lng,r.point.lat);
        //创建一个地理位置解析器
        var geoc = new BMap.Geocoder();
        geoc.getLocation(pt, function(rs){//解析格式：城市，区县，街道
            var addComp = rs.addressComponents;
            $("#location").text(addComp.city + ", " + addComp.district + ", " + addComp.street);
        });
    }
    else {
        $("#location").text('定位失败');
    }
},{enableHighAccuracy: true})




