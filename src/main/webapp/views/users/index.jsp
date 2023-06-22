<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 style="text-align: center;"> <s:message code="homepage.account.title"/> </h1>
<br>
<div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/account/add"><i class="fa-solid fa-circle-plus"></i> <s:message code="homepage.account.nutthem"/></a></button></div>
<br>
<table class="table">
<tr>
<td><s:message code="homepage.account.username"/></td>
<td><s:message code="homepage.account.password"/></td>
<td>Email</td>
<td><s:message code="homepage.account.vaitro"/></td>
<td><s:message code="homepage.account.chucnang"/></td>
</tr>
<c:forEach items="${list }" var="p">
<tr>
<td>${p.username }</td>
<td>${p.password }</td>
<td>${p.email }</td>
<td><c:if test="${p.role == 0 }"><s:message code="homepage.account.vaitro1"/></c:if><c:if test="${p.role == 1 }"><s:message code="homepage.account.vaitro2"/></c:if></td>
 <td>
            <button type="button" class="btn btn-danger btnSua"> <a href="${pageContext.request.contextPath }/account/update/${p.username }"><i class="fa-solid fa-wrench"></i> <s:message code="homepage.account.nutsua"/></a></button>
            <button type="button" class="btn btn-warning btnSua" ><a href="${pageContext.request.contextPath }/account/delete/${p.username }"><i class="fa-solid fa-trash"></i> <s:message code="homepage.account.nutxoa"/></a></button>
        </td>
</tr>
</c:forEach>
</table>
<nav aria-label="Page navigation example">
         
                  <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="users">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?pageNum=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul>
</nav>