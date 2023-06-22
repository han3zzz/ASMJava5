<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container">
		<h1><s:message code="homepage.admin.product.titlesua"/></h1>
		<f:form
			action="${pageContext.request.contextPath}/admin/update"
			method="post" enctype="multipart/form-data" modelAttribute="data">

			<f:input type="hidden" name="id" path="id" value="${p.id }" />
			<div class="form-group">
				<label for="exampleFormControlFile1"> <s:message code="homepage.admin.product.anh"/> *:</label> <input
					type="file" class="form-control-file" id="fileUpload" name="file" />
			</div>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.tieude"/> * :</label>
			<f:input type="text" class="form-control" name="tieude"
				id="exampleInputEmail1" 
				path="tieude" value="${p.tieuDe }" />
				<f:errors style="color:red" path="tieude" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.gia"/> *</label>
			<f:input type="number" class="form-control" id="exampleInputEmail1"
				 name="gia" path="gia"
				value="${p.gia }" />
				<f:errors style="color:red" path="gia" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.giamgia"/> (%)</label>
			<f:input type="number" class="form-control" id="exampleInputEmail1"
				 name="giamgia"
				path="giamgia" value="${p.giamGia }" />
				<f:errors style="color:red" path="giamgia" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.phanloai"/> *</label>
			<f:select class="form-control" id="exampleFormControlSelect1"
				name="phanloai" path="phanloai">
				<c:forEach items="${listCategory }" var="c">
					<option value="${c.id }"
						${c.id ==  p.category.id ? 'selected="selected"' : ''}>${c.ten }</option>
				</c:forEach>


			</f:select>

			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.soluong"/> *</label>
			<br>


			<c:forEach items="${listKichThuoc }" var="kt">
				<label style="padding-left: 5px">${kt.kichThuoc.tenKichThuoc }</label>
				<input style="width: 50px" type="number"
					name="${kt.kichThuoc.tenKichThuoc }" value="${kt.soLuong}">
			</c:forEach>


			<br>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.mota"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="mota" path="mota"
				value="${p.moTa }" />
				<f:errors style="color:red" path="mota" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.chatlieu"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="chatlieu"
				path="chatlieu" value="${p.chatLieu }" />
				<f:errors style="color:red" path="chatlieu" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.thietke"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="thietke" path="thietke"
				value="${p.thietKe }" />
				<f:errors style="color:red" path="thietke" element="div"></f:errors>
			<br>
			<button type="submit" class="btn btn-danger">
				<i class="fa-solid fa-plus"></i> <s:message code="homepage.admin.product.nutsua"/>
			</button>

		</f:form>
	</div>
	<br>
