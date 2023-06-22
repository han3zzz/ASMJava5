<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 		<c:if test="${account == null}">
      <h3> Bạn không có quyền truy cập chức năng này</h3>
      </c:if>
      <c:if test="${account != null }">
      <div class="container" >
        <input type="hidden" value="${account.username }" name="userGH">
        <c:out value="${sessionScope.userGH}"/>
       
    <h1 class="giua"><i class="fa-solid fa-cart-shopping"></i> <s:message code="homepage.cart.title"/> </h1>
    <br>
    <div class="row">
    <div class="col-md-9">
    <div class="giohang">
        <table class="table">
            <thead>
              <tr>
                <th scope="col" colspan="5.5"><s:message code="homepage.cart.ten"/></th></div>
                <th scope="col" colspan="1"><s:message code="homepage.cart.kichthuoc"/></th>
                <th scope="col" colspan="1"><s:message code="homepage.cart.dongia"/></th>
                <th scope="col" colspan="1"><s:message code="homepage.cart.soluong"/></th>
                <th scope="col" colspan="1"><s:message code="homepage.cart.thanhtien"/></th>
                <th scope="col" colspan="1"></th>
              </tr>
            </thead>
            <tbody>
             <c:if test="${fn:length(listCart) == 0}">
            <tr>
            <td> <s:message code="homepage.cart.khongcosp"/><td>
            </tr>
             </c:if>
             <c:if test="${fn:length(listCart) > 0}">
              <c:forEach items="${listCart }" var="p">
               <tr>
                <th colspan="5.5"><div class="cart-img"><img src="${pageContext.request.contextPath}/views/img/${p.product.anh }"> ${p.product.tieuDe } </div></th>
                <td colspan="1"> ${p.kichThuoc }</td>
                <td colspan="1"><fmt:formatNumber>${p.donGia }</fmt:formatNumber></td>
                <td colspan="1"><span><a style="color:red;" href="${pageContext.request.contextPath }/cart/giam?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-minus"></i></a></span> <span>${p.soLuong }</span> <span ><a style="color:green;" href="${pageContext.request.contextPath }/cart/them?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-plus"></i></a></span></td>
                <td colspan="1"><fmt:formatNumber>${p.soLuong * p.donGia }</fmt:formatNumber></td>
                <td class="xoa" colspan="1"><a style="color: black" href="${pageContext.request.contextPath}/cart/delete?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-trash"></i></a></td>
              </tr>
              
              </c:forEach>
             </c:if>
            </tbody>
          </table>
    </div>
    </div>
    <div class="col-md-3">
     <div style="height: 100% ; width: 100%"><h4> <s:message code="homepage.cart.thongtin"/></h4>
  <f:form action="${pageContext.request.contextPath }/cart/thanhtoan" method="post" modelAttribute="data">
   <label for="exampleInputEmail1"><s:message code="homepage.cart.tennguoinhan"/> * :</label>
    <f:input type="text" class="form-control" name="tennguoinhan" id="exampleInputEmail1" placeholder="" path="tenNguoiNhan"/>
     <f:errors style="color:red" path="tenNguoiNhan" element="div"></f:errors>
     <label for="exampleInputEmail1"><s:message code="homepage.cart.sdt"/> * :</label>
    <f:input type="number" class="form-control" name="sdtnguoinhan" id="exampleInputEmail1" placeholder="" path="sdtNguoiNhan"/>
     <f:errors style="color:red" path="sdtNguoiNhan" element="div"></f:errors>
      <label for="exampleInputEmail1"><s:message code="homepage.cart.diachi"/> * :</label>
    <f:input type="text" class="form-control" name="diachinguoinhan" id="exampleInputEmail1" placeholder="" path="diaChiNguoiNhan"/>
     <f:errors style="color:red" path="diaChiNguoiNhan" element="div"></f:errors>
     <br>
      <div class="thanhtien"><s:message code="homepage.cart.tongtien"/> : <span><fmt:formatNumber>${tongTien }</fmt:formatNumber> VNĐ</span></div><br>
    
      <div class="nutthanhtoan">
        <button class="nutthemgiott" type="submit"><a href="#"><i class="fa-brands fa-cc-apple-pay"></i><p class="gian"><s:message code="homepage.cart.thanhtoan"/></p></a></button>
      </div>
  </f:form>
     </div>
    </div>
    </div>
   	<br>
      
      <div class="nutthanhtoan1">
        <button class="nutthemgiott1"><a href="${pageContext.request.contextPath }/index"><i class="fa-solid fa-angle-left"></i><p class="gian"><s:message code="homepage.cart.tieptuc"/></p></a></button>
      </div>
      <br>


      </div>
      <br>
      </c:if>
