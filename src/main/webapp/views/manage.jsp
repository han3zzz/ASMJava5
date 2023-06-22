<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${account.role == 0 }">
<div class="container">
<h1 style="text-align: center;"> <s:message code="homepage.manage.title"/> </h1>
<br>
	<button class="btn btn-success"><a style="color: white; text-decoration: none;" href="admin"><s:message code="homepage.manage.product"/></a></button>
	<button class="btn btn-secondary"><a style="color: white; text-decoration: none;" href="account"><s:message code="homepage.manage.account"/></a></button>
	<button class="btn btn-info"><a style="color: white; text-decoration: none;" href="category"><s:message code="homepage.manage.category"/></a></button>
	<button class="btn btn-danger"><a style="color: white; text-decoration: none;" href="manage-order"><s:message code="homepage.manage.donhang"/></a></button>
	<button class="btn btn-secondary"><a style="color: white; text-decoration: none;" href="kichthuoc"><s:message code="homepage.manage.kichthuoc"/></a></button>
</div>
<br>
</c:if>
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>