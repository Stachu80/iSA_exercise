<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/exercise4_geoMap/geomaps">
    <div id ="header">Google Map</div><br/>
    <span>${warning}</span>
    <input type="text" class="form-control" placeholder="wpisz szukaną lokalizację" name="adress" autofocus>
    <br/>
    <input type="submit" name="" value="znajdź"/>
    <br/>
</form>

