// $(document).ready(function () {
//     var map = new BMap.Map("allmap");
//     map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
//     map.centerAndZoom("杭州市江干区", 13);
//     var geolocation = new BMap.Geolocation();
//     geolocation.getCurrentPosition(function(r){
//         if(this.getStatus() == BMAP_STATUS_SUCCESS){
//             var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
//                 offset: new BMap.Size(10, 25), // 指定定位位置
//                 imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移
//             });
//             var mk = new BMap.Marker(r.point,{icon:myIcon});
//             map.addOverlay(mk);
//             map.panTo(r.point);
//         }
//         else {
//             alert('failed'+this.getStatus());
//         }
//     },{enableHighAccuracy: true})
//     //初始化回收员点
//     //----------------------
//     //初始化用户点
//     //----------------------
//     var pointList =[{lng:"120.01937542",lat:"30.25924446"},{lng:"120.01937542",lat:"30.20924446"}];
//     var list = [];
//     for(var i=0;i<pointList.length;i++){
//        list[i]= new BMap.Marker(new BMap.Point(parseFloat(pointList[i].lng),parseFloat(pointList[i].lat)));
//        list[i].addEventListener("click",getMsg);
//     }
//     function getMsg() {
//         $(http)
//     }
//     for(var o=0;o<list.length;o++){
//         map.addOverlay(list[o]);
//
//     }
//     // map.addOverlay(new BMap.Marker(new BMap.Point(120.01937542,30.25924446)));
//     // map.addOverlay(new BMap.Marker(new BMap.Point(120.01937542,30.20924446)));
// })