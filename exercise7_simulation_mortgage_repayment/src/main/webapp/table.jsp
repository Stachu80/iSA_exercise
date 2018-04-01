<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <c:choose>
        <c:when test="${repayment.size()>0}">
            <div class="row">
                <div class="col-sm">
                        <%--One of three columns--%>
                </div>
                <div class="col-sm">
                    <div class="info">Harmonogram spłat</div>
                    <div class="info">RRSO wynosi ${rrso} %</div>
                    <div class="info">Całkowita kwota do spłaty: ${theTotalAmountToBeRepaid} zł</div>

                </div>
                <div class="col-sm">
                        <%--One of three columns--%>
                </div>
            </div>
            <div class="row">

                <table id="myTable" class="table table-fixedheader table-dark">
                    <thead>
                    <tr>
                        <th width="20%" scope="col">okres spłaty</th>
                        <th width="20%" scope="col">Spłacany kapitał</th>
                        <th width="20%" scope="col">Spłacane odsetki</th>
                        <th width="20%" scope="col">Rata</th>
                        <th width="20%" scope="col">Do spłaty</th>
                    </tr>
                    </thead>
                    <tbody style="height:400px">

                    <c:forEach var="row" items="${repayment}" varStatus="index">

                        <tr>
                            <td width="20%"><c:out value="${index.count}"/></td>
                            <td width="20%"><c:out value=""/>${row.getCapital()} zł</td>
                            <td width="20%"><c:out value=""/>${row.getInterrest()} zł</td>
                            <td width="20%"><c:out value=""/>${installment} zł</td>
                            <td width="20%"><c:out value=""/>${repayment.size()*installment - (index.count-1)*installment}
                                zł
                            </td>

                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </c:when>
    </c:choose>
</div>



