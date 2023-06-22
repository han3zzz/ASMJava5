<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
    <h1> <s:message code="homepage.category.titlesua"/> </h1>
    <f:form action="${pageContext.request.contextPath}/category/update" method="post" modelAttribute="data">
 	 <f:input type="hidden" class="form-control"  id="exampleInputEmail1" name="ten" value="${cate.id }" path="id"/>
                  <label for="exampleInputEmail1"> <s:message code="homepage.category.ten"/> * :</label>
    <f:input type="text" class="form-control"  id="exampleInputEmail1" name="ten" value="${cate.ten }" path="ten"/>
     <f:errors style="color:red" path="ten" element="div"></f:errors>
      <br>
      <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i>  <s:message code="homepage.category.sua"/></button>

              </f:form>
        </div>
<br>
