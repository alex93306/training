function initialize() {
    var mapOptions= {
        center: new google.maps.LatLng(40.782710, -73.965311),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        zoom:13

    };
    var venueMap;
    venueMap = new google.maps.Map(document.getElementById('map'), mapOptions);

}
/*google.maps.event.addDomListener(window, 'load', initialize);*/
function loadScript() {
    var script=document.createElement('script');
    script.src='http://maps.googleapis.com/maps/api/js?sensor=false&callback=initialize';
    document.body.appendChild(script);
}
window.onload=loadScript;
