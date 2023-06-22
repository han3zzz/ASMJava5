<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
    <h1><s:message code="homepage.account.titlesua"/> </h1>
    <p style="color: red">${message }</p>
    <f:form action="${pageContext.request.contextPath}/account/update" method="post" modelAttribute="data" enctype="multipart/form-data">
 
                <label for="exampleInputEmail1"><s:message code="homepage.account.username"/> * :</label>
    <f:input type="text" class="form-control"  id="exampleInputEmail1" name="username" value="${account.username }" readonly="true" path="username"/>
                  <label for="exampleInputEmail1"><s:message code="homepage.account.password"/> * :</label>
    <f:input type="text" class="form-control"  id="exampleInputEmail1"  name="password" value="${account.password }" path="password"/>
    <f:errors style="color:red" path="password" element="div"></f:errors>
       <label for="exampleInputEmail1">Email * :</label>
    <f:input type="text" class="form-control" id="exampleInputEmail1"  name="email" value="${account.email }" path="email"/>
    <f:errors style="color:red" path="email" element="div"></f:errors>
       <label for="exampleInputEmail1"><s:message code="homepage.account.vaitro"/> * :</label>
    <f:select class="form-control" id="exampleFormControlSelect1" name="role" path="role">
        <option ${account.role == 0 ? "selected" : ""} value="0"><s:message code="homepage.account.vaitro1"/></option>
        <option ${account.role == 1 ? "selected" : ""} value="1"><s:message code="homepage.account.vaitro2"/></option>
      </f:select>
      <br>
      <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> <s:message code="homepage.account.sua"/></button>
              </f:form>
        </div>
<br>