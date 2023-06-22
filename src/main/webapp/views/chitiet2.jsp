<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 <h1 class="giua"> <s:message code="homepage.orderdetail.title"/> #${id }</h1>
      <br>
      <table class="table">
      <tr>
      <td><s:message code="homepage.orderdetail.ten"/></td>
       <td><s:message code="homepage.orderdetail.kichthuoc"/></td>
       <td><s:message code="homepage.orderdetail.soluong"/></td>
       <td><s:message code="homepage.orderdetail.dongia"/></td>
      </tr>
     <c:forEach items="${list }" var="p">
      <tr>
      <td>${p.product.tieuDe }</td>
       <td>${p.kichThuoc }</td>
       <td>${p.soLuong }</td>
       <td>${p.donGia }</td>
      </tr>
     </c:forEach>
      
      </table>
      <button class="btn btn-info"><a style="color: white;text-decoration: none;" href="${pageContext.request.contextPath }/manage-order"><s:message code="homepage.orderdetail.nut"/></a></button>
      
 </div>
 <br>
