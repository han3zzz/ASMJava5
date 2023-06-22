<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <h1 class="giua"><i class="fa-solid fa-bolt"></i><s:message code="homepage.index.title"/></h1>
      <br>
      <div class="container" >
        <div class="row">
          <c:forEach items="${list }" var="p">
          <div class="col-md-3 col-6">
            <div class="thumbnail xoagach">
              <a href="detail/${p.id }">
                <div class="anhsp"><c:if test="${p.giamGia > 0 }"><span class="giamgia1" >- ${p.giamGia}%</span></c:if><img src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Lights" style="width:100%"></div>
                <div class="tensp">
                  ${fn:toUpperCase(p.tieuDe)}
                </div>
              </a>
             <div class="line"><p class="money"> <fmt:formatNumber>${p.giaDaGiam}</fmt:formatNumber> VNĐ</p>
             <p class="gach"><c:if test="${p.giamGia >0 }"><fmt:formatNumber>${p.gia}</fmt:formatNumber> VNĐ</c:if></p>
              
            </div>
              <br>
              <div>
                <button class="nutthemgio"><a href="detail/${p.id }"><i class="fa-solid fa-cart-shopping"></i><p class="gian"><s:message code="homepage.index.nut"/></p></a></button>
              </div>
            </div>
            <!-- <div class="ribbon-wrap">
               <div class="ribbon"> TẠM HẾT HÀNG</div>
            </div> -->
        </div>
          </c:forEach>
          <nav aria-label="Page navigation example">
          </div>
                   <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="index">1</a></li>
                  <c:forEach begin="2" end="${count }"  var="i">
                  <li class="page-item"><a class="page-link" href="?pageNum=${i}">${i }</a></li>
                  </c:forEach>
   
  </ul> 
</nav>
      </div>

      <br>
