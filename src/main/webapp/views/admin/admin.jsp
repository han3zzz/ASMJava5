<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<h1 style="text-align: center;"> <s:message code="homepage.admin.title"/> </h1>
	<br>
	<div class="btnThem">
		<button type="button" class="btn btn-secondary">
			<a href="${pageContext.request.contextPath }/admin/add"><i
				class="fa-solid fa-circle-plus"></i> <s:message code="homepage.admin.nutthem"/></a>
		</button>
	</div>
	<br>
	<table class="table">
		<tr>
			<td>ID</td>
			<td><s:message code="homepage.admin.anh"/></td>
			<td><s:message code="homepage.admin.tieude"/></td>
			<td><s:message code="homepage.admin.gia"/></td>
			<!-- <td>Số lượng</td> -->
			<td><s:message code="homepage.admin.chucnang"/></td>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr>
				<td>${p.id }</td>
				<td><img
					src="${pageContext.request.contextPath }/views/img/${p.anh}"
					height="100" width="100"></td>
				<td>${p.tieuDe }</td>
				<td>${p.gia }</td>
				<%-- <td>${p.soLuong }</td> --%>
				<td>
					<button type="button" class="btn btn-danger btnSua">
						<a
							href="${pageContext.request.contextPath }/admin/update/${p.id }"><i
							class="fa-solid fa-wrench"></i> <s:message code="homepage.admin.nutsua"/></a>
					</button>
					<button type="button" class="btn btn-warning btnSua">
						<a
							href="${pageContext.request.contextPath }/admin/delete/${p.id }"><i
							class="fa-solid fa-trash"></i> <s:message code="homepage.admin.nutxoa"/></a>
					</button>
				</td>
			</tr>
		</c:forEach>
		<!-- Modal -->

	</table>
	<nav aria-label="Page navigation example">

		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="admin">1</a></li>
			<c:forEach begin="2" end="${count }" var="i">
				<li class="page-item"><a class="page-link" href="?pageNum=${i}">${i }</a></li>
			</c:forEach>

		</ul>
	</nav>