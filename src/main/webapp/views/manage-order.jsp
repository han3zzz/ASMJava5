<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <h1 class="giua"> <s:message code="homepage.manageorder.title"/> </h1>
      <br>
      <table class="table">
      <tr>
      <td><s:message code="homepage.manageorder.id"/></td>
       <td><s:message code="homepage.manageorder.ngaymua"/></td>
       <td><s:message code="homepage.manageorder.username"/></td>
       <td><s:message code="homepage.manageorder.nguoinhan"/></td>
       <td><s:message code="homepage.manageorder.sdt"/></td>
       <td><s:message code="homepage.manageorder.diachi"/></td>
       <td><s:message code="homepage.manageorder.trangthai"/></td>
       <td><s:message code="homepage.manageorder.hanhdong"/></td>
      </tr>
      <c:forEach items="${listHoaDon }" var="p">
      <tr>
      <td>${p.idHoaDon }</td>
       <td>${p.ngayTao }</td>
       <td>${p.username.username }</td>
       <td>${p.nguoiNhan }</td>
       <td>${p.soDienThoai }</td>
       <td>${p.diaChi }</td>
       <td>
       <c:if test="${p.trangThai == 0 }"><p style="color:green;"><i class="fa-solid fa-circle-check"></i> <s:message code="homepage.manageorder.trangthai1"/></p></c:if>
       <c:if test="${p.trangThai == 1 }"><p style="color:red;"><i class="fa-solid fa-circle-minus"></i> <s:message code="homepage.manageorder.trangthai2"/></p></c:if>
       <c:if test="${p.trangThai == 2 }"><p style="color:blue;"><i class="fa-solid fa-thumbs-up"></i> <s:message code="homepage.manageorder.trangthai3"/></p></c:if>
       </td>
       <td>
       	<c:if test="${p.trangThai !=0 }">
     	 <button class="btn btn-info"><a style="color: white; text-decoration: none;"  href="${pageContext.request.contextPath }/manage-order/chitiet/${p.idHoaDon }" ><s:message code="homepage.manageorder.chitiet"/></a></button>
     	</c:if>
     	 <c:if test="${p.trangThai == 0 }">
     	  <button class="btn btn-info"><a style="color: white; text-decoration: none;"  href="${pageContext.request.contextPath }/manage-order/chitiet/${p.idHoaDon }" ><s:message code="homepage.manageorder.chitiet"/></a></button>
     	 <button class="btn btn-danger"><a style="color: white; text-decoration: none;" href="${pageContext.request.contextPath }/manage-order/huy/${p.idHoaDon }"><s:message code="homepage.manageorder.trangthai2"/></a></button>
     	 <button class="btn btn-success"><a style="color: white; text-decoration: none;" href="${pageContext.request.contextPath }/manage-order/thanhtoan/${p.idHoaDon }"><s:message code="homepage.manageorder.trangthai3"/></a></button>
     	 </c:if>
     	 
       </td>
      </tr>
      </c:forEach>
      
      </table>
  <nav aria-label="Page navigation example">
         
                  <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="donhang">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?pageNum=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul>
</nav>
