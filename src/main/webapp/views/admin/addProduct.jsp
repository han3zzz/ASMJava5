<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="container">
		<h1> <s:message code="homepage.admin.product.titlethem"/> </h1>
		<f:form action="${pageContext.request.contextPath}/admin/add"
			method="post" enctype="multipart/form-data" modelAttribute="data">

			<div class="form-group">
				<label for="exampleFormControlFile1"> <s:message code="homepage.admin.product.anh"/> *:</label> <input
					type="file" class="form-control-file" id="fileUpload" name="file" />
			</div>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.tieude"/> * :</label>
			<f:input type="text" class="form-control" name="tieude"
				id="exampleInputEmail1"
				path="tieude" />
			 <f:errors style="color:red" path="tieude" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.gia"/> *</label>
			<f:input type="number" class="form-control" id="exampleInputEmail1"
				name="gia" path="gia" />
				<f:errors style="color:red" path="gia" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.giamgia"/> (%)</label>
			<f:input type="number" class="form-control" id="exampleInputEmail1"
				 value="0" name="giamgia"
				path="giamgia" />
				<f:errors style="color:red" path="giamgia" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.phanloai"/> *</label>
			<f:select class="form-control" id="exampleFormControlSelect1"
				name="phanloai" path="phanloai">
				<f:options items="${listCategory }" itemValue="id" itemLabel="ten" />
			</f:select>

			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.soluong"/> *</label>
			<br>

			<!--                   <input  type="checkbox" name="kichthuoc" id="inlineCheckbox1" value="S">S -->
			<!--                   <input type="checkbox" name="kichthuoc" id="inlineCheckbox1" value="M">M -->
			<!--                   <input type="checkbox" name="kichthuoc" id="inlineCheckbox1" value="L">L -->
			<!--                   <input type="checkbox" name="kichthuoc" id="inlineCheckbox1" value="XL">XL -->
			<!--                   <input type="checkbox" name="kichthuoc" id="inlineCheckbox1" value="XXL">XXL -->

			<c:forEach items="${listKichThuoc }" var="kt">
				<label style="padding-left: 5px">${kt.tenKichThuoc }</label>
				<input style="width: 50px" type="number" name="${kt.tenKichThuoc }"
					value="0">
			</c:forEach>


			<br>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.mota"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="mota" path="mota" />
				<f:errors style="color:red" path="mota" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.chatlieu"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="chatlieu"
				path="chatlieu" />
				<f:errors style="color:red" path="chatlieu" element="div"></f:errors>
			<label for="exampleInputEmail1"><s:message code="homepage.admin.product.thietke"/> * :</label>
			<f:input type="text" class="form-control" id="exampleInputEmail1"
				 name="thietke" path="thietke" />
				<f:errors style="color:red" path="thietke" element="div"></f:errors>
			<br>
			<button type="submit" class="btn btn-danger">
				<i class="fa-solid fa-plus"></i> <s:message code="homepage.admin.product.nutthem"/>
			</button>

		</f:form>
	</div>
	<br>