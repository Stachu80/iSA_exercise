<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="/bank">
    <div id ="header">Kalkulator kredytowy</div><br/>
    <span>${warning}</span>
    Kwota kredytu <input type="number" class="form-control" placeholder="wpisz kwote kredytu" name="credit" autofocus value="${credit}">
    <br/>
    Okres kredytowania <input type="number" class="form-control" placeholder="wpisz okres kredytowania" name="month" autofocus value="${month}">
    <br/>
    Oprocentowanie <input type="number" class="form-control" placeholder="oprocentowanie w skali roku" name="interest" autofocus value="${interest}">
    <br/>
    Prowizja <input type="number" class="form-control" placeholder="wpisz prowizię banku" name="commission" autofocus value="${commission}">
    <br/>
    <input type="submit" name="" value="oblicz"/>
    <br/>
</form>

