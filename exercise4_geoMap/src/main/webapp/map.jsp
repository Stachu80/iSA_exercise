<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="map"></div>
<c:choose>
    <c:when test="${latitude!= null && longitude!= null}">

        <script>
            function initMap() {
                var uluru = {lat: ${latitude}, lng: ${longitude}};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 10,
                    center: uluru
                });
                var marker = new google.maps.Marker({
                    position: uluru,
                    map: map
                });
            }
        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=${key}&callback=initMap"
                type="text/javascript"></script>

    </c:when>
</c:choose>
