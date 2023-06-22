<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 style="text-align: center;"> <s:message code="homepage.kichthuoc.title"/> </h1>
<br>
<div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/kichthuoc/add"><i class="fa-solid fa-circle-plus"></i> <s:message code="homepage.kichthuoc.nutthem"/></a></button></div>
<br>
<table class="table">
<tr>
<td>Id</td>
<td><s:message code="homepage.kichthuoc.ten"/></td>
<td><s:message code="homepage.kichthuoc.chucnang"/></td>
</tr>
<c:forEach items="${list }" var="p">
<c:if test="${p.trangThai == 0 }">
<tr>
<td>${p.idKichThuoc }</td>
<td>${p.tenKichThuoc }</td>
 <td>
            <button type="button" class="btn btn-danger btnSua"> <a href="${pageContext.request.contextPath }/kichthuoc/update/${p.idKichThuoc }"><i class="fa-solid fa-wrench"></i> <s:message code="homepage.kichthuoc.nutsua"/></a></button>
            <button type="button" class="btn btn-warning btnSua" ><a href="${pageContext.request.contextPath }/kichthuoc/delete/${p.idKichThuoc }"><i class="fa-solid fa-trash"></i> <s:message code="homepage.kichthuoc.nutxoa"/></a></button>
 </td>
</tr>
</c:if>
</c:forEach>
</table>
<nav aria-label="Page navigation example">
         
                  <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="index">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?page=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul>
</nav>
